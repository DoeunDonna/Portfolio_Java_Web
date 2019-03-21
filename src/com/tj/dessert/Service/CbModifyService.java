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
import com.tj.dessert.dao.CookMeBoardDao;
import com.tj.dessert.dto.CookMeBoardDto;

public class CbModifyService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("SourcePicUp");
		int maxSize = 1024*1024*10;
		MultipartRequest cbRequest = null;
		String[] cbFileName = {"","","","","","","","","",""};
		
		try {
			cbRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = cbRequest.getFileNames();	//file이랑 짝지어진 parameter를 가지고 온다
				
			int i = 9;
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				cbFileName[i] = cbRequest.getFilesystemName(param);
				i--;
			}
			
			int cbNum = Integer.parseInt(cbRequest.getParameter("cbNum"));
			String cId = cbRequest.getParameter("cId");
			String cbSubject = cbRequest.getParameter("cbSubject");
			String cbContent01 = cbRequest.getParameter("cbContent01");
			String cbContent02 = cbRequest.getParameter("cbContent02");
			String cbContent03 = cbRequest.getParameter("cbContent03");
			String cbContent04 = cbRequest.getParameter("cbContent04");
			String cbContent05 = cbRequest.getParameter("cbContent05");
			String cbContent06 = cbRequest.getParameter("cbContent06");
			String cbContent07 = cbRequest.getParameter("cbContent07");
			String cbContent08 = cbRequest.getParameter("cbContent08");
			String cbContent09 = cbRequest.getParameter("cbContent09");
			String cbContent10 = cbRequest.getParameter("cbContent10");
			
			String cbFileName01 = cbFileName[0];
			String dbFileName01 = cbRequest.getParameter("dbFileName01");
			if(cbFileName01==null) {
				cbFileName01 = dbFileName01;
			}
			String cbFileName02 = cbFileName[1];
			String dbFileName02 = cbRequest.getParameter("dbFileName02");
			if(cbFileName02==null) {
				cbFileName02 = dbFileName02;
			}
			String cbFileName03 = cbFileName[2];
			String dbFileName03 = cbRequest.getParameter("dbFileName03");
			if(cbFileName03==null) {
				cbFileName03 = dbFileName03;
			}
			String cbFileName04 = cbFileName[3];
			String dbFileName04 = cbRequest.getParameter("dbFileName04");
			if(cbFileName04==null) {
				cbFileName04 = dbFileName04;
			}
			String cbFileName05 = cbFileName[4];
			String dbFileName05 = cbRequest.getParameter("dbFileName05");
			if(cbFileName05==null) {
				cbFileName05 = dbFileName05;
			}
			String cbFileName06 = cbFileName[5];
			String dbFileName06 = cbRequest.getParameter("dbFileName06");
			if(cbFileName06==null) {
				cbFileName06 = dbFileName06;
			}
			String cbFileName07 = cbFileName[6];
			String dbFileName07 = cbRequest.getParameter("dbFileName07");
			if(cbFileName07==null) {
				cbFileName07 = dbFileName07;
			}
			String cbFileName08 = cbFileName[7];
			String dbFileName08 = cbRequest.getParameter("dbFileName08");
			if(cbFileName08==null) {
				cbFileName08 = dbFileName08;
			}
			String cbFileName09 = cbFileName[8];
			String dbFileName09 = cbRequest.getParameter("dbFileName09");
			if(cbFileName09==null) {
				cbFileName09 = dbFileName09;
			}
			String cbFileName10 = cbFileName[9];
			String dbFileName10 = cbRequest.getParameter("dbFileName10");
			if(cbFileName10==null) {
				cbFileName10 = dbFileName10;
			}
			String cbIp = request.getRemoteAddr(); //자동적으로  ip를 받아오는 함수
			
			CookMeBoardDao cbDao = new CookMeBoardDao();
			CookMeBoardDto dto = new CookMeBoardDto(cbNum, cId, null, cbSubject, cbContent01, cbContent02, cbContent03, cbContent04, cbContent05, cbContent06, cbContent07, cbContent08, cbContent09, cbContent10, cbFileName01, cbFileName02, cbFileName03, cbFileName04, cbFileName05, cbFileName06, cbFileName07, cbFileName08, cbFileName09, cbFileName10, null, 0, cbIp);
			
			int result = cbDao.cbModify(cbNum, cbSubject, cbContent01, cbContent02, cbContent03, cbContent04, cbContent05, cbContent06, cbContent07, cbContent08, cbContent09, cbContent10, cbFileName01, cbFileName02, cbFileName03, cbFileName04, cbFileName05, cbFileName06, cbFileName07, cbFileName08, cbFileName09, cbFileName10, cbIp);
			if(result == CookMeBoardDao.SUCCESS) {
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
		for(String cbf : cbFileName) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File file = new File(path+"/"+cbf);
				
				if(file.exists()) {
					is = new FileInputStream(file);
					os = new FileOutputStream("D:/mega-IT/Source/0_Portfolio/ImDessert/WebContent/SourcePicUp/"+cbf);
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
