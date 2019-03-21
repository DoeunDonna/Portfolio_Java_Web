package com.tj.dessert.Service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.dessert.dao.CustomerDao;
import com.tj.dessert.dto.CustomerDto;

public class CModifyService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cId = request.getParameter("cId");
			String cPw = request.getParameter("cPwNew");
			if(cPw.equals("")) {
				cPw = request.getParameter("cPw");
			}
			String cName = request.getParameter("cName");
			String cNick = request.getParameter("cNick");
			int lNum = Integer.parseInt(request.getParameter("lNum"));
			String lName = request.getParameter("lName");
			Date cBirth = null;
			String cBirthStr = request.getParameter("cBirth");
			if(!cBirthStr.equals("")) {
				cBirth = Date.valueOf(cBirthStr);
			}
			String cGender = request.getParameter("cGender");
			String cPhone1 = request.getParameter("cPhone1");
			String cPhone2 = request.getParameter("cPhone2");
			String cPhone3 = request.getParameter("cPhone3");
			
			CustomerDto cDto = new CustomerDto(cId, cPw, cName, cNick, lNum, lName, cBirth, cGender, cPhone1, cPhone2, cPhone3);
			CustomerDao cDao = new CustomerDao();
			
			int result = cDao.modifyCustomer(cDto);
			if(result == CustomerDao.SUCCESS) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("customer", cDto);
				request.setAttribute("modifyResultMsg", "회원수정이 완료되었습니다");
			}else {
				request.setAttribute("modifyErrorMsg", "회원수정이 실패되었습니다");
			}
		}catch(Exception e){
			System.out.println("CModifyService : "+e.getMessage());
		}

	}

}
