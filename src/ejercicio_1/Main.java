package ejercicio_1;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		double num;
		double num2;
		int numRegis;
		
		RandomAccessFile raf;
		
		try {
			
			raf = new RandomAccessFile("src/ejercicio_1/Fichero1.txt", "rw");
			raf.writeDouble(3.4);
			raf.seek(raf.length());
			raf.writeDouble(4.5);

			System.out.println("Qué Double quieres cambiar? El 3.4 o 4.5?");
			num = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Por cuál??");
			num2 = sc.nextDouble();
			sc.nextLine();

			numRegis = (int) (raf.length() / 8);
			raf.seek(0);
			
			for (int i = 0; i < numRegis; i++) {
				if (raf.readDouble() == num) {
					raf.seek(raf.getFilePointer() - 8);
					raf.writeDouble(num2);
				}
			}
			
			raf.seek(0);
			
			System.out.println("Los double que tienes en tu fichero son:");

			for (int j = 0; j < numRegis; j++) {
				System.out.println(raf.readDouble());
			}

			raf.close();
		} catch (Exception e) {

			System.out.println("La introducción de los datos no ha sido correcta");
			
		}
		
		sc.close();

	}

}
