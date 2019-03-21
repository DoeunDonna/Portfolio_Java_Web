package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.dessert.dao.AdminDessertDao;
import com.tj.dessert.dto.AdminDessertDto;

public class ALoginService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		AdminDessertDao aDao = new AdminDessertDao();
		int result = aDao.adminLoginCheck(aId, aPw);
		
		if(result == AdminDessertDao.LOGIN_SUCCESS) {
			HttpSession httpSession = request.getSession();
			AdminDessertDto aDto = aDao.getAdmin(aId);
			httpSession.setAttribute("aId", aId);
			httpSession.setAttribute("admin", aDto);
			request.setAttribute("adminloginResult", "관리자 계정으로 들어오셨습니다");
		}else{
			request.setAttribute("adminloginResult", "관리자 아이디 혹은 비밀번호를 확인하세요");
			request.setAttribute("error", "error");
		}

	}

}
