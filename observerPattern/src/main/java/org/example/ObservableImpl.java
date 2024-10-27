package org.example;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable{
    private int state=0;
    private List<Observer> observers=new ArrayList<>();
    @Override
    public void subscribe(Observer observer) {
       this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
          observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers){
            observer.update(this);
        }
    }

    public void setState(int state){
        int oldState=this.state;
        this.state=state;
        if(this.state-oldState>10){
        notifyObservers();
        }
    }
    public int getState(){
        return state;
    }
}
