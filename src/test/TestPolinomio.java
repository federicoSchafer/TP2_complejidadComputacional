package test;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import matematica.Polinomio;

public class TestPolinomio {
	private Polinomio p1;
	private double resultado;
	
	@Before
	public void setUp(){
		p1 = new Polinomio(19); 
		double[] vec = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		p1.setCoeficientes(vec);
		resultado = 3.2705324314357494E18;
	}
	
	@Test
	public void calculaBienElPolinomioPorFuncionMSucesivas() {	
		Assert.assertEquals(resultado,p1.evaluarMSucesivas(8),0);
	}
	
	@Test
	public void calculaBienElPolinomioPorFuncionRecursiva() {		
		Assert.assertEquals(resultado,p1.evaluarRecursiva(8),0);
	}
	
	@Test
	public void calculaBienElPolinomioPorFuncionRecursivaPar() {		
		Assert.assertEquals(resultado,p1.evaluarRecursivaPar(8),0);
	}

	@Test
	public void calculaBienElPolinomioPorFuncionHorner() {	
		Assert.assertEquals(resultado,p1.evaluarHorner(8),0);
	}
	
	@Test
	public void calculaBienElPolinomioPorPrograDinamica() {	
		Assert.assertEquals(resultado,p1.evaluarProgDinamica(8),0);
	}
	
	@Test
	public void calculaBienElPolinomioPorFuncionPow() {		
		Assert.assertEquals(resultado,p1.evaluarPow(8),0);
	}
	
	@Test
	public void calculaBienElPolinomioPorFuncionMejorada() {		
		Assert.assertEquals(resultado,p1.evaluarMejorada(8),0);
	}
	
}
