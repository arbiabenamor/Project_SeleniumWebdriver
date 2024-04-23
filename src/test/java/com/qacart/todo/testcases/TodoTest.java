package com.qacart.todo.testcases;

import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTOdoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {
    @Story("Add Todo")


    @Test(description = "should be able to add a new todo correctly ")
    public void ShouldBeabletoAddnewTOdo ()
    {



        RegisterApi registerApi = new RegisterApi();
        registerApi.register();


        NewTOdoPage newTOdoPage= new NewTOdoPage(getDriver());
        newTOdoPage.load();

        InjectCookieToBrowser(registerApi.getRestAssuredCookies());



        String actualResul=  newTOdoPage

                .load()

                .SendNewtodo("Learn Selenuim")
                .ReturnActualText();


        Assert.assertEquals(actualResul,"Learn Selenuim");





    }
    @Story("Delete Todo")
    @Test (description = "soud be able to delete a todo correctly")
    public void ShouldBeabletodeleteTOdo ()
    {



        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getToken());


        TodoPage todoPage=new TodoPage(getDriver());

        todoPage.load();
        InjectCookieToBrowser(registerApi.getRestAssuredCookies());



        Boolean NotodosIsdisplayed  = todoPage
                .load()
                .DLETETODO()
                .MSGofNOTOdoavailable();



        Assert.assertTrue(NotodosIsdisplayed);


    }

}

