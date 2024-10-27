package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainTest {
    public static void main(String[] args) {
        Employe employeMaroc = new Employe("Saad", 20000, new IGRMaroc());
        System.out.println("Salaire net mensuel au Maroc: " + employeMaroc.getSalaireNetMensuel());
        Employe employe2Maroc = new Employe("Youssef", 2000, new IGRMaroc());
        System.out.println("Salaire net mensuel au Maroc: " + employe2Maroc.getSalaireNetMensuel());
        // Créer un employé en Algérie
        Employe employeAlgerie = new Employe("Yassine", 20000, new IGRAlgerie());
        System.out.println("Salaire net mensuel en Algérie: " + employeAlgerie.getSalaireNetMensuel());
        }
    }
