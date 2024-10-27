package org.example;

import java.util.ArrayList;
import java.util.List;

public class ObserverImpl2 implements Observer{
    private List<Integer> history=new ArrayList<>();
    @Override
    public void update(Observable observable) {
        if(observable instanceof ObservableImpl){
            if(history.size()<600){
        int state=((ObservableImpl)observable).getState();
        history.add(state);
        double sum=0;
        for (Integer s:history
             ) {
            sum+=s;
        }
        System.out.println("--------- OBS2 ----------");
        System.out.println("Stage AVG ="+(sum/history.size()));
        System.out.println("--------------------------");
    }
        }
}
}
