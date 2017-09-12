package matematica;

public class Polinomio {
	private int grado;
	private double[] coeficientes;
	
	public Polinomio(int n){
		grado=n;
		coeficientes = new double[grado+1];
	}
	
	public double evaluarMSucesivas(double x ) {
		double resultado=coeficientes[grado];
		for(int i=0,j=grado; i<grado ;i++,j--){
			resultado += coeficientes[i] * Math.pow(x, j);
		}
		return resultado;
	}
	
	public double evaluarRecursiva(double x ,int n){
		if(n == 0)
			return coeficientes[grado];
		return ( coeficientes[grado-n]*Math.pow(x, n) ) + evaluarRecursiva(x, n-1);
	}
	public double evaluarRecursivaPar(double x ,int n){
		if(n==0)
			return coeficientes[grado];
		if(n % 2 == 0)
			return coeficientes[grado-n]*Math.pow(x*x, n/2) + evaluarRecursivaPar(x, n-1);
		return coeficientes[grado-n]*Math.pow(x, n) + evaluarRecursivaPar(x, n-1);
	}
	/*public double evaluarProgDinamica(double x ){
		
	}
	public double evaluarMejorada(double x ){
		
	}
	public double evaluarPow(double x ){
		
	}*/
	public double evaluarHorner( double x ){
		double resultado=0;
		for(int i=grado; i>=0; i--)
			resultado= resultado * x + coeficientes[i];
		return resultado;
	}

	public double[] getCoeficientes() {
		return coeficientes;
	}

	public void setCoeficientes(double coeficiente,int i) {
		this.coeficientes[i] = coeficiente;
	}
}
