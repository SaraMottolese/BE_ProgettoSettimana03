import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

public class Scuola {
	
	private List <Studente> scuola;

	
	/*******************		COSTRUTTORE		*************************/
	
	public Scuola(List<Studente> scuola) {
		this.scuola = scuola;
		//studenti.forEach((studente)-> {int i=1; studente.setId(i); i++}); 
	}

	/*******************		METODI		*************************/
	
	
	//creo un ArrayList di studenti su cui ciclo il metodo Promosso, per vedere se ci sono studenti promossi
	public List<Studente>  getPromossi(){
	List<Studente> listaStudenti = new ArrayList<>();
    Stream<Studente> promossi = getScuola().stream();
    promossi.filter(el -> el.Promosso()).forEach(listaStudenti::add);
    if (listaStudenti.size() == 0) {
        System.out.println("\nNessuno e' stato promosso!");
    } else {
        System.out.println("\nI promossi sono: ");
    }
    return listaStudenti;
    }
	
	public  List<Studente> getStudenti(){
		return scuola;
	}
	
	
	//controlla la medua degli studenti per trovare il migliore della scuola
	public Studente getStudenteMigliore(){
		Stream<Studente> studenti = getStudenti().stream();
        return studenti.reduce((max, stud) -> stud.mediaTotale() > max.mediaTotale() ? max = stud : max).get();
	}
	
	
	//metodo per salvare gli studenti sul file txt
	 public void salvaStudenti(File file) {
	        if (file.exists()) {
	            System.out.println();
	            try {
	                FileUtils.writeStringToFile(file, getStudenti().toString(), "UTF-8", true);
	            } catch (IOException e) {
	            }
	        } else {
	            System.out.println("File non trovato!");
	        }
	    }
	
	
	
	/*******************		GETTER E SETTER		*************************/
	
    public List<Studente> getScuola() {
		return scuola;
	}

	public void setScuola(List<Studente> scuola) {
		this.scuola = scuola;
	}
	
	
	
}

	
