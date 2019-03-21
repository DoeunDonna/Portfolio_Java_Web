package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.DessertInformDao;

public class DiDeleteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int diNum = Integer.parseInt(request.getParameter("diNum"));
		DessertInformDao diDao = new DessertInformDao();
		int result = diDao.diDelete(diNum);
		if(result == DessertInformDao.SUCCESS) {
			request.setAttribute("resultMsg", "글삭제 성공");
		}else {
			request.setAttribute("resultMsg", "글삭제 실패");
		}
	}

}
