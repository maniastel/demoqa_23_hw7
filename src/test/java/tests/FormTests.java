package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class FormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .fillFirstName("Ivan")
                .fillLastName("Ivanov")
                .fillUserEmail("iivanov@mail.com")
                .selectGender("Male")
                .fillUserNumber("7900000000")
                .setDateOfBirth("17", "April", "2008")
                .fillSubject("Arts")
                .selectHobby("Reading")
                .uploadPicture("picture.png")
                .fillCurrentAddress("12 Street, City")
                .fillState("NCR")
                .fillCity("Noida")
                .sendForm();

        //form data check
        registrationPage.checkModalDisplay()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "iivanov@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7900000000")
                .checkResult("Date of Birth", "17 April,2008")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "picture.png")
                .checkResult("Address", "12 Street, City")
                .checkResult("State and City", "NCR Noida");

    }

    @Test
    void successfullRegistrationTestWitMinimalFilledFields() {

        registrationPage.openPage()
                .fillFirstName("Ivan")
                .fillLastName("Ivanov")
                .selectGender("Male")
                .fillUserNumber("7900000000")
                .sendForm();

        //form data check
        registrationPage.checkModalDisplay()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7900000000");


    }

    @Test
    void RegistrationTestWithoutMobileField() {

        registrationPage.openPage()
                .fillFirstName("Ivan")
                .fillLastName("Ivanov")
                .fillUserEmail("iivanov@mail.com")
                .selectGender("Male")
                .setDateOfBirth("17", "April", "2008")
                .fillSubject("Arts")
                .selectHobby("Reading")
                .uploadPicture("picture.png")
                .fillCurrentAddress("12 Street, City")
                .fillState("NCR")
                .fillCity("Noida")
                .sendForm();

        registrationPage.checkModalIsNotDisplayed()
                .checkMobileInputIsRed();
    }

}
