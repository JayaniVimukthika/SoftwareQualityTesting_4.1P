package sit707_week4;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Test;


public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "220194805";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Jayani";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, "password");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndEmptywordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("user",null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndWrongwordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("user","password");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("user","ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan",null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan","password");
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndEmptyValCode()
    {
		LoginStatus status = LoginForm.login("ahsan","ahsan_pass");
		boolean statusValid = LoginForm.validateCode(null);
		assertEquals("false",statusValid ? "true": "false");
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndWrongValCode()
    {
		LoginStatus status = LoginForm.login("ahsan","ahsan_pass");
		boolean statusValid = LoginForm.validateCode("abd1");
		assertEquals("false",statusValid ? "true": "false");
    }
	
	@Test
	public void testFailCorrectUsernameAndCorrectPasswordAndCorrectValCode()
    {
		LoginStatus status = LoginForm.login("ahsan","ahsan_pass");
		boolean statusValid = LoginForm.validateCode("123456");
		assertEquals("true",statusValid ? "true": "false");
    }
	
}
