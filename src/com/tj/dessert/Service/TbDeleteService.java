package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.TalkMeBoardDao;

public class TbDeleteService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int tbNum = Integer.parseInt(request.getParameter("tbNum"));
		TalkMeBoardDao tbDao = new TalkMeBoardDao();
		int result = tbDao.tbDelete(tbNum);
		if(result == TalkMeBoardDao.SUCCESS) {
			request.setAttribute("resultMsg", "글삭제 성공");
		}else {
			request.setAttribute("resultMsg", "글삭제 실패");
		}
	}

}
