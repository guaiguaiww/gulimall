package com.hww.gulimall.member.dao;

import com.hww.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author hww
 * @email 2125288145@qq.com
 * @date 2020-04-07 23:12:55
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
