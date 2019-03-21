package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.EatMeBoardDao;
import com.tj.dessert.dto.EatMeBoardDto;

public class EbContentService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int ebNum = Integer.parseInt(request.getParameter("ebNum"));
		EatMeBoardDao ebDao = new EatMeBoardDao();
		EatMeBoardDto ebDto = ebDao.ebContentView(ebNum);
		request.setAttribute("ebContent_view", ebDto);
	}

}
