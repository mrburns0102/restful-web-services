package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new User(1, "Pera Peric", new Date()));
		users.add(new User(2, "Mika Mikic", new Date()));
		users.add(new User(3, "Sima Simic", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user != null) {

			if (user.getId() == null) {
				user.setId(++usersCount);
			}

			users.add(user);

			return user;
		}

		return null;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (id == user.getId()) {
				return user;
			}
		}

		return null;
	}
}