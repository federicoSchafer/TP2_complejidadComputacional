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
		Assert.assertEquals(16, binomio.obtenerCoeficienteTerminoK(0), 0.1);
		
	}
	
	@Test
	public void desarrollaBienElBinomio() {
		
		// (2x + 4)^2 = 4x^2 + 16x + 16
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		Polinomio p = binomio.newtonFormaPolinomica();
		double[]  coeficientes = {4, 16, 16};
		Polinomio q = new Polinomio(coeficientes);
		//System.out.println(p.toString());
		//System.out.println(q.toString());
		Assert.assertEquals(true, q.equals(p));
		
	}
	
	@Test
	public void tiempoDeEjecucionObtencionCoeficienteK() {
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		binomio.obtenerCoeficienteTerminoK(2);
		
		time_end = System.currentTimeMillis();
		System.out.println("El calculo de obtener el coeficiente K tomo: "
							+ ( time_end - time_start ) +" milisegundos");
	}
	
	@Test
	public void tiempoDeEjecucionDesarrolloDeBinomio() {
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 1000);
		binomio.newtonFormaPolinomica();
		
		time_end = System.currentTimeMillis();
		System.out.println("El calculo de obtener el desarrollo del binomio fue: "
							+ ( time_end - time_start ) +" milisegundos");
	}
}
