package com.jin.springcrud.dao;

import com.jin.springcrud.entity.Role;

public interface RoleDAO {

	public Role findRoleByName(String theRoleName);
	
}
