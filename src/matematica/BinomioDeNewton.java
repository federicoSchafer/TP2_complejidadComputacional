package matematica;

public class BinomioDeNewton {
	
	private double a;
	private double b;
	private int grado;
	private int [][] tartaglia;
	
	public BinomioDeNewton(double primerTermino, double segundoTermino, int gr) {
		a = primerTermino;
		b = segundoTermino;
		grado = gr;
		generarTrianguloDeTartaglia(grado + 1);
	}
	
	/**PUNTO 1 */
	
	public double obtenerCoeficienteTerminoK(int k) {
		
		return (int) (calculoCombinatoria(grado, k) * Math.pow(a, k) * Math.pow(b, grado - k) );
	}
	
	public int obtenerCoeficienteTerminoKTartaglia(int k) {
		return (int) (tartaglia[grado][k] * Math.pow(a, grado - k) * Math.pow(b, k));
	}
	
	/** PUNTO 2 */
	
	public Polinomio newtonFormaPolinomica() {
		double [] coeficientes = new double[grado + 1];
		for(int i = 0; i <= grado; i++ ) {
			coeficientes[i] = obtenerCoeficienteTerminoK(grado-i);
		}
		return new Polinomio(coeficientes);
	}
	
	public Polinomio newtonFormaPolinomicaTartaglia() {
		double[] coeficientes = new double[grado + 1];
		for (int i = 0; i <= grado; i++) {
			coeficientes[i] = obtenerCoeficienteTerminoKTartaglia(i);
		}
		return new Polinomio(coeficientes);
	}
	
	/** metodos necesarios */
	
	public double factorial(double num) {
		double resul=1;
		
		for(int j=1; j <= num; j++) {
			resul *= j;
		}
		return resul;
	}
	
	public double factorialRecursivo(double num) {
		if(num == 0)
			return 1;
		return num * factorialRecursivo(num-1);
	}
	
	public double calculoCombinatoria(double m, double n) {
		double combinatoria;
		combinatoria = factorial(m) / (factorial(n) * factorial(m-n));
		return combinatoria;
	}
	
	public double combinatoriaRecursiva(double m, double n) {
		if (m == 0 || m == n) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else {
			return combinatoriaRecursiva(m - 1, n - 1) + combinatoriaRecursiva(m - 1, n);
		}
	}
	
	public int[][] trianguloDeTartaglia(int n) {
		int[][] tartaglia = new int[n][n];
		for (int i = 0; i < tartaglia.length; i++) {
			tartaglia[i][i] = 1;
			tartaglia[i][0] = 1;
		}
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				tartaglia[i][j] = tartaglia[i - 1][j - 1] + tartaglia[i - 1][j];
			}
		}
		return tartaglia;
	}
	
	private void generarTrianguloDeTartaglia(int i) {
		tartaglia = trianguloDeTartaglia(grado + 1);
	}

}
