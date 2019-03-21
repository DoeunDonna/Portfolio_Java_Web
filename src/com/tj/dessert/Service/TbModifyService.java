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
import com.tj.dessert.dao.TalkMeBoardDao;

public class TbModifyService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("SourcePicUp");
		int maxSize = 1024*1024*10;
		MultipartRequest tbRequest = null;
		String[] tbFileName = {"","","","",""};
		
		try {
			tbRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = tbRequest.getFileNames();	//file이랑 짝지어진 parameter를 가지고 온다
				
			int i = 4;
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				tbFileName[i] = tbRequest.getFilesystemName(param);
				i--;
			}
			
			int tbNum = Integer.parseInt(tbRequest.getParameter("tbNum"));
			String cId = tbRequest.getParameter("cId");
			String tbSubject = tbRequest.getParameter("tbSubject");
			String tbContent = tbRequest.getParameter("tbContent");
			
			String tbFileName01 = tbFileName[0];
			String dbFileName01 = tbRequest.getParameter("dbFileName01");
			if(tbFileName01==null) {
				tbFileName01 = dbFileName01;
			}
			String tbFileName02 = tbFileName[1];
			String dbFileName02 = tbRequest.getParameter("dbFileName02");
			if(tbFileName02==null) {
				tbFileName02 = dbFileName02;
			}
			String tbFileName03 = tbFileName[2];
			String dbFileName03 = tbRequest.getParameter("dbFileName03");
			if(tbFileName03==null) {
				tbFileName03 = dbFileName03;
			}
			String tbFileName04 = tbFileName[3];
			String dbFileName04 = tbRequest.getParameter("dbFileName04");
			if(tbFileName04==null) {
				tbFileName04 = dbFileName04;
			}
			String tbFileName05 = tbFileName[4];
			String dbFileName05 = tbRequest.getParameter("dbFileName05");
			if(tbFileName05==null) {
				tbFileName05 = dbFileName05;
			}
			String tbIp = request.getRemoteAddr(); //자동적으로  ip를 받아오는 함수
			
			TalkMeBoardDao tbDao = new TalkMeBoardDao();
			
			int result = tbDao.tbModify(tbNum, tbSubject, tbContent, tbFileName01, tbFileName02, tbFileName03, tbFileName04, tbFileName05, tbIp);
			if(result == TalkMeBoardDao.SUCCESS) {
				request.setAttribute("resultMsg", "글수정 성공");
			}else {
				request.setAttribute("resultMsg", "글수정 실패");
				request.setAttribute("error", "error입니다");
			}
		
		} catch (Exception e) {
			System.out.println("TbWriteERROR :"+ e.getMessage());
			request.setAttribute("errorMsg", "5mega이하의 사진을 첨부해주세요");
		}
		
	//서버에 올라간 mPhoto 파일을 소스폴더에 filecopy
		for(String tbf : tbFileName) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File file = new File(path+"/"+tbf);
				
				if(file.exists()) {
					is = new FileInputStream(file);
					os = new FileOutputStream("D:/mega-IT/Source/0_Portfolio/ImDessert/WebContent/SourcePicUp/"+tbf);
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
