package com.tj.dessert.Service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.dessert.dao.CustomerDao;
import com.tj.dessert.dto.CustomerDto;

public class CJoinService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String cId = request.getParameter("cId");
			String cPw = request.getParameter("cPw");
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
			
			int cIdResult = cDao.cIdConfirm(cId);
			int cNickResult = cDao.cNickConfirm(cNick);
			
			if(cIdResult == CustomerDao.NONEXISTENT && cNickResult == CustomerDao.NONEXISTENT) {
				cIdResult = cDao.joinCustomer(cDto);
				if(cIdResult == CustomerDao.SUCCESS && cNickResult == CustomerDao.SUCCESS) {
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("cId", cId);
					httpSession.setAttribute("cNick", cNick);
					request.setAttribute("resultMsg","회원가입이 완료되었습니다");
				}else {
					request.setAttribute("errorMsg", "회원가입이 실패 되었습니다");
				}
			}else if(cIdResult == CustomerDao.EXISTENT){
				request.setAttribute("errorMsg", "중복된 ID입니다");
				
			}else if(cNickResult == CustomerDao.EXISTENT){
				request.setAttribute("errorMsg", "중복된 별명입니다");
			}

		}catch(Exception e){
			System.out.println("CJoinService : "+e.getMessage());
		}

	}

}
