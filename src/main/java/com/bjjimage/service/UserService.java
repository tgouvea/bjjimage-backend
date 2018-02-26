package com.bjjimage.service;

import com.bjjimage.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public void saveUser(User user);

}
