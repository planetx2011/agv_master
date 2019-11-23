package com.hogun.agv.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hogun.agv.model.User;

@Repository
public interface UserMapper {
	List<User> selectAllUser();
}
