package horcado.address.model;
import java.util.ArrayList;


public class Palabra {
	
	 private ArrayList<String> listaPalabra= new ArrayList<String>();
	 private static String descripcion;
	 private String inicial;
	 private static int numero;

   
     
	 public Palabra(){
		  listaPalabra.add("chiapas");
		  listaPalabra.add("oaxaca");
		  listaPalabra.add("veracruz");
		  listaPalabra.add("tabasco");
		  listaPalabra.add("campeche");
		  listaPalabra.add("yucatan");
		  listaPalabra.add("puebla");
		  listaPalabra.add("guerrero");
		  listaPalabra.add("mexico");
		  listaPalabra.add("morelos");
		  listaPalabra.add("tlaxcala");
		  listaPalabra.add("hidalgo");
		  listaPalabra.add("michoacan");
		  listaPalabra.add("guanajuato");
		  listaPalabra.add("colima");
		  listaPalabra.add("jalisco");
		  listaPalabra.add("queretaro");
		  listaPalabra.add("zacatecas");
		  listaPalabra.add("nayarit");
		  listaPalabra.add("tamaulipas");
		  listaPalabra.add("durango");
		  listaPalabra.add("sinaloa");
		  listaPalabra.add("coahuila");
		  listaPalabra.add("chihuahua");
		  listaPalabra.add("sonora");
	 }
	 
	 public void setSDecripcion() {
		 int indice = (int)(Math.random()*listaPalabra.size());
		 descripcion = listaPalabra.get(indice);
	 }
	 
	 public void setNumeroCaracter() {
		 numero = descripcion.length();
	 }
	 
	 public void setInicial() {
		  inicial = descripcion.valueOf(0);
	 }
		 
	 public int getNumeroCaracter() {
		 return numero;
	 }
	 
	 public String getInicial() {
		 return inicial;
	 }
	 
	 public String getDescripcion() {
		 return descripcion;
	 } 
}
