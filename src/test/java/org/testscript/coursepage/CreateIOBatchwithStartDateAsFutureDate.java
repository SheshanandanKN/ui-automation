package org.testscript.coursepage;



import org.testng.annotations.Test;
import org.generic.ExtentTestManager;
import org.pageobjects.CoursePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class CreateIOBatchwithStartDateAsFutureDate extends BaseTest {

	// SUN-1545
	@Test(groups = { "coursepage", "regression1"})
	public void createIOBatchwithStartDateAsFutureDate() throws Exception {

		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		CoursePageObj coursePageObj = new CoursePageObj();
		ExtentTestManager.getTest().log(LogStatus.INFO, "Executing Test case : SUN-1545");

		// Step1: Login as Creator
		userLogin.userLogin(MENTOR);

		// Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		// Step3: Get the Content Name or the Created item from published bucket
		String ContentName = coursePageObj.getContentNameFromPublishedBucket();

		// Step4: Search for the Created item
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch(ContentName);

		// Step5: create an inviteonly Upcoing batch with start date as future  Date only.
		coursePageObj.createInviteOnlyBatchWithStartDateAsFutureDate();
		
		// Step6: Logout as Creator
		userLogin.userLogout();
	}
}
