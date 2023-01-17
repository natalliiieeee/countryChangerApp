package UC1JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statsVisualiser.gui.Login;

public class LoginTest {

	@Test
	public void test1() {
		Login testLogin = new Login();
		assertEquals("Login", testLogin.getLblLogin().getText());
	}
	@Test
	public void test2() {
		Login testLogin = new Login();
		assertEquals("Username", testLogin.getLblUsername().getText());
	}
	@Test
	public void test3() {
		Login testLogin = new Login();
		assertEquals("Password", testLogin.getLblPassword().getText());
	}
	@Test
	public void test4() {
		Login testLogin = new Login();
		testLogin.getTextUsername().setText("hi");
		assertEquals("hi", testLogin.getTextUsername().getText());
	}
	@Test
	public void test5() {
		Login testLogin = new Login();
		testLogin.getTextPassword().setText("hi");
		assertEquals("hi", testLogin.getTextPassword().getText());
	}
	@Test
	public void test6() {
		Login testLogin = new Login();
		assertEquals("Login", testLogin.getBtnNewButton().getText());
	}
	@Test
	public void test7() {
		Login testLogin = new Login();
		testLogin.getTextUsername().setText("hi");
		testLogin.getTextPassword().setText("hi");
		testLogin.getBtnNewButton().doClick();
		assertEquals("[{\"Username\":\"hi\",\"Password\":\"hi\"}]", testLogin.getJrr().toString());
	}
	@Test
	public void test8() {
		Login testLogin = new Login();
		testLogin.getTextUsername().setText("hi");
		testLogin.getTextPassword().setText("hi");
		testLogin.getBtnNewButton().doClick();
		assertFalse(testLogin.getLoginUI().isVisible());
	}
	@Test
	public void test9() {
		Login testLogin = new Login();
		testLogin.getTextUsername().setText("hi");
		testLogin.getTextPassword().setText("hi");
		testLogin.getBtnNewButton().doClick();
		assertTrue(testLogin.getMainUI().isVisible());
	}
	

}
