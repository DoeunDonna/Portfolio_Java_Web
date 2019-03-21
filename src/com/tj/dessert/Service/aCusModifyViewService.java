package com.tj.dessert.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.dao.CustomerDao;
import com.tj.dessert.dto.CustomerDto;

public class aCusModifyViewService implements DService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String cId = request.getParameter("cId");
		CustomerDao cDao = new CustomerDao();
		CustomerDto cDto = cDao.getCustomer(cId);
		request.setAttribute("aCus_level", cDto);
		System.out.println(cDto);

	}

}
