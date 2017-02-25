package com.va.quiz;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.va.quiz.bo.UserBOImplementation;
import com.va.quiz.dao.UserDAO;
import com.va.quiz.dto.User;

/**
 *  @author AonoZan Dejan Petrovic 2017 ©
 */
public class UserBOImplementationTest {
	UserDAO daoMock = Mockito.mock(UserDAO.class);
	UserBOImplementation bo = new UserBOImplementation();

	User user;

	final String NAME = "Dejo", PASS = "Pass";

	@Before
	public void setUp() {
		bo.setDao(daoMock);
		user = new User(NAME, PASS);
	}

	@Test
	public void shouldReturnAdminWhenAdminExists() {
		Mockito.when(daoMock.getUser(user)).thenReturn(user);

		User resultUser = bo.getUser(user);

		assertSame(user, resultUser);
		Mockito.verify(daoMock).getUser(user);
	}
	@Test
	public void shouldReturnNullWhenAdminDontExists() {
		Mockito.when(daoMock.getUser(user)).thenReturn(null);

		User resultUser = bo.getUser(user);

		assertNull(resultUser);
		Mockito.verify(daoMock).getUser(user);
	}
	@Test
	public void shouldReturnNullWhenGettingAdminButArgumentIsNull() {
		User resultUser = bo.getUser(null);

		assertNull(resultUser);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnNullWhenGettingAdminButNameIsNull() {
		User user = new User(null, PASS);

		User resultUser = bo.getUser(user);

		assertNull(resultUser);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnNullWhenGettingAdminButPassIsNull() {
		User user = new User(NAME, null);

		User resultUser = bo.getUser(user);

		assertNull(resultUser);
		Mockito.verifyZeroInteractions(daoMock);
	}

	@Test
	public void shouldReturnTrueWhenAddingAdminThatDoesNotExists() {
		Mockito.when(daoMock.addUser(user)).thenReturn(true);

		boolean result = bo.addUser(user);

		assertTrue(result);
		Mockito.verify(daoMock).addUser(user);
	}
	@Test
	public void shouldReturnFalseWhenAddingAdminThatExists() {
		Mockito.when(daoMock.addUser(user)).thenReturn(false);

		boolean result = bo.addUser(user);

		assertFalse(result);
		Mockito.verify(daoMock).addUser(user);
	}
	@Test
	public void shouldReturnFalseWhenAddingButArgumentIsNull() {
		boolean result = bo.addUser(null);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnFalseWhenAddingAdminButNameIsNull() {
		User user = new User(null, PASS);

		boolean result = bo.addUser(user);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
	@Test
	public void shouldReturnNullWhenAddingAdminButPassIsNull() {
		User user = new User(NAME, null);

		boolean result = bo.addUser(user);

		assertFalse(result);
		Mockito.verifyZeroInteractions(daoMock);
	}
}

