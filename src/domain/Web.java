package domain;

public class Web {
	private String link = null;
	private int codigo = 0;
	
	public Web (String l, int cdg) {
		setLink(l);
		setCodigo(cdg);
	}
	public Web() {}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Devuelve el string sin la parte definido en el regex
	 * @param link
	 * @return link sin numero, guines y .String
	 */
	public String seprateStringFromLink(String link) {
		String auxString = stringFromArray(link.split("([.][a-z]+)"));
		return stringFromArray(auxString.split("([0-9]+[-])"));
		
	}
	
	private String stringFromArray (String[] s) {
		String stringNoVacio = null;
		for (String a : s) {
			if(a != null) {
				stringNoVacio = a;
			}else {
				stringNoVacio = "El array esta vacio";
			}
		}
		return stringNoVacio;
	}
}
