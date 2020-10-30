package ejercicio_2;

import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		
		int num = 3;
		
		RandomAccessFile raf;
		
		try {
			
			raf = new RandomAccessFile("src/ejercicio_2/ejercicio_2.txt", "rw");
			
			for(int i = 0;i < num;i++) {
				raf.writeInt(1);
			}
			 
			raf.seek(raf.length());
			
			for(int i = 0;i < num*2;i++) {
				raf.writeInt(2);
			}
			
			raf.seek(0);
			
			for (int j = 0; j < raf.length()/4; j++) {
				System.out.println(raf.readInt());
			}
			
			System.out.println("Y ahora cambiamos el Nº2 por el Nº3");
			
			raf.seek(0);
			
			for (int i = 0; i < raf.length()/4; i++) {
				if (raf.readInt() == 2) {
					raf.seek(raf.getFilePointer() - 4);
					raf.writeInt(3);
				}
			}
			
			raf.seek(0);
			for (int j = 0; j < raf.length()/4; j++) {
				System.out.println(raf.readInt());
			}
			
			raf.close();
		} catch (Exception e) {
			
			System.out.println("Fichero no encontrado");
		}
		

	}

}
