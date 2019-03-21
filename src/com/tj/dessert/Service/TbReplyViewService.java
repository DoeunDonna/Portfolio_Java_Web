package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.TalkMeBoardDao;
import com.tj.dessert.dto.TalkMeBoardDto;

public class TbReplyViewService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int tbNum = Integer.parseInt(request.getParameter("tbNum"));
		TalkMeBoardDao tbDao = new TalkMeBoardDao();
		TalkMeBoardDto tbDto = tbDao.tbModifyView_tbReplyView(tbNum);
		request.setAttribute("tbReply_view", tbDto);
		System.out.println(tbDto);
	}

}
