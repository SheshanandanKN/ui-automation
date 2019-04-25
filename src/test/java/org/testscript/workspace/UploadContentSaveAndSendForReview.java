/**
 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Richa Prakash
 * Date: 28/08/2018
 * Purpose:  Verify that the uploaded content pop up is displaying 
 * when clicking on the upload content 
 */

package org.testscript.workspace;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentSaveAndSendForReview extends BaseTest

{
	@Test(groups={"creator","regression2"})
	public void uploadContentSaveAndSendForReview() throws Exception
	{
		SignUpPageObj signupobj = new SignUpPageObj();
		CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
		ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 


		//Step no.1:Login as a content creator
		signupobj.userLogin(CREATOR);

		//Step no.2:Click on Workspace
		createuserpageobj.navigateToWorkspace(UPLOADCONTENT);

		//Step no.3:Enter URL and click on upload content
		contentcreateuploadpageobj.verifyUploadContentPopupDisplay();

		//Step no.4:Save and Send Upload Content For Review
		contentcreateuploadpageobj.saveAndSendUploadContentForReview();

		//Step no.4 :Logout as reviewer
		signupobj.userLogout();


	}
}



