/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/10/2018

* Purpose: Check for the invited member, course content should be available in home page.

*/
package org.testscript.coursepage;



import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CheckAvailabilityOfCourseForInvitedMember extends BaseTest 
{
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	//SUN-1556
	@Test(groups={"mentor","regression1","sanity2"})
	public void checkAvailabilityOfCourseForInvitedMember() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-1556");
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);

		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step3: Create new Course
		String createdCourse = creatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendNewCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(createdCourse,objListOFTestDataForSunbird);

		//Step6: Logout as Mentor
		userLogin.userLogout();

		//Step7: Login as Reviewer
		userLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);

		//Step9:Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);

		//Step10: Logout as Reviewer		
		userLogin.userLogout();	

		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);

		//Step12:Search the course and create invite only batch
		String courseName=createMentorPageObj.createInviteOnlyBatch();

		//Step13: Logout as mentor
		userLogin.userLogout();

		//Step14: Login as invited member
		userLogin.userLogin(REVIEWER);

		//Step15: Search for the particular course and consume the course
		createMentorPageObj.navigateToCourseAndSearch(courseName);

		//Step16: Logout as public user
		userLogin.userLogout();
		
		//Step17: Login as Creator
		userLogin.userLogin(MENTOR);

		//Step18: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step19: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step20: Logout as Creator
		userLogin.userLogout();

		

	}
}
