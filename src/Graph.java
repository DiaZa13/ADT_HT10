/**
 * @author Diana Zaray Corado Lopez #191025
 * @since 20/5/2020
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Graph {

	private Node nodes;
	private long [][] graphAdy;
	private long [][] D;
	private String paths [][];
	private String auxPaths [][];
	
	/**
	 * Constructor
	 */
	public Graph() {
		this.nodes = new Node();
		this.graphAdy = new long [5][5];
		
	}
	
	/**
	 * GraphS -> fill the initial adjacent matrix
	 */
	public void GraphS() {
		int n = nodes.actualNodes().size();
		this.graphAdy = new long [n][n];
		for(int a = 0; a < n; a++) {
			for(int b = 0; b < n; b++) {
				if(a == b)
					graphAdy[a][b] = 0;
				else
					graphAdy[a][b] = 1000000000;
			}
		}
	}
	
	/**
	 * Prueba -> returns the D matrix with the shortest path between the cities
	 * @return msg
	 */
	public String prueba(){
		String msg = "";
		for(int i = 0; i < graphAdy.length; i++) {
			for(int j = 0; j < D.length; j++) {
				msg += "[" + D[i][j] + "]-";
			}
			msg += "\n";
		}
		return msg;
	}
	
	/**
	 * cities -> returns the arrayList with all the cities in the document
	 * @return
	 */
	public ArrayList<String> cities() {
		return nodes.actualNodes();
	}
	
	/**
	 * addNode -> adds new city to the list of cities
	 * to be able to do the mapping with the adjacent matrix
	 * @param from
	 */
	public void addNode(String from) {
		nodes.addNodes(from);
	}
	
	/**
	 * addRelationship -> adds new route between two cities
	 * @param from  -> origin city
	 * @param to -> destination city
	 * @param distance -> distance between the cities
	 */
	public void addRelationship(String from, String to, int distance) {
		int a = 0;
		int b = 0;
		while(!nodes.actualNodes().get(a).equals(from)) {
			a++;
		}
		while(!nodes.actualNodes().get(b).equals(to)) {
			b++;
		}
		graphAdy [a][b] = distance;
		
	}
	
	
	/**
	 * floyAlgotithm -> calculates the shortest path between the cities
	 * implemented of @author MasterHeHeGar
	 * @see https://www.youtube.com/watch?v=xK0ShW9G-Ts
	 */
	public void floydAlgorithm() {
		
		int n = graphAdy.length;
		D = graphAdy; 
		paths = new String[n][n];
		auxPaths = new String[n][n];
		String roads = "";
		float aux1, aux2, aux3, aux4, minimum;

		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				paths[i][j] = "";
				auxPaths[i][j] = "";
			}
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					  aux1 = D[i][j];
                      aux2 = D[i][k];
                      aux3 = D[k][j];
                      aux4 = aux2 + aux3;
                      minimum = Math.min(aux1, aux4);
                      if(aux1!=aux4) {
                    	  if(minimum == aux4) {
                        	  roads = "";
                        	  auxPaths[i][j] = k + "";
                        	  paths[i][j] = tRoads(i, k, auxPaths, roads) + (k +1);
                          }  
                      }
					D[i][j] = (long) minimum;
				}
			}
		}
	}
	
	/**
	 * tRoads -> save all the traveled cities to find the shortest path 
	 * implement of @author MasterHeHeGar
	 * @see https://www.youtube.com/watch?v=xK0ShW9G-Ts
	 * @param i
	 * @param k
	 * @param auxPaths
	 * @param roads
	 * @return roads 
	 */
	public String tRoads(int i, int k, String [][] auxPaths, String roads) {
		if(auxPaths[i][k].equals("")) {
			return " ";
		}else
			roads += tRoads(i,Integer.valueOf(auxPaths[i][k]),auxPaths,roads) + (Integer.valueOf(auxPaths[i][k].toString())+ 1) + ",";
		return roads;

	}
	
	/**
	 * getRelationship -> obtains the shortest path between two cities
	 * @param from
	 * @param to
	 * @return auxPath
	 */
	public String getRelationship(String from, String to) {
		String auxPath = "";
		int a = 0;
		int b = 0;
		while(!nodes.actualNodes().get(a).equals(from)) {
			a++;
		}
		while(!nodes.actualNodes().get(b).equals(to)) {
			b++;
		}
		if(a != b) {
			if(!paths[a][b].equals("")){
				auxPath +=  "de: " +nodes.actualNodes().get(a)+" a "+nodes.actualNodes().get(b) + " Se recomienda irse por: "+ nodes.actualNodes().get(a)+"->";
			}else
				auxPath +=  "de: " +nodes.actualNodes().get(a)+" a "+nodes.actualNodes().get(b) + " Se recomienda irse por: " + nodes.actualNodes().get(a)+"->"+nodes.actualNodes().get(b);
		}
	
	if(!paths[a][b].equals("")) {
		String index = paths[a][b];
		String[] cities = index.split(",");
		for(int c = 0; c < cities.length; c ++) {
			String value = cities[c].replaceAll(" ","");
			int i = Integer.valueOf(value);
			String citie = nodes.actualNodes().get(i-1);
			auxPath += citie + "->";
			
		}
		auxPath += nodes.actualNodes().get(b);
	}
	
	if(D[a][b] != 1000000000)
		return "Para viajar " + auxPath + " \nCon una distancia mínima de recorrido de " + D[a][b] +" Km";	
	else
		return "Entre las ciudades ingresadas aun no existe un recorrido definido";
	}
	
	/**
	 * graphCenter -> calculates the center of the graph
	 * @return msg
	 */
	public String graphCenter(){
		ArrayList<Long> maximum = new ArrayList<Long>();
		String msg = "";
		for(int a = 0; a < D.length; a++) {
			long greater = 0;
			for(int b = 0; b < D.length; b++) {
				if(D[b][a] > greater)
					greater = D[b][a];
			}
			maximum.add(greater);
		}
		
		long min = Collections.min(maximum);
		
		if(min != 1000000000)
			msg = "El centro del grafo es: " + min + " Km";
		else
			msg = "Actualmente el centro del grafo no existe (es infinito)";
		return msg;
	}
	
	/**
	 * read -> read the file with the roads between cities
	 */
	public void read() {
		FileReader fr = null;
		BufferedReader br = null;
		String line, to = " ", from = " ";
		String[] cities = null;
		
		try {
			fr = new FileReader ("guategrafo.txt");
			br = new BufferedReader(fr);
			while((line = br.readLine())!=null) {
					cities = line.split(" ");
					for (int i = 0; i < cities.length; i++) {
						if (i%3 == 0)
							from = cities[i].toUpperCase();
						else if (i%3 == 1) 
							to = cities[i].toUpperCase();
					}
					addNode(from);
					addNode(to);
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
	
	}	
	

}
