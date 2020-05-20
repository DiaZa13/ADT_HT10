import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static <K, V> void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		BufferedReader br = null;
		Scanner read = new Scanner(System.in);
		String line, from, to, fromCity, toCity, menu, mMenu;
		int distance;
		String[] words = null;
		boolean tmenu;		

//---------------------Read the text with the nodes and edges
		try {
			fr = new FileReader ("Spanish.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
				
					words = line.split("\t");
					for (int i = 0; i < words.length; i++) {
						if (i%2 == 0)
							from = words[i].trim();
						else if (i%2 == 1)
							to = words[i].replaceAll("[\\[\\]].*", "").replaceAll(",.*", "").trim();
					//add the nodes with the edge to the graph
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( null != fr ){
					fr.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}	
//---------------------Menu
		do {
			System.out.println("----------------------- HT10 GRAFOS -----------------------");
			System.out.println("1. Buscar ruta mas corta entre dos ciudades");
			System.out.println("2. Ciudad en el centro del grafo");
			System.out.println("3. Actualizar el grafo");
			System.out.println("4. Salir");
			System.out.print(">>Ingrese el numero de la opcion que desee: ");
			menu = read.nextLine();
			tmenu = MenuInvalido(menu);
			while (tmenu != false) {
				System.out.print(">>Ingrese nuevamente el numero de la opcion que desee: ");	
				menu = read.nextLine();
				tmenu = MenuInvalido(menu);
			}
		
			switch (menu) {
		
			case("1"):
				System.out.println(">>Ingrese ciudad de salida: ");
				fromCity = read.nextLine();
				System.out.println(">>Ingrese ciudad de destino: ");
				toCity = read.nextLine();
				break;
		
			case("2"):

				break;
		
			case("3"):
				System.out.println("1. Agregar interrupcion entre dos ciudades");
				System.out.println("2. Establecer una nueva relacion entre dos ciudades");
				System.out.print(">>Ingrese el numero de la opcion que desee: ");
				mMenu = read.nextLine();
				tmenu = MenuInvalido1(mMenu);
				while (tmenu != false) {
					System.out.print(">>Ingrese nuevamente el numero de la opcion que desee: ");	
					mMenu = read.nextLine();
					tmenu = MenuInvalido1(mMenu);
				}
				switch (mMenu) {
				case "1":
					System.out.println(">>Ingrese ciudad de salida: ");
					fromCity = read.nextLine();
					System.out.println(">>Ingrese ciudad de destino: ");
					toCity = read.nextLine();
				break;
				case "2":
					System.out.println(">>Ingrese ciudad de salida: ");
					fromCity = read.nextLine();
					System.out.println(">>Ingrese ciudad de destino: ");
					toCity = read.nextLine();
					System.out.println(">>Ingrese la distancia entre las ciudades: ");
					distance = read.nextInt();
					read.nextLine();
					
				break;
				}
			break; 
			}
		}while(!menu.equals("4"));
			
				
	}//End of void main
	
//----------------------Defensive programming
	 public static boolean MenuInvalido(String me) {
		 boolean incorrecto = false;
		 if (!me.equals("1") && !me.equals("2") && !me.equals("3") && !me.equals("4")) 
			 incorrecto = true;
		else 
			incorrecto = false;
		 
		 return incorrecto;
	 }
	
	 public static boolean MenuInvalido1(String me) {
		 boolean incorrecto = false;
		 if (!me.equals("1") && !me.equals("2")) 
			 incorrecto = true;
		else 
			incorrecto = false;
		 
		 return incorrecto;
	 }
	 
}//End of class
