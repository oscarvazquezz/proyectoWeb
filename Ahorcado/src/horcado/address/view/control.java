package horcado.address.view;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import horcado.address.model.Palabra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class control {
	    @FXML private Button botonA,botonB,botonD,botonE,botonF;
	    @FXML private Button botonG,botonC,botonH,botonI,botonJ,botonK,botonL,botonN,botonnl,botonM,botonO,botonP;
	    @FXML private Button botonQ,botonR,botonS,botonT,botonU,botonV,botonW,botonX,botonY,botonZ;
	    @FXML private ImageView cabeza,cuerpo,pierna2,pierna1,brazo1,brazo2;
	    @FXML private Button click,Salir;
	    @FXML private Label nombre;
	    @FXML private ImageView vida6,vida5,vida4,vida3,vida2,vida1;
	    @FXML private HBox texto;
	    
	    private Palabra palabra  = new Palabra();
	    private static int contador = 0 ,contadorWin = 0;
	    private ArrayList<TextField> listaTexto= new ArrayList<TextField>();
	    private ArrayList<Button> listaBoton= new ArrayList<Button>();
	    private ArrayList<ImageView> listaCuerpo= new ArrayList<ImageView>();
	    private ArrayList<ImageView> listaVida= new ArrayList<ImageView>();
	    private static char [] cadena;
		private static char[] copia;
	     
	    @FXML 
	    public void initialize() {
	    	agregarArrayObjeto();
	    	obtenerPalabra();
	        agregarPrimeraPalabra(); 
	    }
	    
	    public void agregarArrayObjeto() {
	    	listaBoton.add(botonA); listaBoton.add(botonH); listaBoton.add(botonO); listaBoton.add(botonV); 
	    	listaBoton.add(botonB); listaBoton.add(botonI); listaBoton.add(botonP); listaBoton.add(botonW); 
	    	listaBoton.add(botonC); listaBoton.add(botonJ); listaBoton.add(botonQ); listaBoton.add(botonX); 
	    	listaBoton.add(botonD); listaBoton.add(botonK); listaBoton.add(botonR); listaBoton.add(botonY); 
	    	listaBoton.add(botonE); listaBoton.add(botonL); listaBoton.add(botonS); listaBoton.add(botonZ); 
	    	listaBoton.add(botonF); listaBoton.add(botonN); listaBoton.add(botonnl); listaBoton.add(botonT); 
	    	listaBoton.add(botonG); listaBoton.add(botonM); listaBoton.add(botonU); 
	    	
	    	listaCuerpo.add(cabeza); 
	    	listaCuerpo.add(cuerpo);
	    	listaCuerpo.add(brazo1); 
	    	listaCuerpo.add(brazo2);
	    	listaCuerpo.add(pierna1);
	    	listaCuerpo.add(pierna2);
	    	
	    	listaVida.add(vida1);  
	    	listaVida.add(vida2); 
	    	listaVida.add(vida3); 
	    	listaVida.add(vida4); 
	    	listaVida.add(vida5); 
	    	listaVida.add(vida6);; 
	    }
	    
	    public void obtenerPalabra() {
	    	 palabra.setSDecripcion();
	         palabra.setNumeroCaracter();
	         mostrarLetra();
	         for (int i=0;i<palabra.getNumeroCaracter();i++) {
	        	 TextField textNuevo = new TextField();
	        	 textNuevo.setEditable(false);
	        	 listaTexto.add(textNuevo);
	         }
	         texto.getChildren().addAll(listaTexto);
	         texto.setSpacing(5);
	    }
	    
	    @FXML
	    void accion(ActionEvent event) {
	          if(contador == 6 || contadorWin > 0) {
	        	 contador = 0;
	        	 contadorWin = 0;
	        	 texto.getChildren().clear();
	        	 listaTexto.clear();
	        	 obtenerPalabra();
	        	 moficarVisible();   
	             agregarPrimeraPalabra();          
	         }
	    }
	    
	    public void moficarVisible() {
	    	
	    	for(int i=0;i<listaCuerpo.size();i++) {
	    		listaCuerpo.get(i).setVisible(false);
	    	}
	    	
	    	for(int i=0;i<listaVida.size();i++) {
	    		listaVida.get(i).setVisible(true);
	    	}
	    	
	    	for(int i =0 ;i<listaBoton.size();i++) {
	    	     listaBoton.get(i).setDisable(false);
	    	  }
	    }

	    public void agregarPrimeraPalabra() {
	    	String palabraAuxiliar = Character.toString(palabra.getDescripcion().charAt(0));
	    	if(existeLetra(palabra.getDescripcion().charAt(0))){
	    		 for (int i=0;i<palabra.getNumeroCaracter();i++) {
		        	  listaTexto.get(i).setText(Character.toString(getLetra().charAt(i)));
		         }
	    		
	    		 for(int i =0 ;i<listaBoton.size();i++) {
   	        	      if(palabraAuxiliar.equals(listaBoton.get(i).getText())){
   	        		      listaBoton.get(i).setDisable(true);   
   	        	  }
   	           }
	    	}  	 
	    }
	    
	    @FXML
	    void Salir(ActionEvent event) {
	    	System.exit(0);
	    }
	    
	    @FXML
	    void activarBoton(ActionEvent event) {
	    	Button boton = (Button) event.getSource();
	        String palabraBoton = boton.getText();
	        letras(palabraBoton);
	        boton.setDisable(true);
	    }
	    
	    
	    public void letras(String palabraAuxiliar) {
	    	  if(palabra.getNumeroCaracter() == contadorWin || contador == 6) {
	    		  JOptionPane.showMessageDialog(null,"lo siento ya no se puede jugar");
	    	   }else {
	    		    if(existeLetra(palabraAuxiliar.charAt(0))) {
	    			     for (int i=0;i<palabra.getNumeroCaracter();i++) {
	    		        	 listaTexto.get(i).setText(Character.toString(getLetra().charAt(i)));
	    		         }
	    			      if(getLetra().equals(palabra.getDescripcion())) { 
	    		              JOptionPane.showMessageDialog(null,"felicidades ganaste el juego","Win",JOptionPane.QUESTION_MESSAGE,new ImageIcon("Imangen/imagen/ganador.png"));
	    		              contadorWin = palabra.getNumeroCaracter();
	       		         }
	    		    }else {
	    			    mostrar(); 
	    			    contador++;
	    		  } 
	    		  if(contador == 6) {
	        		    JOptionPane.showMessageDialog(null,"lo siento ya perdio el juego","perdedor",JOptionPane.QUESTION_MESSAGE,new ImageIcon("Imangen/imagen/perdedor.png"));	
	        	  }
	    	  }
	    }
	    
	    public boolean existeLetra(char letras){
		     boolean existe = false;
		     cadena = palabra.getDescripcion().toCharArray();
		      for (int x=0;x<palabra.getNumeroCaracter();x++) {
		    	  if (cadena[x] ==  letras){
			            cadena[x] = letras;
			            copia[x] = cadena [x];
			            existe = true;
			        }
		      }
		      return existe;
		 }   
		 
		 public void mostrarLetra() {
			 copia = palabra.getDescripcion().toCharArray();
		      for (int x = 0; x <copia.length; x++) {
		         copia[x] = '_';
		     }
		 }
		 
		 public String getLetra() {
		   return String.valueOf(copia);
		 }
	   
	    public void mostrar() {
	       listaCuerpo.get(contador).setVisible(true);
	       listaVida.get(contador).setVisible(false);
	    }
}