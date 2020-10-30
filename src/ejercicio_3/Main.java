package ejercicio_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		serializar();
		guardarEnRandom(deserializar());

	}

	public static void serializar() {

		FileOutputStream fos;
		ObjectOutputStream oos;

		try {

			fos = new FileOutputStream("src/ejercicio_3/vehiculos.dat");
			oos = new ObjectOutputStream(fos);

			Coche coche1 = new Coche("BMW       ", "Serie1    ", "Gris ", 2000);
			Coche coche2 = new Coche("Toyota    ", "Yaris     ", "Rojo ", 1500);
			Coche coche3 = new Coche("Toyota    ", "RAV4      ", "Blanc", 2500);
			Coche coche4 = new Coche("Seat      ", "Ibiza     ", "Grana", 1900);

			oos.writeObject(coche1);
			oos.writeObject(coche2);
			oos.writeObject(coche3);
			oos.writeObject(coche4);
			oos.writeObject(null);

			oos.flush();
			oos.close();
			fos.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static ArrayList<Coche> deserializar() {

		FileInputStream fis;
		ObjectInputStream ois;
		ArrayList<Coche> coches = new ArrayList<>();

		try {

			fis = new FileInputStream("src/ejercicio_3/vehiculos.dat");
			ois = new ObjectInputStream(fis);

			Coche aux;

			while ((aux = (Coche) ois.readObject()) != null) {

				System.out.println(aux);
				coches.add(aux);

			}

			ois.close();
			fis.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return coches;
	}

	public static void guardarEnRandom(ArrayList<Coche> coches) {

		RandomAccessFile raf;

		try {

			raf = new RandomAccessFile("src/ejercicio_3/vehiculos.txt", "rw");
			
			for (Coche i : coches) {

				raf.writeUTF(i.getMarca());
				raf.writeUTF(i.getModelo());
				raf.writeUTF(i.getColor());
				raf.writeInt(i.getCilindrada());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
