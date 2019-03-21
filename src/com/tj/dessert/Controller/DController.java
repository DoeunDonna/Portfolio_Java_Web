package com.tj.dessert.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dessert.Service.ACusListService;
import com.tj.dessert.Service.ACusModifyService;
import com.tj.dessert.Service.ALoginService;
import com.tj.dessert.Service.CDeleteService;
import com.tj.dessert.Service.CJoinService;
import com.tj.dessert.Service.CLoginService;
import com.tj.dessert.Service.CLogoutService;
import com.tj.dessert.Service.CModifyService;
import com.tj.dessert.Service.CbContentService;
import com.tj.dessert.Service.CbDeleteService;
import com.tj.dessert.Service.CbListService;
import com.tj.dessert.Service.CbModifyService;
import com.tj.dessert.Service.CbModifyViewService;
import com.tj.dessert.Service.CbWriteService;
import com.tj.dessert.Service.DService;
import com.tj.dessert.Service.DiContentService;
import com.tj.dessert.Service.DiDeleteService;
import com.tj.dessert.Service.DiListService;
import com.tj.dessert.Service.DiModifyService;
import com.tj.dessert.Service.DiModifyViewService;
import com.tj.dessert.Service.DiWriteService;
import com.tj.dessert.Service.EbContentService;
import com.tj.dessert.Service.EbDeleteService;
import com.tj.dessert.Service.EbListService;
import com.tj.dessert.Service.EbModifyService;
import com.tj.dessert.Service.EbModifyViewService;
import com.tj.dessert.Service.EbWriteService;
import com.tj.dessert.Service.LbContentService;
import com.tj.dessert.Service.LbDeleteService;
import com.tj.dessert.Service.LbListService;
import com.tj.dessert.Service.LbModifyService;
import com.tj.dessert.Service.LbModifyViewService;
import com.tj.dessert.Service.LbRegisterService;
import com.tj.dessert.Service.LbWriteService;
import com.tj.dessert.Service.TbContentService;
import com.tj.dessert.Service.TbDeleteService;
import com.tj.dessert.Service.TbListService;
import com.tj.dessert.Service.TbModifyService;
import com.tj.dessert.Service.TbModifyViewService;
import com.tj.dessert.Service.TbReplyService;
import com.tj.dessert.Service.TbReplyViewService;
import com.tj.dessert.Service.TbWriteService;
import com.tj.dessert.Service.aCusModifyViewService;

