package com.narangnorang.dao;

import java.util.List;

import com.narangnorang.dto.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MiniroomDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	public List<ItemDTO> selectAllItems(String category){
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllItems",category);
	}
	public int insertBuy(MyItemDTO myItemDTO){
		return sqlSession.insert("com.config.MiniroomMapper.insertBuy",myItemDTO);
	}
	public int insertStyle(MyRoomDTO myRoomDTO) {
		return sqlSession.insert("com.config.MiniroomMapper.insertStyle",myRoomDTO);
	}
	public int insertDefaultItems(String id) {
		return sqlSession.insert("com.config.MiniroomMapper.insertDefaultItems",id);
	}
	public int wishupdate(int itemId) {
		return sqlSession.update("com.config.MiniroomMapper.wishupdate", itemId);
	}
	public int applyMiniroom(String memberId) {
		return sqlSession.update("com.config.MiniroomMapper.applyMiniroom",memberId);
	}
	public MyItemDTO selectByMyItemId(int itemId){
		return sqlSession.selectOne("com.config.MiniroomMapper.selectByMyItemId",itemId);
	}
	public List<MyItemDTO> selectAllMyItems(String category) {
		return sqlSession.selectList("com.config.MiniroomMapper.selectAllMyItems",category);
	}
}
