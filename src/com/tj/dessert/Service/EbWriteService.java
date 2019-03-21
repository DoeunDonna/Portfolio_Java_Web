package com.tj.dessert.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.dessert.dao.EatMeBoardDao;

public class EbWriteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = request.getRealPath("SourcePicUp");
		int maxSize = 1024*1024*10;
		MultipartRequest ebRequest = null;
		String[] ebFileName = {"","","","","","","","","",""};
		
		try {
			ebRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = ebRequest.getFileNames();	//file이랑 짝지어진 parameter를 가지고 온다
			int i = 9;
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				ebFileName[i] = ebRequest.getFilesystemName(param);
				i--;
			}
			
			String cId = ebRequest.getParameter("cId");
			String ebSubject = ebRequest.getParameter("ebSubject");
			String ebContent = ebRequest.getParameter("ebContent");
			String ebFileName01 = ebFileName[0];
			String ebFileName02 = ebFileName[1];
			String ebFileName03 = ebFileName[2];
			String ebFileName04 = ebFileName[3];
			String ebFileName05 = ebFileName[4];
			String ebFileName06 = ebFileName[5];
			String ebFileName07 = ebFileName[6];
			String ebFileName08 = ebFileName[7];
			String ebFileName09 = ebFileName[8];
			String ebFileName10 = ebFileName[9];
			String ebIp = request.getRemoteAddr(); //자동적으로  ip를 받아오는 함수
			
			EatMeBoardDao ebDao = new EatMeBoardDao();
			
			int result = ebDao.ebWrite(cId, ebSubject, ebContent, ebFileName01, ebFileName02, ebFileName03, ebFileName04, ebFileName05, ebFileName06, ebFileName07, ebFileName08, ebFileName09, ebFileName10, ebIp);
			if(result == EatMeBoardDao.SUCCESS) {
				request.setAttribute("resultMsg", "글쓰기 성공");
			}else {
				request.setAttribute("resultMsg", "글쓰기 실패");
				request.setAttribute("error", "error입니다");
			}
		
		} catch (Exception e) {
			System.out.println("EbWriteERROR :"+ e.getMessage());
			request.setAttribute("errorMsg", "5mega이하의 사진을 첨부해주세요");
		}
		
	//서버에 올라간 mPhoto 파일을 소스폴더에 filecopy
		for(String ebf : ebFileName) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File file = new File(path+"/"+ebf);
				
				if(file.exists()) {
					is = new FileInputStream(file);
					os = new FileOutputStream("D:/mega-IT/Source/0_Portfolio/ImDessert/WebContent/SourcePicUp/"+ebf);
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
