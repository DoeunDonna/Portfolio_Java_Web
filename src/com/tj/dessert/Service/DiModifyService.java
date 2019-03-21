package com.tj.dessert.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.dessert.dao.DessertInformDao;

public class DiModifyService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("SourcePicUp");
		int maxSize = 1024*1024*10;
		MultipartRequest diRequest = null;
		String[] diFileName = {"","","","",""};
		
		try {
			diRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = diRequest.getFileNames();	//file이랑 짝지어진 parameter를 가지고 온다
				
			int i = 4;
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				diFileName[i] = diRequest.getFilesystemName(param);
				i--;
			}
			
			int diNum = Integer.parseInt(diRequest.getParameter("diNum"));
			String aId = diRequest.getParameter("aId");
			String diSubject = diRequest.getParameter("diSubject");
			String diContent = diRequest.getParameter("diContent");
			
			String diFileName01 = diFileName[0];
			String dbFileName01 = diRequest.getParameter("dbFileName01");
			if(diFileName01==null) {
				diFileName01 = dbFileName01;
			}
			String diFileName02 = diFileName[1];
			String dbFileName02 = diRequest.getParameter("dbFileName02");
			if(diFileName02==null) {
				diFileName02 = dbFileName02;
			}
			String diFileName03 = diFileName[2];
			String dbFileName03 = diRequest.getParameter("dbFileName03");
			if(diFileName03==null) {
				diFileName03 = dbFileName03;
			}
			String diFileName04 = diFileName[3];
			String dbFileName04 = diRequest.getParameter("dbFileName04");
			if(diFileName04==null) {
				diFileName04 = dbFileName04;
			}
			String diFileName05 = diFileName[4];
			String dbFileName05 = diRequest.getParameter("dbFileName05");
			if(diFileName05==null) {
				diFileName05 = dbFileName05;
			}
			String diIp = request.getRemoteAddr(); //자동적으로  ip를 받아오는 함수
			
			DessertInformDao diDao = new DessertInformDao();
			
			int result = diDao.diModify(diNum, diSubject, diContent, diFileName01, diFileName02, diFileName03, diFileName04, diFileName05, diIp);
			if(result == DessertInformDao.SUCCESS) {
				request.setAttribute("resultMsg", "글수정 성공");
			}else {
				request.setAttribute("resultMsg", "글수정 실패");
				request.setAttribute("error", "error입니다");
			}
		
		} catch (Exception e) {
			System.out.println("DiWriteERROR :"+ e.getMessage());
			request.setAttribute("errorMsg", "5mega이하의 사진을 첨부해주세요");
		}
		
	//서버에 올라간 mPhoto 파일을 소스폴더에 filecopy
		for(String dif : diFileName) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File file = new File(path+"/"+dif);
				
				if(file.exists()) {
					is = new FileInputStream(file);
					os = new FileOutputStream("D:/mega-IT/Source/0_Portfolio/ImDessert/WebContent/SourcePicUp/"+dif);
					byte[] bs = new byte[(int)file.length()];
					while(true) {
						int nByteCnt = is.read(bs);
						if(nByteCnt==-1) {
							break;
						}
						os.write(bs, 0, nByteCnt);
					}
				}
			}catch (Exception e) {
				System.out.println("파일업로드 에러:"+e.getMessage());
			} finally {
				try {
					if(os != null) {
						os.close();
					}
					if(is != null) {
						is.close();
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		
		}	

	}

}