@WebServlet("*.do")
public class DController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int Write_view = 0;	//1일때 저장
	
	public DController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		DService service = null;
		
		if(com.equals("/main.do")) {	//메인화면
			viewPage = "main/main.jsp";
			
		}else if(com.equals("/joinView.do")) {	//회원가입
			viewPage = "customer/join.jsp";
			
		}else if(com.equals("/join.do")) {	//회원가입
			service = new CJoinService();
			service.execute(request, response);
			viewPage = "customer/login.jsp";
			
		}else if(com.equals("/loginView.do")) {	//로그인
			viewPage = "customer/login.jsp";
			
		}else if(com.equals("/login.do")) {	//로그인
			service = new CLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		
		}else if(com.equals("/logout.do")) {	//로그아웃
			service = new CLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		}else if(com.equals("/cusInform.do")) {		//회원정보
			viewPage = "customer/cusInform.jsp";
			
		}else if(com.equals("/modifyView.do")) {	//정보수정
			viewPage = "customer/modify.jsp";
			
		}else if(com.equals("/modify.do")) {	//정보수정
			service = new CModifyService();
			service.execute(request, response);
			viewPage = "customer/cusInform.jsp";
			
		}else if(com.equals("/cusDelete_view.do")) {	//회원탈퇴
			viewPage = "customer/delete.jsp";
		
		}else if(com.equals("/cusDelete.do")) {		//회원탈퇴
			service = new CDeleteService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		}else if(com.equals("/adminloginView.do")) {	//관리자 로그인
			viewPage = "admin/adminLogin.jsp";
			
		}else if(com.equals("/adminlogin.do")) {	//관리자 로그인
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
	//	customer & admin
			
	//eatmeTable		
		}else if(com.equals("/eatMeView.do")) {	//eatMe 게시판 메인화면으로
			service = new EbListService();
			service.execute(request, response);
			viewPage = "eatMe/ebList.jsp";
			
		}else if(com.equals("/ebWrite_view.do")) {	//eatMe 글쓰기
			Write_view = 1;
			viewPage = "eatMe/ebWrite_view.jsp";
		}else if(com.equals("/ebWrite.do")) {	//eatMe 글쓰기
			if(Write_view == 1) {
				service = new EbWriteService();
				service.execute(request, response);
				Write_view = 0;
			}
			viewPage = "/eatMeView.do";
			
		}else if(com.equals("/ebContent_view.do")) {	//eatMe 글보기
			service = new EbContentService();
			service.execute(request, response);
			viewPage = "eatMe/ebContent_view.jsp";
			
		}else if(com.equals("/ebModify_view.do")) {		//eatMe 글수정
			service = new EbModifyViewService();
			service.execute(request, response);
			viewPage = "eatMe/ebModify_view.jsp";
		
		}else if(com.equals("/ebModify.do")) {		//eatMe 글수정
			service = new EbModifyService();
			service.execute(request, response);
			viewPage = "ebContent_view.do";
			
		}else if(com.equals("/ebDelete.do")) {		//eatMe 글삭제
			service = new EbDeleteService();
			service.execute(request, response);
			viewPage = "eatMeView.do";
		//eatMe Table
		
		//cookMe Table	
		}else if(com.equals("/cookMeView.do")){		//cookMe 게시판 메인화면으로
			service = new CbListService();
			service.execute(request, response);
			viewPage = "cookMe/cbList.jsp";
		}else if(com.equals("/cbWrite_view.do")) {	//cookMe 글쓰기
			Write_view = 1;
			viewPage = "cookMe/cbWrite_view.jsp";
		}else if(com.equals("/cbWrite.do")) {	//cookMe 글쓰기
			if(Write_view == 1) {
				service = new CbWriteService();
				service.execute(request, response);
				Write_view = 0;
			}
			viewPage = "/cookMeView.do";
		
		}else if(com.equals("/cbContent_view.do")) {	//cookMe 글보기
			service = new CbContentService();
			service.execute(request, response);
			viewPage = "cookMe/cbContent_view.jsp";
			
		}else if(com.equals("/cbModify_view.do")) {		//cookMe 글수정
			service = new CbModifyViewService();
			service.execute(request, response);
			viewPage = "cookMe/cbModify_view.jsp";
		
		}else if(com.equals("/cbModify.do")) {		//cookMe 글수정
			service = new CbModifyService();
			service.execute(request, response);
			viewPage = "cbContent_view.do";
			
		}else if(com.equals("/cbDelete.do")) {		//cookMe 글삭제
			service = new CbDeleteService();
			service.execute(request, response);
			viewPage = "cookMeView.do";
		//cookMe Table
		
		//talkMe Table
		}else if(com.equals("/talkMeView.do")){		//talkMe 게시판 메인화면으로
			service = new TbListService();
			service.execute(request, response);
			viewPage = "talkMe/tbList.jsp";
		}else if(com.equals("/tbWrite_view.do")) {	//talkMe 글쓰기
			Write_view = 1;
			viewPage = "talkMe/tbWrite_view.jsp";
		}else if(com.equals("/tbWrite.do")) {	//talkMe 글쓰기
			if(Write_view == 1) {
				service = new TbWriteService();
				service.execute(request, response);
				Write_view = 0;
			}
			viewPage = "/talkMeView.do";
		
		}else if(com.equals("/tbContent_view.do")) {	//talkMe 글보기
			service = new TbContentService();
			service.execute(request, response);
			viewPage = "talkMe/tbContent_view.jsp";
			
		}else if(com.equals("/tbModify_view.do")) {		//talkMe 글수정
			service = new TbModifyViewService();
			service.execute(request, response);
			viewPage = "talkMe/tbModify_view.jsp";
		
		}else if(com.equals("/tbModify.do")) {		//talkMe 글수정
			service = new TbModifyService();
			service.execute(request, response);
			viewPage = "talkMeView.do";
			
		}else if(com.equals("/tbDelete.do")) {		//talkMe 글삭제
			service = new TbDeleteService();
			service.execute(request, response);
			viewPage = "talkMeView.do";
		
		}else if(com.equals("/tbReply_view.do")) {	//talkMe 답변쓰기
			service = new TbReplyViewService();
			service.execute(request, response);
			viewPage = "talkMe/tbReply_view.jsp";
			
		}else if(com.equals("/tbReply.do")) {		//talkMe 답변쓰기
			service = new TbReplyService();
			service.execute(request, response);
			viewPage = "talkMeView.do";
		//talkMe Table
			
		//learnMe Table		
		}else if(com.equals("/learnMeView.do")){		//learnMe 게시판 메인화면으로
			service = new LbListService();
			service.execute(request, response);
			viewPage = "learnMe/lbList.jsp";
			
		}else if(com.equals("/lbWrite_view.do")) {	//learnMe 글쓰기
			Write_view = 1;
			viewPage = "learnMe/lbWrite_view.jsp";
		}else if(com.equals("/lbWrite.do")) {	//learnMe 글쓰기
			if(Write_view == 1) {
				service = new LbWriteService();
				service.execute(request, response);
				Write_view = 0;
			}
			viewPage = "/learnMeView.do";
		
		}else if(com.equals("/lbContent_view.do")) {	//learnMe 글보기
			service = new LbContentService();
			service.execute(request, response);
			viewPage = "learnMe/lbContent_view.jsp";
			
		}else if(com.equals("/lbModify_view.do")) {		//learnMe 글수정
			service = new LbModifyViewService();
			service.execute(request, response);
			viewPage = "learnMe/lbModify_view.jsp";
		
		}else if(com.equals("/lbModify.do")) {		//learnMe 글수정
			service = new LbModifyService();
			service.execute(request, response);
			viewPage = "lbContent_view.do";
			
		}else if(com.equals("/lbDelete.do")) {		//learnMe 글삭제
			service = new LbDeleteService();
			service.execute(request, response);
			viewPage = "learnMeView.do";
		
		}else if(com.equals("/lbRegister.do")) {		//learnMe 댓글쓰기(강의신청)
			service = new LbRegisterService();
			service.execute(request, response);
			viewPage = "lbContent_view.do";
			//learnMe Table
		
			//dessertInform Table
		}else if(com.equals("/dessertInformView.do")) {	//dessertInform 게시판 메인화면으로
			service = new DiListService();
			service.execute(request, response);
			viewPage = "dessertInform/diList.jsp";
			
		}else if(com.equals("/diWrite_view.do")) {	//dessertInform 글쓰기
			Write_view = 1;
			viewPage = "dessertInform/diWrite_view.jsp";
		}else if(com.equals("/diWrite.do")) {	//dessertInform 글쓰기
			if(Write_view == 1) {
				service = new DiWriteService();
				service.execute(request, response);
				Write_view = 0;
			}
			viewPage = "/dessertInformView.do";
			
		}else if(com.equals("/diContent_view.do")) {	//dessertInform 글보기
			service = new DiContentService();
			service.execute(request, response);
			viewPage = "dessertInform/diContent_view.jsp";
			
		}else if(com.equals("/diModify_view.do")) {		//dessertInform 글수정
			service = new DiModifyViewService();
			service.execute(request, response);
			viewPage = "dessertInform/diModify_view.jsp";
		
		}else if(com.equals("/diModify.do")) {		//dessertInform 글수정
			service = new DiModifyService();
			service.execute(request, response);
			viewPage = "diContent_view.do";
			
		}else if(com.equals("/diDelete.do")) {		//dessertInform 글삭제
			service = new DiDeleteService();
			service.execute(request, response);
			viewPage = "dessertInformView.do";
		//dessertInform Table
		
		//admin(나중에 순서 바꿔줄것)
		}else if(com.equals("/manageCus.do")) {	//adnub 회원관리 메인화면으로(전체회원 list)
			service = new ACusListService();
			service.execute(request, response);
			viewPage = "admin/manageList.jsp";
		
		}else if(com.equals("/aCusModify_view.do")) {	//특정 회원등급 수정
			service = new aCusModifyViewService();
			service.execute(request, response);
			viewPage = "admin/aCusModify_view.jsp";
			
		}else if(com.equals("/aCusModify.do")) {	//정보수정
			service = new ACusModifyService();
			service.execute(request, response);
			viewPage = "/manageCus.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
