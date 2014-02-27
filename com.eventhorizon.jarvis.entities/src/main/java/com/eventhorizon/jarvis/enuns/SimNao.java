package com.eventhorizon.jarvis.enuns;

public enum SimNao {

	SIM("S", "Sim"), NAO("N", "Não");

	private String valor;
	private String description;

	private SimNao(String description) {
		this.description = description;
	}

	private SimNao(String valor, String description) {
		this.valor = valor;
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

	public Boolean toBoolean() {
		return this.equals(SIM);
	}

	public static SimNao toEnum(Boolean value) {
		return value ? SimNao.SIM : SimNao.NAO;
	}

	public String getValor() {
		return valor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static SimNao getSimNao(final String valor) {
		if ("1".equals(valor) || "S".equalsIgnoreCase(valor)) {
			return SimNao.SIM;
		}
		return SimNao.NAO;
	}

}
