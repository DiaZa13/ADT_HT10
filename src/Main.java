import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static <K, V> void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;
		BufferedReader br = null;
		Scanner read = new Scanner(System.in);
		String line, to = " ", from = " ", fromCity, toCity, menu, mMenu;
		int distance = 0, a = 0;
		String[] cities = null;
		boolean tmenu;	
		Graph graph = new Graph();
		
		graph.read();
		graph.GraphS();
		
	

		
//---------------------Read the text with the nodes and edges
		try {
			fr = new FileReader ("guategrafo.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
					cities = line.split(" ");
					for (int i = 0; i < cities.length; i++) {
						if (i%3 == 0)
							from = cities[i].toUpperCase().trim();
						else if (i%3 == 1) 
							to = cities[i].toUpperCase().trim();
						else if(i%3 == 2)
							distance = Integer.valueOf(cities[i]); 
					}
					graph.addRelationship(from, to, distance);
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
		graph.floydAlgorithm();
		//System.out.println(graph.prueba());
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
				System.out.print(">>Ingrese ciudad de origen: ");
				fromCity = read.nextLine();
				System.out.print(">>Ingrese ciudad de destino: ");
				toCity = read.nextLine();
				if(graph.cities().contains(fromCity.toUpperCase().trim()) && graph.cities().contains(toCity.toUpperCase().trim())) {
					System.out.println(graph.getRelationship(fromCity.toUpperCase().trim(), toCity.toUpperCase().trim()));
				}else
					System.out.println("Las ciudades ingresadas no se encuentran en el documento proporcionado");
				break;
		
			case("2"):
				System.out.println(graph.graphCenter());
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
					System.out.print(">>Ingrese ciudad de origen: ");
					fromCity = read.nextLine();
					System.out.print(">>Ingrese ciudad de destino: ");
					toCity = read.nextLine();
					if(graph.cities().contains(fromCity.toUpperCase().trim()) && graph.cities().contains(toCity.toUpperCase().trim())) {
						graph.addRelationship(fromCity.toUpperCase().trim(), toCity.toUpperCase().trim(), 1000000000);						
						graph.floydAlgorithm();
					}else
						System.out.println("Las ciudades ingresadas no se encuentran en el documento proporcionado, \npor lo tanto no se puede actualizar la ruta. \nPor favor agregue las ciudades al documento");
					
				break;
				case "2":
					System.out.print(">>Ingrese ciudad de origen: ");
					fromCity = read.nextLine();
					System.out.print(">>Ingrese ciudad de destino: ");
					toCity = read.nextLine();
					System.out.print(">>Ingrese la distancia entre las ciudades: ");
					distance = read.nextInt();
					read.nextLine();
					if(graph.cities().contains(fromCity.toUpperCase().trim()) && graph.cities().contains(toCity.toUpperCase().trim())) {
						graph.addRelationship(fromCity.toUpperCase().trim(), toCity.toUpperCase().trim(), distance);						
						graph.floydAlgorithm();
					}else
						System.out.println("Las ciudades ingresadas no se encuentran en el documento proporcionado, \npor lo tanto no se puede agregar una nueva ruta entre ellas. \nPor favor agregue las ciudades al documento");
					
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
