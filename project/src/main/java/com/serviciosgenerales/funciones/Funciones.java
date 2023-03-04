package com.serviciosgenerales.funciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Funciones {
	//Funcion de alto nivel (lamda)
	private static Function<String, String> toMayus = (x)->x.toUpperCase();
	private static Function<Integer, Integer> sumar = (x)->x.sum(x, x);
	
	public static void main(String[] args) {
	 System.out.println(toMayus.apply("Willliam"));
	 System.out.println(sumar.apply(5));
	 saludarMayusculas(toMayus, "William");
	 
	 ArrayList<String> nombres = new ArrayList<>();
	 nombres.add("Juan");
	 nombres.add("Pedro");
	 nombres.add("Paco");
	 nombres.add("Mary");
	 						//el system.out es una version corta de una funcion lamda 	
	 nombres.stream().forEach(System.out::println);
	 //Funcion para imprimir en pantalla version completa
	 nombres.stream().forEach(x->System.out.println(x.toLowerCase()));
	 
	 Stream<String>valores = nombres.stream().map((x)->{
		 return "Funcion Map"+x.toUpperCase();
	 });
	 valores.forEach(System.out::println);
	 
	 Stream<String>valores1 = nombres.stream()
			 .map((x)->x.toUpperCase())
			 .filter(x->x.startsWith("P"));
	 valores1.forEach(System.out::println);
	 
	 //PRACTICA CON NUMEROS
	 int[]numeros = {1,2,3,4,5,6,7,8,9,10};
	 
	 //revisar por que no funciona de esta manera
	 //var stNumeros :IntStream = Arrays.stream(numeros);
	 
	 IntStream stNumeros = Arrays.stream(numeros);
	 IntStream resultado = stNumeros.filter(x->x%2 == 0);	
	 resultado.forEach(System.out::println);
	 
	 
	//Utilizar reduce
	 
	 IntStream stNumeros1 = Arrays.stream(numeros);
	 int resultado1 = stNumeros1.filter((x)->x%2 == 0).reduce(0,(x,y)->{
		 System.out.println("X es "+x+ " Y es "+y);
		 return x+y;
	 });	
	 System.out.println("Mi suma es "+resultado1);
	 
	 //Utiliza map
	 IntStream stNumeros2 = Arrays.stream(numeros);
	 int resultado2 = stNumeros2
			 .map(x->x*2)
			 .filter((x)->x%2 == 0)
			 .reduce(0,(x,y)->{
		 System.out.println("X es "+x+ " Y es "+y);
		 return x+y;
	 });	
	 System.out.println("Mi suma es "+resultado2);
	 
	}
	
	//metodo
	public static String todoMayuscula(String nombre) {
		return "hola,"+ nombre;
	}
	
	public static void saludarMayusculas(Function<String, String> miFuncion, String nombre) {
		System.out.println("Hola , "+miFuncion.apply(nombre));
	}

}
