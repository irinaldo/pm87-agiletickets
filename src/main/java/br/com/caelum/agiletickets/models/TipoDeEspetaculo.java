package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public BigDecimal getPreco(Double percentual, Integer duracao,BigDecimal precoPadrao) {
			 Double fatorDeAjuste = 0.10;
			 if(percentual<=0.05){
				 return precoPadrao.add(precoPadrao.multiply(BigDecimal.valueOf(fatorDeAjuste)));	 
			 }
			return precoPadrao;
		}
	},SHOW   {
		@Override
		public BigDecimal getPreco(Double percentual, Integer duracao,BigDecimal precoPadrao) {
			 Double fatorDeAjuste = 0.10;
			 if(percentual<=0.05){
				 return precoPadrao.add(precoPadrao.multiply(BigDecimal.valueOf(fatorDeAjuste)));	 
			 }
			return precoPadrao;
		}
		
	},TEATRO  {
		@Override
		public BigDecimal getPreco(Double percentual, Integer duracao,BigDecimal precoPadrao) {
			// TODO Auto-generated method stub
			return precoPadrao;
		}
	},BALLET {
		@Override
		public BigDecimal getPreco(Double percentual, Integer duracao,BigDecimal precoPadrao) {
			 Double fatorDeAjuste = 0.20;
			 int duracaoMinimaParaAumentoDePreco = 60;
			 Double fatorDeAjustePorDuracao = 0.10;
			 BigDecimal precoIntermediario ;
			 precoIntermediario = precoPadrao;
			 if(percentual<=0.50){				 
				 precoIntermediario =  precoPadrao.add(precoPadrao.multiply(BigDecimal.valueOf(fatorDeAjuste)));	 
			 }
				 
			if(duracao > duracaoMinimaParaAumentoDePreco){
				precoIntermediario = precoIntermediario.add(precoPadrao.multiply(BigDecimal.valueOf(fatorDeAjustePorDuracao)));
			}
			return precoIntermediario;
		}
		
	},ORQUESTRA {
		@Override
		public BigDecimal getPreco(Double percentual, Integer duracao,BigDecimal precoPadrao) {
			Double fatorDeAjuste = 0.20;
			 int duracaoMinimaParaAumentoDePreco = 60;
			 Double fatorDeAjustePorDuracao = 0.10;
			 BigDecimal precoIntermediario ;
			 precoIntermediario = precoPadrao;
			 if(percentual<=0.50){				 
				 precoIntermediario =  precoPadrao.add(precoPadrao.multiply(BigDecimal.valueOf(fatorDeAjuste)));	 
			 }
				 
			if(duracao > duracaoMinimaParaAumentoDePreco){
				precoIntermediario = precoIntermediario.add(precoPadrao.multiply(BigDecimal.valueOf(fatorDeAjustePorDuracao)));
			}
			return precoIntermediario;
		}
		
	};
	public abstract BigDecimal getPreco(Double percentual,Integer duracao,BigDecimal precoPadrao);
		
	
	
}
