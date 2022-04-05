package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.ParolaDAO;

public class Model {
	
	ParolaDAO parolaDao;
	Set<Parola> soluzione;
	
	public Model() {
		parolaDao = new ParolaDAO();
	}
	
	public boolean isPresente(String parola) {
		return this.parolaDao.isPresente(parola);
	}
	
	public Set<Parola> calcolaAnagrammi(String parola) {
		soluzione = new HashSet<>();
		this.calcolaAnagrammi_ricorsiva(parola, 0, "");
		return soluzione;
	}

	private void calcolaAnagrammi_ricorsiva(String rimanenti, int livello, String parziale) {
		
		// condizione terminale
		if(rimanenti.isEmpty()) {
			soluzione.add(new Parola(parziale));
		}
		
		// condizione normale
		for(int pos=0; pos < rimanenti.length(); pos++) {
			String nuovaParziale = parziale + rimanenti.charAt(pos);
			String nuovaRimanenti = rimanenti.substring(0,pos) + rimanenti.substring(pos+1);
			this.calcolaAnagrammi_ricorsiva(nuovaRimanenti, livello+1, nuovaParziale);
		}
	}
	
}
