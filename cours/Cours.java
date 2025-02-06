package cours;

public class Cours {
	private final int nbPlacesMax;
	private final int numeroCours;
	private final String intitul�;
	private int nbInscrits;

	public Cours(int numeroCours, String intitul�, int nbPlacesMax) {
		this.numeroCours = numeroCours;
		this.intitul� = intitul�;
		this.nbPlacesMax = nbPlacesMax;
		this.nbInscrits = 0;
	}


	public void inscription(int nbPlaces) throws PasAsseezDePlacesException {
		synchronized (this){
			if (this.nombrePlacesRestant() < nbPlaces)
				throw new PasAsseezDePlacesException(this, nbPlaces);
			this.nbInscrits += nbPlaces;
			System.out.println(nbPlaces+ " inscriptions r�ussies au cours "+this);
		}
	}

	private int nombrePlacesRestant() {
		return (this.nbPlacesMax - this.nbInscrits);
	}

	@Override
	public String toString() {
		return String.valueOf(this.numeroCours) + " : " + intitul� + " " + this.nombrePlacesRestant() + " places restants";
	}



}
