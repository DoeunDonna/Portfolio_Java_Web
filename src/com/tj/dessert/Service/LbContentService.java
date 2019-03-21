package com.tj.dessert.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.LearnMeBoardDao;
import com.tj.dessert.dao.ReplyDao;
import com.tj.dessert.dto.LearnMeBoardDto;
import com.tj.dessert.dto.ReplyDto;

public class LbContentService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int lbNum = Integer.parseInt(request.getParameter("lbNum"));
		LearnMeBoardDao lbDao = new LearnMeBoardDao();
		LearnMeBoardDto lbDto = lbDao.lbContentView(lbNum);
		request.setAttribute("lbContent_view", lbDto);
		
		ReplyDao rDao = new ReplyDao();
		
		ArrayList<ReplyDto> rlist = rDao.rList(lbNum);
		request.setAttribute("rlist", rlist);
				
	}

}
