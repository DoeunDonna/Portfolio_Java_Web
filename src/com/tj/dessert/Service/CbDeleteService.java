package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.CookMeBoardDao;

public class CbDeleteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cbNum = Integer.parseInt(request.getParameter("cbNum"));
		CookMeBoardDao cbDao = new CookMeBoardDao();
		int result = cbDao.cbDelete(cbNum);
		if(result == CookMeBoardDao.SUCCESS) {
			request.setAttribute("resultMsg", "글삭제 성공");
		}else {
			request.setAttribute("resultMsg", "글삭제 실패");
		}
	}

}
