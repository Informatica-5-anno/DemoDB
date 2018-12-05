
public class Panificio {
	
	private String provincia;
	private String citta;
	private String regione;
	private String panificio;
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public String getPanificio() {
		return panificio;
	}
	public void setPanificio(String panificio) {
		this.panificio = panificio;
	}
	
	@Override
	public String toString() {
		return "Panificio [provincia=" + provincia + ", citta=" + citta + ", regione=" + regione + ", panificio="
				+ panificio + "]";
	}
}
