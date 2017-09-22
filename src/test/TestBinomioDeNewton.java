package test;


import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Calendar;

import matematica.BinomioDeNewton;
import matematica.Polinomio;

public class TestBinomioDeNewton {

	/*@Test
	public void queCalculaBienElCoeficienteK() {
				
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		Assert.assertEquals(4, binomio.obtenerCoeficienteTerminoK(2), 0.1);
		Assert.assertEquals(16, binomio.obtenerCoeficienteTerminoK(1), 0.1);
		Assert.assertEquals(16, binomio.obtenerCoeficienteTerminoK(0), 0.1);
		
	}
	
	@Test
	public void queCalculaBienElCoeficienteKConTartaglia() {
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		Assert.assertEquals(16, binomio.obtenerCoeficienteTerminoKTartaglia(2), 0.1);
		Assert.assertEquals(16, binomio.obtenerCoeficienteTerminoKTartaglia(1), 0.1);
		Assert.assertEquals(4, binomio.obtenerCoeficienteTerminoKTartaglia(0), 0.1);
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
		
	}*/
	
	@Test
	public void desarrollaBienElBinomioConTartaglia() {
		// (2x + 4)^2 = 4x^2 + 16x + 16
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 2);
		Polinomio p = binomio.newtonFormaPolinomicaTartaglia();
		double[]  coeficientes = {4, 16, 16};
		Polinomio q = new Polinomio(coeficientes);
		System.out.println(p.toString());
		System.out.println(q.toString());
		Assert.assertEquals(true, q.equals(p));
	}
	
	/*@Test
	public void tiempoDeEjecucionObtencionCoeficienteK() {
		
		Calendar tIni = new GregorianCalendar();
		
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 1000000);
		binomio.obtenerCoeficienteTerminoK(0);
		
		Calendar tFin = new GregorianCalendar();

		System.out.println("El calculo de obtener el desarrollo del binomio fue: "
				+ ( tFin.getTimeInMillis() - tIni.getTimeInMillis()) +" milisegundos");
	}
	
	@Test
	public void tiempoDeEjecucionDesarrolloDeBinomio() {
		
		Calendar tIni = new GregorianCalendar();
	
		BinomioDeNewton binomio = new BinomioDeNewton(2, 4, 200000);
		binomio.newtonFormaPolinomica();
		
		Calendar tFin = new GregorianCalendar();

		System.out.println("El calculo de obtener el desarrollo del binomio fue: "
				+ ( tFin.getTimeInMillis() - tIni.getTimeInMillis()) +" milisegundos");
		
	}*/
	
}
