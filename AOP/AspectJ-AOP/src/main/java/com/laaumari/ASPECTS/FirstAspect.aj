package com.laaumari.ASPECTS;

public aspect FirstAspect {
    pointcut pc1(): execution(* com.laaumari.TEST.Main.main(..));
    // Avant l'exécution du pointcut
//    before(): pc1() {
//        System.out.println("--------------------------------");
//        System.out.println("Before main from Aspect with AspectJ syntax");
//        System.out.println("--------------------------------");
//    }
//    // Après l'exécution du pointcut
//    after(): pc1() {
//        System.out.println("--------------------------------");
//        System.out.println("After main from Aspect with AspectJ syntax");
//        System.out.println("--------------------------------");
//    }
    Object around(): pc1() {
        System.out.println("--------------------------------");
        System.out.println("Before main from Aspect with AspectJ syntax");
        System.out.println("--------------------------------");

        Object result = proceed(); // Appelle la méthode originale

        System.out.println("--------------------------------");
        System.out.println("After main from Aspect with AspectJ syntax");
        System.out.println("--------------------------------");

        return result; // Retourne la valeur originale (si applicable)
    }
}
