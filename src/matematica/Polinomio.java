package matematica;

import java.util.Arrays;

public class Polinomio {
	private int grado;
	private double[] coeficientes;
	
	public Polinomio(int n){
		grado=n;
		coeficientes = new double[grado+1];
	}
	
	public Polinomio(double[] coeficientes) {
		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}
	
	/*
	 Complejidad Computacional;
	 MSucesivas -> O(n^2) 
	*/
	
	public double evaluarMSucesivas(double x ) {
		double resultado=coeficientes[grado];
		int i,j;
		for(i=0,j=grado; i<grado ;i++,j--){
			resultado += coeficientes[i] * myPow(x, j);
		}
		return resultado;
	}

	/*
	 Complejidad Computacional;
	 Recursiva -> O(n!) 
	 */
	
	public double evaluarRecursiva(double x){
		return evaluarRecursiva1(x, grado);
	}
	
	private double evaluarRecursiva1(double x ,int n){
		if(n == 0)
			return coeficientes[grado];
		return ( coeficientes[grado-n] * myPow(x, n) ) + evaluarRecursiva1(x, n-1);
	}
	
	/*
	 Complejidad Computacional;
	 RecursivaPar -> O(n!) 
	 */
	
	public double evaluarRecursivaPar(double x){
		return evaluarRecursivaPar1(x, grado);
	}
	
	private double evaluarRecursivaPar1(double x ,int n){
		if(n==0)
			return coeficientes[grado];
		if(n % 2 == 0)
			return coeficientes[grado-n] * myPow(x*x, n/2) + evaluarRecursivaPar1(x, n-1);
		return coeficientes[grado-n] * myPow(x, n) + evaluarRecursivaPar1(x, n-1);
	}
	
	/*
	 Complejidad Computacional;
	 ProgDinamica -> O(n^2) 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coeficientes);
		result = prime * result + grado;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polinomio other = (Polinomio) obj;
		if (!Arrays.equals(coeficientes, other.coeficientes))
			return false;
		if (grado != other.grado)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Polinomio [grado=" + grado + ", coeficientes=" + Arrays.toString(coeficientes) + "]";
	}

	public double evaluarProgDinamica(double x ){
		double[] vectorResul = new double[grado+1];
		int i;
		vectorResul[grado] = coeficientes[grado] * myPow(x, 0);
		for(i=grado-1 ; i>=0 ; i--){
			vectorResul[i] = coeficientes[i] * myPow(x, grado - i) + vectorResul[i+1];
		}
		return vectorResul[i+1];
	}
	
	/*
	 Complejidad Computacional;
	 Mejorada -> O(n)
	 */
	
	public double evaluarMejorada(double x){
		double resultado = coeficientes[grado];
		double potencia = x;
		for (int i = grado - 1; i >= 0; i--) {
			resultado += coeficientes[i] * potencia;
			potencia *= x;
		}
		return resultado;
	}
	
	/*
	 Complejidad Computacional;
	 Pow -> O(n^2 log n) 
	 */
	
	public double evaluarPow(double x ){
		double resultado=coeficientes[grado];
		int i,j;
		for(i=0,j=grado; i<grado ;i++,j--){
			resultado += coeficientes[i] * Math.pow(x, j);
		}
		return resultado;
	}
	
	/*
	 Complejidad Computacional;
	 Horner -> O(n) 
	 */
	
	public double evaluarHorner( double x ){
		double resultado=0;
		double [] vectorHorner = new double[grado+1];
		for( int j = 0 ; j <= grado ; j++){
			vectorHorner[j] = coeficientes[grado-j];
		}
		for(int i=grado; i>=0; i--)
			resultado = (resultado * x) + vectorHorner[i];
		return resultado;
	}

	public double[] getCoeficientes() {
		return coeficientes;
	}

	public void setCoeficientes(double[] coeficiente) {
		this.coeficientes = coeficiente;
	}
	
	private double myPow(double x , int n){
		double resultado=x;
		for(int i=1 ; i<n ; i++)
			resultado *= x;
		return resultado;
	}
}
