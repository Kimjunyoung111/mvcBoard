package com.koreait.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.koreait.dao.MvcboardDAO;
import com.koreait.mybatis.MySession;
import com.koreait.vo.MvcboardList;
import com.koreait.vo.MvcboardVO;

public class MvcboardService {

	private static MvcboardService instance = new MvcboardService();
	private MvcboardService() { }
	public static MvcboardService getInstance() {
		return instance;
	}
	
	private MvcboardDAO dao = MvcboardDAO.getInstance();
	
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		SqlSession mapper = MySession.getSession();
		
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		MvcboardVO vo = new MvcboardVO(name, subject, content);
		
		dao.insert(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
	public void selectList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 selectList() 메소드");
		SqlSession mapper = MySession.getSession();
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (Exception e) { }
		
		int pageSize = 10;
		int totalCount = dao.selectCount(mapper);
//		System.out.println(totalCount);
		
		MvcboardList mvcboardList = new MvcboardList(pageSize, totalCount, currentPage);
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", mvcboardList.getStartNo());
		hmap.put("endNo", mvcboardList.getEndNo());

		mvcboardList.setList(dao.selectList(mapper, hmap));

		request.setAttribute("mvcboardList", mvcboardList);
		
		mapper.close();
	}
	
	public void increment(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 increment() 메소드");
		SqlSession mapper = MySession.getSession();
		
		int idx = Integer.parseInt(request.getParameter("idx"));

		dao.increment(mapper, idx);
		
		mapper.commit();
		mapper.close();
	}
	
	public void selectByIdx(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 selectByIdx() 메소드");
		SqlSession mapper = MySession.getSession();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		MvcboardVO vo = dao.selectByIdx(mapper, idx);
//		System.out.println(vo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("enter", "\r\n");
		
		mapper.close();
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 update() 메소드");
		SqlSession mapper = MySession.getSession();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		MvcboardVO vo = new MvcboardVO();
		vo.setIdx(idx);
		vo.setSubject(subject);
		vo.setContent(content);

		dao.update(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 delete() 메소드");
		SqlSession mapper = MySession.getSession();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		dao.delete(mapper, idx);
		
		mapper.commit();
		mapper.close();
	}
	
	public void replyInsert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MvcboardService 클래스의 replyInsert() 메소드");
		SqlSession mapper = MySession.getSession();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int gup = Integer.parseInt(request.getParameter("gup"));
		int lev = Integer.parseInt(request.getParameter("lev"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		MvcboardVO vo = new MvcboardVO(name, subject, content);
		vo.setIdx(idx);
		vo.setGup(gup);
		vo.setLev(lev + 1);
		vo.setSeq(seq + 1);
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("gup", vo.getGup());
		hmap.put("seq", vo.getSeq());
		dao.incrementSeq(mapper, hmap);

		dao.insertReply(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
}












