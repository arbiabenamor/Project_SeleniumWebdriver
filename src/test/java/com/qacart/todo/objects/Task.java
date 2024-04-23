package com.qacart.todo.objects;

public class Task {

    private Boolean isCompleted ;
    private String item;


    public Task (String item,Boolean isCompleted){
        this.isCompleted=isCompleted;
        this.item=item;

    }




    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
