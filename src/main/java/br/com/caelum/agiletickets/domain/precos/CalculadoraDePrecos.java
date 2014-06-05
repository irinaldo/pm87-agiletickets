package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcularPrecoDoIngresso(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		TipoDeEspetaculo tipoEspetaculo;
		tipoEspetaculo= sessao.getEspetaculo().getTipo();
		preco= tipoEspetaculo.getPreco(getTotalDeIngressoPorcentagem(sessao),sessao.getDuracaoEmMinutos(), sessao.getPreco());
		
		return preco.multiply(BigDecimal.valueOf(quantidade));
		
	}

	private static double getTotalDeIngressoPorcentagem(Sessao sessao) {
		return getTotalIngressosDisponiveis(sessao) / getTotalDeIngressos(sessao);
	}


	private static int getTotalIngressosDisponiveis(Sessao sessao) {
		return sessao.getTotalIngressos() - sessao.getIngressosReservados();
	}

	private static double getTotalDeIngressos(Sessao sessao) {
		return sessao.getTotalIngressos().doubleValue();
	}

	private static int getIngressosDisponiveis(Sessao sessao) {
		return sessao.getTotalIngressos() - sessao.getIngressosReservados();
	}

}