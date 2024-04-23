package com.qacart.todo.pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTOdoPage extends BasePage {
    public NewTOdoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement NewItem ;
    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement ClickNewItem ;


    @Step
    public  NewTOdoPage load(){

        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_END_POINT);
        return this;
    }
    @Step
    public  TodoPage SendNewtodo(String NewAdd){
        NewItem.sendKeys(NewAdd);
        ClickNewItem.click();
        return new TodoPage(driver);
    }


}
