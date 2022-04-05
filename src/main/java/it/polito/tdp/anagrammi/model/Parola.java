package it.polito.tdp.anagrammi.model;

import java.util.Objects;

public class Parola {

	private String parola;

	public Parola(String parola) {
		this.parola = parola;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	@Override
	public int hashCode() {
		return Objects.hash(parola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		return Objects.equals(parola, other.parola);
	}
	
	@Override
	public String toString() {
		return "- " + this.parola+ "\n";
	}
	
}
