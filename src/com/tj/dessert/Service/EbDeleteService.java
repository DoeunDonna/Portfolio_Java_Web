package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.EatMeBoardDao;

public class EbDeleteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int ebNum = Integer.parseInt(request.getParameter("ebNum"));
		EatMeBoardDao ebDao = new EatMeBoardDao();
		int result = ebDao.ebDelete(ebNum);
		if(result == EatMeBoardDao.SUCCESS) {
			request.setAttribute("resultMsg", "글삭제 성공");
		}else {
			request.setAttribute("resultMsg", "글삭제 실패");
		}
	}

}
