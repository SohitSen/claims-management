package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.model.MyUser;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyUserTest {

	@Mock
	MyUser user;

	@Test
	public void testAllArgumentConstructor() {
		MyUser user = new MyUser("1", "rashmita", "rashmita", " ");
		assertEquals("1", user.getMemberid());
		assertEquals("rashmita", user.getUsername());
		assertEquals("rashmita", user.getPassword());
		assertEquals(" ", user.getToken());
	}

	@Test
	public void testNoArgumentConstructor() {
		MyUser user = new MyUser();
		assertEquals(user, user);
	}

	@Test
	public void testSetter() {
		MyUser user = new MyUser();
		user.setUsername("abc");
		assertEquals("abc", user.getUsername());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = user.equals(user);
		assertTrue(equals);
	}

	@Test
	void testingMyUser() {
		user = new MyUser("1", "Krati", "Krati");
		user.setMemberid("1");
		user.setUsername("Krati");
		user.setPassword("Krati");

		assertEquals("1", user.getMemberid());
		assertEquals("Krati", user.getUsername());
		assertEquals("Krati", user.getPassword());

	}
}
