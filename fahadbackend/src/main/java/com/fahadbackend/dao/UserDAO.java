package com.fahadbackend.dao;

import java.util.List;


import com.fahadbackend.model.UserDetail;

public interface UserDAO {
	public boolean registerUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUserId(int userId);
	
	public List<UserDetail> listUserDetails();
	

}
