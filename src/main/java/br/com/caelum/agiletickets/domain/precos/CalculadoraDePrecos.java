package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcularPrecoDoIngresso(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		preco = sessao.getPreco();
		if(((sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW))) 
			&& (getPorcentagemDeIngressosDisponiveis(sessao) <= 0.05)) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		} else if((sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)) || (sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA))){
			if(getPorcentagemDeIngressosDisponiveis(sessao) <= 0.50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
			}
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
			}
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static double getPorcentagemDeIngressosDisponiveis(Sessao sessao) {
		return getIngressosDisponiveis(sessao) / getTotalDeIngressos(sessao);
	}

	private static double getTotalDeIngressos(Sessao sessao) {
		return sessao.getTotalIngressos().doubleValue();
	}

	private static int getIngressosDisponiveis(Sessao sessao) {
		return sessao.getTotalIngressos() - sessao.getIngressosReservados();
	}

}