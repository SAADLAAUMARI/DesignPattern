package org.example.Int;

import org.example.entities.Transaction;

public interface Observer {
    void update(String agentName, Transaction transaction);
}

