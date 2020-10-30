package ejercicio_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		deserializar(serializar(leer(rellenar())));

	}

	public static int rellenar() {

		Scanner sc = new Scanner(System.in);

		int num = 0;
		int auxInt = 0;
		double auxDouble;

		RandomAccessFile raf;

		try {

			raf = new RandomAccessFile("src/ejercicio_5/casas.txt", "rw");
			System.out.println("Cuántas casas quieres crear?");
			num = sc.nextInt();
			sc.nextLine();

			for (int i = 0; i < num; i++) {

				System.out.println("Introduce los datos de la casa " + (i + 1));
				System.out.println("Introduce el Nº de personas de la casa");
				auxInt = sc.nextInt();
				sc.nextLine();
				raf.writeInt(auxInt);
				System.out.println("Introduce el precio del alquiler");
				auxDouble = sc.nextDouble();
				sc.nextLine();
				raf.writeDouble(auxDouble);
				System.out.println("Introduce el Nº de código postal de la casa");
				auxInt = sc.nextInt();
				sc.nextLine();
				raf.writeInt(auxInt);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		sc.close();
		return num;
	}

	public static ArrayList<Casa> leer(int num) {

		RandomAccessFile raf;

		ArrayList<Casa> casas = new ArrayList<>();

		try {

			raf = new RandomAccessFile("src/ejercicio_5/casas.txt", "rw");
			raf.seek(0);

			for (int i = 0; i < num; i++) {

				Casa casa = new Casa();
				casa.setNumPersonas(raf.readInt());
				casa.setPrecioAlq(raf.readDouble());
				casa.setCodigoP(raf.readInt());
				casas.add(casa);

			}

			for (Casa i : casas) {

				System.out.println(i);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return casas;
	}

	public static ArrayList<Casa> serializar(ArrayList<Casa> casas) {

		FileOutputStream fos;
		ObjectOutputStream oos;

		try {

			fos = new FileOutputStream("src/ejercicio_5/casas.dat");
			oos = new ObjectOutputStream(fos);

			for (int i = 0; i < casas.size(); i++) {

				oos.writeObject(casas.get(i));

			}
			oos.flush();
			oos.close();
			fos.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return casas;
	}

	public static void deserializar(ArrayList<Casa> casas) {// Este método no es necesario
		                                                   // Esto para probar que saca bien los objetos del .data
		FileInputStream fis;
		ObjectInputStream ois;

		casas.add(casas.size(), null);

		try {

			fis = new FileInputStream("src/ejercicio_5/casas.dat");
			ois = new ObjectInputStream(fis);

			Casa aux;
			System.out.println("*****************************");
			System.out.println("Esto es lo que sale del .data");
			System.out.println("*****************************");
			while ((aux = (Casa) ois.readObject()) != null) {

				System.out.println(aux);

			}
			ois.close();
			fis.close();

		} catch (Exception e) {

		}
	}
}
