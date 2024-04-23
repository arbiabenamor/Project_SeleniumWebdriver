package com.qacart.todo.pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement DisplayedMsg;


    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement Addplus ;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement Gettext ;


    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement Deleteitem ;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement MesgNotodo ;


    @Step
    public  TodoPage load (){

        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_PAGE_ENDPOINT);
        return this;

    }



    @Step
    public Boolean IswelcomeMesgDidplayed(){
        return DisplayedMsg.isDisplayed();
    }


    @Step

    public NewTOdoPage  ClickOnButtonAdd () {
        Addplus.click();
        return new NewTOdoPage(driver);
    }





    @Step
    public String ReturnActualText(){
        return Gettext.getText();
    }





    @Step
    public  TodoPage DLETETODO (){
        Deleteitem.click();
        return this ;
    }



    @Step
    public Boolean MSGofNOTOdoavailable (){
        return MesgNotodo.isDisplayed();
    }



}
