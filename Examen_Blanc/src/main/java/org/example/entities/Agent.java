package org.example.entities;

import org.example.Int.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Agent implements Observable,Observer {
    private final String name;
    private final List<Transaction> transactions;
    private final List<Observer> observers;
    private NotificationStrategy notificationStrategy;
    public Agent(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.notificationStrategy=new DefaultStrategy();
    }
    public String getName() {
        return name;
    }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (notificationStrategy != null) {
            notificationStrategy.handleNotification(this.name, transaction);
        }
        notifyObservers(transaction);
    }
    public void setNotificationStrategy(NotificationStrategy strategy) {
        this.notificationStrategy = strategy;
    }
    public Transaction getLargestTransaction() {
        return transactions.stream()
                .max((t1, t2) -> Double.compare(t1.getMontant(), t2.getMontant()))
                .orElse(null);
    }
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(this.name, transaction);
        }
    }
    public void afficherTransactions(){
        System.out.println("Agent: "+name);
        for (Transaction t:transactions
             ) {
            System.out.println(t.toString());
        }
    }
    @Override
    public void update(String agentName, Transaction transaction) {
        System.out.println("Agent: "+agentName+ "a ajouté la "+transaction);
    }

}


