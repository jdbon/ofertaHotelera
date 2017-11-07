package com.ofertahotelera.entity;

public enum MedioDePago {

		Tarjeta(1),
		Cheque(2),
		Pago_en_Destino(3),
		Mercado_Pago(4),
		PayPal(5);
		
		private final int value;
		
		private MedioDePago (int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}	
		
}
