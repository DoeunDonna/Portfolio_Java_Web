package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.CookMeBoardDao;
import com.tj.dessert.dto.CookMeBoardDto;

public class CbModifyViewService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cbNum = Integer.parseInt(request.getParameter("cbNum"));
		CookMeBoardDao cbDao = new CookMeBoardDao();
		CookMeBoardDto cbDto = cbDao.cbModifyView(cbNum);
		request.setAttribute("cbModify_view", cbDto);


	}

}
