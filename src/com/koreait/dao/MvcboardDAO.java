package com.koreait.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.koreait.vo.MvcboardVO;

public class MvcboardDAO {

	private static MvcboardDAO instance = new MvcboardDAO();
	private MvcboardDAO() { }
	public static MvcboardDAO getInstance() {
		return instance;
	}
	
	public void insert(SqlSession mapper, MvcboardVO vo) {
		
		mapper.insert("insert", vo);
	}
	
	public int selectCount(SqlSession mapper) {

		return (int) mapper.selectOne("selectCount");
	}
	
	public ArrayList<MvcboardVO> selectList(SqlSession mapper, HashMap<String, Integer> hmap) {
		return (ArrayList<MvcboardVO>) mapper.selectList("selectList", hmap);
	}
	
	public void increment(SqlSession mapper, int idx) {
		mapper.update("increment", idx);
	}
	
	public MvcboardVO selectByIdx(SqlSession mapper, int idx) {
		return (MvcboardVO) mapper.selectOne("selectByIdx", idx);
	}
	
	public void update(SqlSession mapper, MvcboardVO vo) {
		mapper.update("update", vo);
	}
	
	public void delete(SqlSession mapper, int idx) {
		mapper.delete("delete", idx);
	}
	
	public void incrementSeq(SqlSession mapper, HashMap<String, Integer> hmap) {
		mapper.update("incrementSeq", hmap);
	}
	
	public void insertReply(SqlSession mapper, MvcboardVO vo) {
		mapper.insert("insertReply", vo);
	}
	
}
