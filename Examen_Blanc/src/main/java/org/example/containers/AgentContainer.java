package org.example.containers;

import org.example.Int.Adapter;
import org.example.entities.Agent;

import java.util.HashMap;
import java.util.Map;

public class AgentContainer {
    private static AgentContainer instance;
    private Map<String, Agent> agents = new HashMap<>();

    private AgentContainer() {}

    public static AgentContainer getInstance() {
        if (instance == null) {
            instance = new AgentContainer();
        }
        return instance;
    }

    public void addAgent(Agent agent) {
        agents.put(agent.getName(), agent);
    }

    public void removeAgent(String name) {
        agents.remove(name);
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    public void displayState(Adapter adapter) {
        StringBuilder state = new StringBuilder();
        agents.forEach((name, agent) -> state.append("Agent: ").append(name)
                .append(", Transactions: ").append(agent.getTransactions()).append("\n"));
        adapter.output(state.toString());
    }
}

