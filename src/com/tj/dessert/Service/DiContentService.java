package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.DessertInformDao;
import com.tj.dessert.dto.DessertInformDto;

public class DiContentService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int diNum = Integer.parseInt(request.getParameter("diNum"));
		DessertInformDao diDao = new DessertInformDao();
		DessertInformDto diDto = diDao.diContentView(diNum);
		request.setAttribute("diContent_view", diDto);
	}

}
