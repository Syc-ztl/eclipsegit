package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.sun.chenglixin.entity.Score;

public interface ScoreMapper {
	
	/**
	 * 添加分数
	 * @param score
	 * @return
	 */
	Integer addScore(Score score);
	
}
