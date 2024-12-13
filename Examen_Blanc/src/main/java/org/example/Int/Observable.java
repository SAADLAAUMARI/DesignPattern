package org.example.Int;

import org.example.entities.Transaction;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(Transaction transaction);
}

