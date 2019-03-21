package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.dessert.dao.CustomerDao;
import com.tj.dessert.dto.CustomerDto;

public class CLoginService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cId = request.getParameter("cId");
		String cPw = request.getParameter("cPw");
		CustomerDao cDao = new CustomerDao();
		int result = cDao.cusLoginCheck(cId, cPw);
		
		if(result == CustomerDao.LOGIN_SUCCESS) {
			HttpSession httpSession = request.getSession();
			CustomerDto cDto = cDao.getCustomer(cId);
			httpSession.setAttribute("cId", cId);
			httpSession.setAttribute("customer", cDto);
			request.setAttribute("loginMsg", "님 어서오세요");
		}else if(result == CustomerDao.LOGIN_FAIL_PW || result == CustomerDao.LOGIN_FAIL_ID) {
			request.setAttribute("loginErrorMsg", "아이디 혹은 비밀번호를 잘못 입력하셨습니다");
		}
	}

}
