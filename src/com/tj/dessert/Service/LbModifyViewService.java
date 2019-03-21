package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.LearnMeBoardDao;
import com.tj.dessert.dto.LearnMeBoardDto;

public class LbModifyViewService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int lbNum = Integer.parseInt(request.getParameter("lbNum"));
		LearnMeBoardDao lbDao = new LearnMeBoardDao();
		LearnMeBoardDto lbDto = lbDao.lbModifyView(lbNum);
		request.setAttribute("lbModify_view", lbDto);


	}

}
