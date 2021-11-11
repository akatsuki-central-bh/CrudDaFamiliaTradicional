package model;

import java.io.Serializable;

public class Doc implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String ano;
	String documento;
	String atoNormativo;
	String ementa;
	String link;
	String status;

	
	public Doc(int id, String ano, String documento, String atoNormativo, String ementa, String link, String status) {
		this.id = id;
		this.ano = ano;
		this.documento = documento;
		this.atoNormativo = atoNormativo;
		this.ementa = ementa;
		this.link = link;
		this.status = status;
	}

	public String getLinhaCompleta() {
		return ";"+ this.getAno() + ";" + this.getDocumento() + ";" + this.getAtoNormativo() + ";" + this.getEmenta()
					+ ";" + this.getLink() + ";" + this.getStatus();
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getAtoNormativo() {
		return atoNormativo;
	}

	public void setAtoNormativo(String atoNormativo) {
		this.atoNormativo = atoNormativo;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLinha() {
		return Integer.toString(getId()) + ";" + getAno() + ";" + getDocumento() + ";"
				+ getAtoNormativo() + ";" + getEmenta() + ";" + getLink() + ";" + getStatus();
	}
	
	@Override
	public String toString() {
		return "\nId: "+getId()+
				"\nAno: "+getAno()+
				"\nDocumento: "+getDocumento()+
				"\nAto Normativo: "+getAtoNormativo()+
				"\nDocumento:"+getDocumento()+
				"\nEmenta: "+getEmenta()+
				"\nLink: "+getLink()+
				"\nStatus: "+getStatus();
	}
	
}
