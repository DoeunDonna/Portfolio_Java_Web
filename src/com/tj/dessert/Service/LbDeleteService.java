package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.LearnMeBoardDao;

public class LbDeleteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int lbNum = Integer.parseInt(request.getParameter("lbNum"));
		LearnMeBoardDao lbDao = new LearnMeBoardDao();
		int result = lbDao.lbDelete(lbNum);
		if(result == LearnMeBoardDao.SUCCESS) {
			request.setAttribute("resultMsg", "글삭제 성공");
		}else {
			request.setAttribute("resultMsg", "글삭제 실패");
		}
	}

}
