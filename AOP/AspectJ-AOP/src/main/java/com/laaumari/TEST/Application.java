package com.laaumari.TEST;


import com.laaumari.METIER.Compte;
import com.laaumari.METIER.IMetierBanque;
import com.laaumari.METIER.IMetierBanqueImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    public void start() {
        System.out.println("Application is starting ..............");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Account code : ");
        Long code = scanner.nextLong();
        System.out.println("initial balance : ");
        double solde = scanner.nextDouble();

        IMetierBanque metierBanque = new IMetierBanqueImpl();
        metierBanque.addCompte(new Compte(code, solde));
        while (true) {
            try {
                System.out.println("Operation Type: ");
                String type = scanner.next();
                if (type.equals("q")) break;
                System.out.println("Amount : ");
                double montant = scanner.nextDouble();
                if (type.equals("v")) {
                    metierBanque.verser(code, montant);
                } else if (type.equals("r")) {
                    metierBanque.retirer(code, montant);
                }
                Compte c = metierBanque.consulter(code);
                System.out.println("Account Balance  = $" + c.getSolde());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("end of Application");

    }
}
