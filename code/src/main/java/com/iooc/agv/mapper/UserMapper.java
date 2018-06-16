package com.iooc.agv.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iooc.agv.model.User;

@Repository
public interface UserMapper {
	List<User> selectAllUser();
}
