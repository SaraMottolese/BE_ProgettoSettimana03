import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		File infoStudenti = new File("src/file/infoStudenti.txt");
		// creazione degli studenti con assegnazione random dei voti per materia
		Studente s1 = new Studente(1, "Mario", "Rossi");
		Studente s2 = new Studente(2, "Giulia", "Bianchi");
		Studente s3 = new Studente(3, "Gianluca", "Verdi");
		Studente s4 = new Studente(4, "Alba", "Arancioni");
		Studente s5 = new Studente(5, "Roberto", "Rosa");
		Studente s6 = new Studente(6, "Elvira", "Giunti");
		Studente s7 = new Studente(7, "Marco", "Belli");
		Studente s8 = new Studente(8, "Alberto", "Neri");
		Studente s9 = new Studente(9, "Claudia", "Fucsia");
		Studente s10 = new Studente(10, "Federico", "Federici");

		// creazione lista sudenti per la scuola 1
		List<Studente> listaScuola1 = new ArrayList<>();
		listaScuola1.add(s1);
		listaScuola1.add(s2);
		listaScuola1.add(s3);
		listaScuola1.add(s4);
		listaScuola1.add(s5);

		// creazione lista sudenti per la scuola 1
		List<Studente> listaScuola2 = new ArrayList<>();
		listaScuola2.add(s6);
		listaScuola2.add(s7);
		listaScuola2.add(s8);
		listaScuola2.add(s9);
		listaScuola2.add(s10);

		// assegnazione delle liste studenti per ogni scuola
		Scuola scuola1 = new Scuola(listaScuola1);
		Scuola scuola2 = new Scuola(listaScuola2);

		
		scuola1.salvaStudenti(infoStudenti);
		
		
		// verifica dei metodi SCUOLA 1
		System.out.println("===========================		SCUOLA 1	=======================");
		System.out.println(scuola1.getPromossi());
		System.out.println("..................");
		System.out.println("\nLa lista completa degli studenti della scuola e': " + "\n" + scuola1.getStudenti());
		System.out.println("..................");
		System.out.println("\nIl voto migliore di Matematica di " + s1.getNome() + " e' "
				+ (s1.votoMiglioreMateria("Matematica")));
		System.out.println("..................");
		System.out.println("\nLo studente migliore e': " + scuola1.getStudenteMigliore() + " con una media di "
				+ scuola1.getStudenteMigliore().mediaTotale());
		
		// verifica dei metodi SCUOLA 2
		System.out.println("===========================		SCUOLA 2	=======================");

		System.out.println(scuola2.getPromossi());
		System.out.println("..................");
		System.out.println("\nLa lista completa degli studenti della scuola e': " + "\n" + scuola2.getStudenti());
		System.out.println("..................");
		System.out.println("\nIl voto migliore di Matematica di " + s10.getNome() + " e' "
				+ (s10.votoMiglioreMateria("Matematica")));
		System.out.println("..................");
		System.out.println("\nLo studente migliore e': " + scuola2.getStudenteMigliore() + " con una media di "
				+ scuola2.getStudenteMigliore().mediaTotale());
		System.out.println("==========================================");

	}

}
