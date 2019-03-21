package com.tj.dessert.Service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.dessert.dao.CustomerDao;
import com.tj.dessert.dto.CustomerDto;

public class CDeleteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cId = request.getParameter("cId");
			String cPw = request.getParameter("cPw");
			String cName = request.getParameter("cName");
			String cNick = request.getParameter("cNick");
			int lNum = 5;
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
			
			int result = cDao.DeleteCustomer(cDto);
			if(result == CustomerDao.SUCCESS) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("customer", cDto);
				request.setAttribute("DeleteResultMsg", "회원탈퇴가 완료되어 '현실로 돌아간 앨리스'가 되셨습니다");
			}else {
				request.setAttribute("DeleteErrorMsg", "회원탈퇴가 실패되었습니다");
			}
		}catch(Exception e){
			System.out.println("CModifyService : "+e.getMessage());
		}

	}

}
