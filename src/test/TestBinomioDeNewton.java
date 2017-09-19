package test;


import org.junit.Assert;
import org.junit.Test;

import matematica.BinomioDeNewton;
import matematica.Polinomio;

public class TestBinomioDeNewton {

	@Test
	public void queCalculaBienElCoeficienteK() {
		
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		Assert.assertEquals(4, binomio.obtenerCoeficienteTerminoK(2), 0.1);
		Assert.assertEquals(16, binomio.obtenerCoeficienteTerminoK(1), 0.1);
	}
	
	@Test
	public void desarrollaBienElBinomio() {
		
		// (2x + 4)^2 = 4x^2 + 16x + 16
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		Polinomio p = binomio.newtonFormaPolinomica();
		double[]  coeficientes = {4, 16, 16};
		Polinomio q = new Polinomio(coeficientes);
		Assert.assertEquals(p, q);
		
	}
}
