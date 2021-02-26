

public class Monom {
    private double coef;
    private int pow;

    public Monom(double coef, int pow) {
        this.coef = coef;
        this.pow= pow;
    }

	public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getP() {
        return pow;
    }

    public void setP(int pow) {
        this.pow = pow;
    }
    
    public void set(double coef, int pow)
    {
    	this.coef = coef;
        this.pow= pow;
    }



}
