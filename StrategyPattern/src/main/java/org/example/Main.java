package org.example;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
            while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("choisir le pays");
            String pays1=scanner.next();
                if(pays1.equals("quit")) break;
            String pays="org.example.IGR"+pays1;
            Class c=Class.forName(pays);
            IGRStrategy strategy=(IGRStrategy) c.newInstance();
            Employe employe = new Employe("Saad", 20000, strategy);
            System.out.println("Salaire net mensuel: " + employe.getSalaireNetMensuel());

            }
        }
    }

