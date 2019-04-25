/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/26/2018

* Purpose: Resend and edit the Announcement and verify announcement sender receives it.

*/
package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResendAnnouncement extends BaseTest{
	String announcementnameReview;
	String announcementName;
	boolean checkForElement=false;
	boolean checkForResendButton=false;
	String editTitle;
	String edittedTitle;
	int count=7;
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;
	
	@Test( groups={"sanity2", "regression1","announcementsender"})
	public void resendAnnouncement() throws InterruptedException, Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		CreatorAnnouncementPage createAnnouncementPage = PageFactory.initElements(driver,CreatorAnnouncementPage.class);
		
		//Step1.Login as creator.
		creatorLogin.userLogin(CREATOR);
		
		//Step2.Click on Announcement Dashboard.
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3.Click on resend.
		creatorAnnouncementPageObj.verifyResendingOfAnnouncement();
		
		//Step9. Logout as Creator
		creatorLogin.userLogout();
	}

}
