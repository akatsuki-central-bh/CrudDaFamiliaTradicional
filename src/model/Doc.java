package model;

import java.io.Serializable;

public class Doc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String ano, documento, atoNormativo, ementa, link, status;
	
	public Doc(String ano, String documento, String atoNormativo, String ementa, String link, String status) {
		this.ano = ano;
		this.documento = documento;
		this.atoNormativo = atoNormativo;
		this.ementa = ementa;
		this.link = link;
		this.status = status;
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
	
	@Override
	public String toString() {
		return "\nAno: "+getAno()+
				"\nDocumento: "+getDocumento()+
				"\nAto Normativo: "+getAtoNormativo()+
				"\nDocumento:"+getDocumento()+
				"\nEmenta: "+getEmenta()+
				"\nLink: "+getLink()+
				"\nStatus: "+getStatus();
	}
	
}
