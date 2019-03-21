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
import com.tj.dessert.dao.TalkMeBoardDao;

public class TbWriteService implements DService {

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
			
			String cId = tbRequest.getParameter("cId");
			String tbSubject = tbRequest.getParameter("tbSubject");
			String tbContent = tbRequest.getParameter("tbContent");
			String tbFileName01 = tbFileName[0];
			String tbFileName02 = tbFileName[1];
			String tbFileName03 = tbFileName[2];
			String tbFileName04 = tbFileName[3];
			String tbFileName05 = tbFileName[4];
			String tbIp = request.getRemoteAddr(); //자동적으로  ip를 받아오는 함수
			
			TalkMeBoardDao tbDao = new TalkMeBoardDao();
			
			int result = tbDao.tbWrite(cId, tbSubject, tbContent, tbFileName01, tbFileName02, tbFileName03, tbFileName04, tbFileName05, tbIp);
			if(result == TalkMeBoardDao.SUCCESS) {
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
		for(String tbf : tbFileName) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File file = new File(path+"\\"+tbf);
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
