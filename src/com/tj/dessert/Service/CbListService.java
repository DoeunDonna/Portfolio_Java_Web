package com.tj.dessert.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.CookMeBoardDao;
import com.tj.dessert.dto.CookMeBoardDto;

public class CbListService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=15, BLOCKSIZE=10;
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		CookMeBoardDao cbDao = new CookMeBoardDao();
		ArrayList<CookMeBoardDto> list = cbDao.cbList(startRow, endRow);
		request.setAttribute("list", list);
		int totCnt = cbDao.getCbBoardTotCnt();	//글갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); //페이지갯수
		int startPage = (currentPage-1)/BLOCKSIZE*BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("totCnt", totCnt);		//글갯수는 없으면 list.size() 대용
		request.setAttribute("pageNum", pageNum);	//pageNum 없으면 param.pageNum
	}

}
