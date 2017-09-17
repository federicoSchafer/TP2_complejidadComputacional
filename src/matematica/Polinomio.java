package matematica;

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
	
	public double evaluarMSucesivas(double x ) {
		double resultado=coeficientes[grado];
		int i,j;
		for(i=0,j=grado; i<grado ;i++,j--){
			resultado += coeficientes[i] * myPow(x, j);
		}
		return resultado;
	}
	
	public double evaluarRecursiva(double x){
		return evaluarRecursiva1(x, grado);
	}
	
	private double evaluarRecursiva1(double x ,int n){
		if(n == 0)
			return coeficientes[grado];
		return ( coeficientes[grado-n] * myPow(x, n) ) + evaluarRecursiva1(x, n-1);
	}
	
	public double evaluarRecursivaPar(double x){
		return evaluarRecursivaPar1(x,grado);
	}
	
	public double evaluarRecursivaPar1(double x ,int n){
		if(n==0)
			return coeficientes[grado];
		if(n % 2 == 0)
			return coeficientes[grado-n] * myPow(x*x, n/2) + evaluarRecursivaPar1(x, n-1);
		return coeficientes[grado-n] * myPow(x, n) + evaluarRecursivaPar1(x, n-1);
	}
	
	public double evaluarProgDinamica(double x ){
		double[] vectorResul = new double[grado+1];
		int i;
		vectorResul[grado] = coeficientes[grado] * myPow(x, 0);
		for(i=grado-1 ; i>=0 ; i--){
			vectorResul[i] = coeficientes[i] * myPow(x, i) + vectorResul[i+1];
		}
		return vectorResul[i+1];
	}
	
	public double evaluarMejorada(double x ){
				
		return 1;
	}
	
	public double evaluarPow(double x ){
		double resultado=coeficientes[grado];
		int i,j;
		for(i=0,j=grado; i<grado ;i++,j--){
			resultado += coeficientes[i] * Math.pow(x, j);
		}
		return resultado;
	}
	
	public double evaluarHorner( double x ){
		double resultado=0;
		for(int i=grado; i>=0; i--)
			resultado= resultado * x + coeficientes[i];
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
