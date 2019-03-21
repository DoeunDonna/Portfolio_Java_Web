package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.CustomerDao;
import com.tj.dessert.dto.CustomerDto;

public class ACusModifyService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cId = request.getParameter("cId");
			String cNick = request.getParameter("cNick");
			
			int lNum = Integer.parseInt(request.getParameter("lNum"));
			
			
			CustomerDto cDto = new CustomerDto(cId, null, null, cNick, lNum, null, null, null, null, null, null);
			CustomerDao cDao = new CustomerDao();
			
			int result = cDao.modifyCusLevel(cDto);
			if(result == CustomerDao.SUCCESS) {
				request.setAttribute("modifyResultMsg", "회원등급 변경이 완료되었습니다");
			}else {
				request.setAttribute("modifyErrorMsg", "회원등급 변경이 실패되었습니다");
			}
		}catch(Exception e){
			System.out.println("aCusModifyService : "+e.getMessage());
		}
	

	}

}
