package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main { // https://github.com/fernandotavila/Ejercicio_08_Paradigmas.git
    static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(40);
        numeros.add(13);
        numeros.add(60);
        numeros.add(23);
        numeros.add(57);
        numeros.add(69);
        numeros.add(-7);
        numeros.add(0);

        System.out.println("=== NIVEL 1 - Operaciones basicas ===");
        // 1. Sumar Elementos
        Integer sumaNumeros = numeros.stream().reduce(0, (suma, n)->{
            return suma + n;
        });
        System.out.println("1. La suma de los elementos es: "+sumaNumeros);

        // 2. Obtener el maximo
        Integer maximo = numeros.stream().max((n1,n2)->{
            return n1.compareTo(n2);
        }).orElse(0);
        System.out.println("2. El elemento mayor es: "+maximo);

        // 3. Obtener el minimo
        Integer minimo = numeros.stream().min((n1, n2)->{
            return n1.compareTo(n2);
        }).orElse(0);
        System.out.println("3. El elemento menor es: "+minimo);

        // 4. Contar Elemento
        long total = numeros.stream().count();
        System.out.println("4. El total de numeros es: "+total);


        System.out.println("\n=== NIVEL 2 - filter ===");
        // 5. Numeros pares
        List<Integer> numPares = numeros.stream().filter((n)->{
            return n%2==0;
        }).toList();
        System.out.println("5. Pares: "+numPares);

        // 6. Mayor que 50
        List<Integer> mas50 = numeros.stream().filter((n)->{
            return n > 50;
        }).toList();
        System.out.println("6. Numeros mayores que 50: "+mas50);

        // 7. Contar numeros positivos
        long totalPositivos = numeros.stream().filter((n)->{
            return n > 0;
        }).count();
        System.out.println("7. Total de numeros positivos: "+totalPositivos);

        // 8. Obtener numeros dentro de un rango
        List<Integer> numEnRango = numeros.stream().filter((n)->{
            return n >= 5 && n <= 40;
        }).toList();
        System.out.println("8. Numeros en rango de 5 a 40: "+numEnRango);


        System.out.println("\n=== NIVEL 3 - map ===");
        // 9. Elevar al cuadrado
        List<Integer> Cuadrado = numeros.stream().map((n)->{
            return n*n;
        }).toList();
        System.out.println("9. Numeros al cuadrado: "+Cuadrado);

        // 10. Multiplicar por 10
        List<Integer> Por10 = numeros.stream().map((n)->{
            return n * 10;
        }).toList();
        System.out.println("10. Numeros multiplicados por 10: "+Por10);

        //11. Convertir temperaturas
        List<Integer> Celsius = List.of(0, 20, 33, 100);
        List<Double> Fahrenheit = Celsius.stream().map((n)->{
            return n * 9.0 / 5 +32;
        }).toList();
        System.out.println("11. Temperaturas en Fahrenheit: "+Fahrenheit);


        System.out.println("\n=== NIVEL 4 - Combinar Operaciones ===");
        // 12. Pares elevados al cuadrado
        List<Integer> ParesAlCuadrado = numeros.stream().filter((n)->{
            return n%2==0;
        }).map((n)->{
            return n * n;
        }).toList();
        System.out.println("12. Pares elevados al cuadrado: "+ParesAlCuadrado);

        // 13. Suma de numeros pares
        Integer sumaPares = numeros.stream().filter((n)->{
            return n%2==0;
        }).reduce(0, (suma, n)->{
            return suma + n;
        });
        System.out.println("13. Suma de numeros pares: "+sumaPares);

        // 14. Promedio de numeros mayores que 50
        double promMayor50 = numeros.stream().filter((n)->{
            return n > 50;
        }).mapToDouble(n -> n).average().orElse(0);
        System.out.println("14. Promedio de mayores que 50: "+promMayor50);

        // 15. Maximo de numeros pares
        Integer maxPares = numeros.stream().filter((n)->{
            return n%2==0;
        }).max((n1,n2)->{
            return n1.compareTo(n2);
        }).orElse(0);
        System.out.println("13. Maximo de numeros pares: "+maxPares);


        System.out.println("\n=== NIVEL 5 - Ordenamiento ===");
        // 16. Ordenar de menor a mayor
        List<Integer> menorMayor = numeros.stream().sorted().toList();
        System.out.println("16. Menor a mayor: "+menorMayor);

        // 17. Ordenar de mayor a menor
        List<Integer> mayorMenor = numeros.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("17. Mayor a menor: "+mayorMenor);

        // 18. Tres numeros mas grandes
        List<Integer> top3 = numeros.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("18. Top 3 mas grandes: "+top3);


        System.out.println("\n=== NIVEL 6 - String[] (List<String>) ===");

        List<String> nombres = List.of("Juan","Fernando","Eloy","Danna","Jorge","Alan");

        // 19. Filtrar nombres que empiezan con 'A'
        List<String> nombresConA = nombres.stream().filter((s)->{
            return s.startsWith("A");
        }).toList();
        System.out.println("19. Nombres que empiezan con 'A': "+nombresConA);

        // 20. Nombres con mas de 5 caracteres
        List<String> nombresLargos = nombres.stream().filter((s)->{
            return s.length() > 5;
        }).toList();
        System.out.println("20. Nombre de mas de 5 letras: "+nombresLargos);

        // 21. Convertir a mayusculas
        List<String> nombresMayus = nombres.stream().map((s)->{
            return s.toUpperCase();
        }).toList();
        System.out.println("21. Nombre en mayusculas: "+nombresMayus);

        // 22. Ordenar nombres alfabeticamente
        List<String> nombresAlf = nombres.stream().sorted().toList();
        System.out.println("22. Nombres ordenados alfabeticamente: "+nombresAlf);


        System.out.println("\n=== NIVEL 7 - Busqueda y Conincidencias ===");
        // 23. Buscar un numero
        boolean existeNum = numeros.stream().anyMatch((n)->{
            return n == 23;
        });
        System.out.println("23. ¿Existe el numero 23?: "+existeNum);

        // 24. Determinar si todos cumplen una condicion
        boolean mayorMenos10 = numeros.stream().allMatch((n)->{
            return n > -10;
        });
        System.out.println("24. ¿Todos son mayores que -10?: "+ mayorMenos10);

        // 25. Determinar si alguno comple una condicion
        boolean algunNegativo = numeros.stream().anyMatch((n)->{
            return n < 0;
        });
        System.out.println("25. ¿Hay algún número negativo?: "+algunNegativo);
    }
}
