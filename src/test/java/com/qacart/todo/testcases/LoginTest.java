package com.qacart.todo.testcases;

import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("login with email and password")

    @Description("it will login by filling the eamil and the password and navigate to the todo page")
    @Test (description = "Test the login fonctionnality using email and password")
    public void souldbeableTologinWithemailandPassword()
    {




        LoginPage logginPage = new LoginPage(getDriver());


        Boolean isDisplayedWELCOME =
                logginPage
                        .load()
                        .loggin(ConfigUtils.getInstance().getEmail(),ConfigUtils.getInstance().getPassword())
                        .IswelcomeMesgDidplayed();

        Assert.assertTrue(isDisplayedWELCOME);

    }
}


