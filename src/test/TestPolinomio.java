package test;



import org.junit.Assert;
import org.junit.Test;


import matematica.Polinomio;

public class TestPolinomio {

	@Test
	public void test() {
		Polinomio p1 = new Polinomio(3); 
		double[] vec = {4,3,2,1};
		p1.setCoeficientes(vec);
		
		Assert.assertEquals(10,p1.evaluarProgDinamica(1),0);
		
		
		
	}

}
