package com.tj.dessert.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.LearnMeBoardDao;
import com.tj.dessert.dao.ReplyDao;
import com.tj.dessert.dto.LearnMeBoardDto;
import com.tj.dessert.dto.ReplyDto;

public class LbRegisterService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int lbNum = Integer.parseInt(request.getParameter("lbNum"));
		String cId= request.getParameter("cId");
		String rMemo = request.getParameter("rMemo");
		String rIp = request.getRemoteAddr();
		ReplyDao rDao = new ReplyDao();
		int result = rDao.rWrite(lbNum, cId, rMemo, rIp);
		request.setAttribute("replyResult", result);
	}

}
