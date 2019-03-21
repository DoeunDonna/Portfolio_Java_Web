package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.CookMeBoardDao;
import com.tj.dessert.dto.CookMeBoardDto;

public class CbContentService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cbNum = Integer.parseInt(request.getParameter("cbNum"));
		CookMeBoardDao cbDao = new CookMeBoardDao();
		CookMeBoardDto cbDto = cbDao.cbContentView(cbNum);
		request.setAttribute("cbContent_view", cbDto);
	}

}
