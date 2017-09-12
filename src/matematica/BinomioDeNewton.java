package matematica;

public class BinomioDeNewton {
	
	private double a;
	private double b;
	private int grado;
	
	public BinomioDeNewton(double primerTermino, double segundoTermino, int gr) {
		a = primerTermino;
		b = segundoTermino;
		grado = gr;
	}
	
	/**PUNTO 1 */
	
	public double obtenerCoeficienteTerminoK(int k) {
		
		return (int) (calculoCombinatoria(grado, k) * Math.pow(a, k) * Math.pow(b, grado-k) );
	}
	
	/** PUNTO 2 */
	
	public Polinomio newtonFormaPolinomica() {
		double [] coeficientes = new double[grado + 1];
		for(int i = 0; i < coeficientes.length; i++ ) {
			coeficientes[i] = calculoCombinatoria(grado, i);
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
	
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

}
