package test;



import org.junit.Assert;
import org.junit.Test;


import matematica.Polinomio;

public class TestPolinomio {

	@Test
	public void test() {
		Polinomio p1 = new Polinomio(3); 
		p1.setCoeficientes(4, 0);
		p1.setCoeficientes(3, 1);
		p1.setCoeficientes(2, 2);
		p1.setCoeficientes(1, 3);
		boolean valorDeRetorno;
		if(p1.evaluarHorner(1) == 10)
			valorDeRetorno=true;
		else valorDeRetorno=false;
		Assert.assertEquals(true, valorDeRetorno);
		
		
		
	}

}
