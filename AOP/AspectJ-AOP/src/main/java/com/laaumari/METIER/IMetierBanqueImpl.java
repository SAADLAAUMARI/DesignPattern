package com.laaumari.METIER;

import java.util.HashMap;
import java.util.Map;

public class IMetierBanqueImpl implements IMetierBanque {
    private final Map<Long, Compte> comptes = new HashMap<>();

    @Override
    public void addCompte(Compte c) {
        comptes.put(c.getCode(), c);
    }

    @Override
    public void verser(Long code, double montant) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() + montant);
    }

    @Override
    public void retirer(Long code, double montant) {
        Compte compte = comptes.get(code);
        compte.setSolde(compte.getSolde() - montant);

    }

    @Override
    public Compte consulter(Long code) {
        return comptes.get(code);
    }
}
