import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Studente {

	private int id;
	private String nome;
	private String cognome;
	private HashMap<String, ArrayList<Double>> voti;

	/******************* COSTRUTTORE *************************/

	public Studente(int id, String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.voti = assegnaMateria();
		this.id = id;
	}

	/******************* METODI *************************/

	public String toString() {
		String s = "";
		s += "Nome: " + nome + "\nCognome: " + cognome + "\nVoti: " + voti;
		return s;
	}

	//media dei voti per la materia passata come parametro
	private double mediaVotiMateria(String materia) {
		double somma = 0;
		if (voti.containsKey(materia)) {

		}
		return somma / voti.size();
	}

	//trovare il voto piu' alto per la materia passata come parametro
	public double votoMiglioreMateria(String materia) {
		HashMap<String, ArrayList<Double>> max = getVoti();
		List<Double> listaVoti = max.get(materia);
		return listaVoti.stream().reduce(0.0, (subtotale, voto) -> voto > subtotale ? subtotale = voto : subtotale);
	}

	//se la media dei voti per materia e' superiore a 6 per almento 4 materie allori si e' promossi
	protected boolean Promosso(){
		 HashMap<String, ArrayList<Double>> voti = getVoti();
	        Stream<String> listaMaterie = voti.keySet().stream();
	        long cont = listaMaterie.filter(materia -> mediaVotiMateria(materia)>6).count();
	        return cont < 4;
	}
	
	//media totate dello studente
	public double mediaTotale(){
        Stream<String> materie = getVoti().keySet().stream();
        double somma = materie.mapToDouble(materia -> mediaVotiMateria(materia)).sum();

        return  somma/getVoti().size();
    }

	
	//funzione che assegna i voti tra 2 e 10 in maniera random
	private ArrayList<Double> assegnaVoti(){
        Random random = new Random();
        Double[] arrVotiRndm = new Double[6];
        for (int i = 0; i < arrVotiRndm.length; i++){
            arrVotiRndm[i] = (double) random.nextInt((9) + 2);
        }
        Stream<Double> listVotiRndm = Arrays.stream(arrVotiRndm);
        return (ArrayList<Double>) listVotiRndm.collect(Collectors.toList());
    }

	//metodo che assegna alle materie scelte dei voti random creati con il metodo qui sopra
	 public HashMap<String, ArrayList<Double>> assegnaMateria(){
	        HashMap<String, ArrayList<Double>> randomMap = new HashMap<>();
	        randomMap.put("Italiano",assegnaVoti());
	        randomMap.put("Matematica",assegnaVoti());
	        randomMap.put("Inglese",assegnaVoti());
	        randomMap.put("Scienze",assegnaVoti());
	        randomMap.put("Storia",assegnaVoti());
	        randomMap.put("Biologia",assegnaVoti());
	        return randomMap;
	    }
	/******************* GETTER *************************/

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public HashMap<String, ArrayList<Double>> getVoti() {
		return voti;
	}

	/******************* SETTER *************************/

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setVoti(HashMap<String, ArrayList<Double>> voti) {
		this.voti = voti;
	}

}
