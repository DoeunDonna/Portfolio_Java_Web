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
import com.tj.dessert.dao.EatMeBoardDao;

public class EbModifyService implements DService {

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
			
			int ebNum = Integer.parseInt(ebRequest.getParameter("ebNum"));
			String cId = ebRequest.getParameter("cId");
			String ebSubject = ebRequest.getParameter("ebSubject");
			String ebContent = ebRequest.getParameter("ebContent");
			
			String ebFileName01 = ebFileName[0];
			String dbFileName01 = ebRequest.getParameter("dbFileName01");
			if(ebFileName01==null) {
				ebFileName01 = dbFileName01;
			}
			String ebFileName02 = ebFileName[1];
			String dbFileName02 = ebRequest.getParameter("dbFileName02");
			if(ebFileName02==null) {
				ebFileName02 = dbFileName02;
			}
			String ebFileName03 = ebFileName[2];
			String dbFileName03 = ebRequest.getParameter("dbFileName03");
			if(ebFileName03==null) {
				ebFileName03 = dbFileName03;
			}
			String ebFileName04 = ebFileName[3];
			String dbFileName04 = ebRequest.getParameter("dbFileName04");
			if(ebFileName04==null) {
				ebFileName04 = dbFileName04;
			}
			String ebFileName05 = ebFileName[4];
			String dbFileName05 = ebRequest.getParameter("dbFileName05");
			if(ebFileName05==null) {
				ebFileName05 = dbFileName05;
			}
			String ebFileName06 = ebFileName[5];
			String dbFileName06 = ebRequest.getParameter("dbFileName06");
			if(ebFileName06==null) {
				ebFileName06 = dbFileName06;
			}
			String ebFileName07 = ebFileName[6];
			String dbFileName07 = ebRequest.getParameter("dbFileName07");
			if(ebFileName07==null) {
				ebFileName07 = dbFileName07;
			}
			String ebFileName08 = ebFileName[7];
			String dbFileName08 = ebRequest.getParameter("dbFileName08");
			if(ebFileName08==null) {
				ebFileName08 = dbFileName08;
			}
			String ebFileName09 = ebFileName[8];
			String dbFileName09 = ebRequest.getParameter("dbFileName09");
			if(ebFileName09==null) {
				ebFileName09 = dbFileName09;
			}
			String ebFileName10 = ebFileName[9];
			String dbFileName10 = ebRequest.getParameter("dbFileName10");
			if(ebFileName10==null) {
				ebFileName10 = dbFileName10;
			}
			String ebIp = request.getRemoteAddr(); //자동적으로  ip를 받아오는 함수
			
			EatMeBoardDao ebDao = new EatMeBoardDao();
			
			int result = ebDao.ebModify(ebNum, ebSubject, ebContent, ebFileName01, ebFileName02, ebFileName03, ebFileName04, ebFileName05, ebFileName06, ebFileName07, ebFileName08, ebFileName09, ebFileName10, ebIp);
			if(result == EatMeBoardDao.SUCCESS) {
				request.setAttribute("resultMsg", "글수정 성공");
			}else {
				request.setAttribute("resultMsg", "글수정 실패");
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
