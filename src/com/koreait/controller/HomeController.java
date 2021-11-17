package com.koreait.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.service.MvcboardService;

@WebServlet("*.nhn")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MvcboardService service = MvcboardService.getInstance();
	
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 doGet() 메소드");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 doPost() 메소드");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController 클래스의 actionDo() 메소드");
		
//		한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String context = url.substring(contextPath.length());
		
		String viewPage = "/WEB-INF/";
		switch (context) {
			case "/insert.nhn":
				viewPage += "insert";
				break;
			case "/insertOK.nhn":
				
				service.insert(request, response);
				
				viewPage += "index";
				break;
			case "/list.nhn":
			
				service.selectList(request, response);
				
				viewPage += "list";
				break;
			case "/increment.nhn":
		
				service.increment(request, response);
				
				viewPage += "increment";
				break;
			case "/contentView.nhn":
				
				service.selectByIdx(request, response);
				
				viewPage += "contentView";
				break;
			case "/update.nhn":
				
				service.update(request, response);
				
				viewPage += "goList";
				break;
			case "/delete.nhn":
				
				service.delete(request, response);
				
				viewPage += "goList";
				break;
			case "/reply.nhn":
				
				service.selectByIdx(request, response);
				
				viewPage += "reply";
				break;
			case "/replyInsert.nhn":
				
				service.replyInsert(request, response);
				
				viewPage += "goList";
				break;
		}
		viewPage += ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}



















