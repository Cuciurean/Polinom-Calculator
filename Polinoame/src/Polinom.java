
import java.util.ArrayList;


public class Polinom  {
	
	private int grade;
	String polis;
	private ArrayList<Monom> pol = new ArrayList<>(200);;
    
	public Polinom(String polis) {
        this.polis = polis;
        grade=0;
        Citire(polis);
    } 
	public ArrayList<Monom> getpol() {
        return pol;
    }

    public void setpl(ArrayList<Monom> pol) {
        this.pol = pol;
    }

    public String toString() {
		String polii = "";
		for (int i = 0; i<pol.size(); i++) {
			if (pol.get(i).getCoef()>0 && i>0)
			{
				polii = polii + "+";
			}	
				polii = polii + (String.valueOf(pol.get(i).getCoef()));
				polii = polii + ("x^");
				polii = polii + (String.valueOf(pol.get(i).getP()));
		}
		return polii;

	}
	


	public void Citire(String poli) {
		
		pol = new ArrayList<Monom>();
		String coef1 = new String();
		String pow1 = new String();
		String string = poli.replace("-", "+-");
		String[] v = string.split("\\+");
		
		for (String j : v) {
			if ((!j.equals("")))  
			{
				String[] coef = j.split("x");
				if (coef[0].equals("-") || coef[0].equals(""))
					{
					coef1 = coef[0] + "1";
					}
				else {
					coef1 = coef[0];
				}
				String[] pow = j.split("\\^");
				if (pow.length > 1) {
					pow1 = pow[1];	
				}
				else if (pow.length <= 1) {
					pow1 = "0";
				}
				Monom mon = new Monom(Double.parseDouble(coef1), Integer.parseInt(pow1));
				pol.add(mon);

			}
			}
		}
	
	public void adaugare(double coef, int pow) 
	{
		Monom mon = new Monom(coef, pow);
		pol.add(mon);
		if (coef != 0 && pow > grade)
			grade = pow;
	}


	public Polinom Adunare(Polinom a) {
		int i=0, j=0;
		double c;
		Polinom poll = new Polinom("");
		ArrayList<Monom> rezultat = new ArrayList<Monom>();
		while(i<this.pol.size() && j<a.pol.size())
		{
			if(this.pol.get(i).getP() == a.pol.get(j).getP())
			{
				c=this.pol.get(i).getCoef() + a.pol.get(j).getCoef();
				Monom mon = new Monom(c,this.pol.get(i).getP());
				
				rezultat.add(mon);
				i++;
				j++;
			}else if(this.pol.get(i).getP() > a.pol.get(j).getP())
			{
				Monom mon = new Monom(this.pol.get(i).getCoef(),this.pol.get(i).getP());
				rezultat.add(mon);
				i++;
			}else if(this.pol.get(i).getP() < a.pol.get(j).getP())
			{
				Monom mon = new Monom(a.pol.get(j).getCoef(),a.pol.get(j).getP());
				rezultat.add(mon);
				j++;
			}
		}
		while(j<this.pol.size())
		{
			Monom mon = new Monom(a.pol.get(j).getCoef(),a.pol.get(j).getP());
			rezultat.add(mon);
			j++;
		}
		while(i<this.pol.size())
		{
			Monom mon = new Monom(this.pol.get(i).getCoef(),this.pol.get(i).getP());
			rezultat.add(mon);
			i++;
		}
		poll.pol=rezultat;
		return poll;
	}
	
	public Polinom Scadere(Polinom b) {
		int i=0, j=0;
		double c;
		Polinom poll = new Polinom("");
		ArrayList<Monom> rezultat = new ArrayList<Monom>();
		while(i<this.pol.size() && j<b.pol.size())
		{
			if(this.pol.get(i).getP() == b.pol.get(j).getP())
			{
				c=this.pol.get(i).getCoef() - b.pol.get(j).getCoef();
				Monom mon = new Monom(c,this.pol.get(i).getP());
				
				rezultat.add(mon);
				i++;
				j++;
			}else if(this.pol.get(i).getP() > b.pol.get(j).getP())
			{
				Monom mon = new Monom(this.pol.get(i).getCoef(),this.pol.get(i).getP());
				rezultat.add(mon);
				i++;
			}else if(this.pol.get(i).getP() < b.pol.get(j).getP())
			{
				Monom mon = new Monom(b.pol.get(j).getCoef(),b.pol.get(j).getP());
				rezultat.add(mon);
				j++;
			}
		}
		while(j<this.pol.size())
		{
			Monom mon = new Monom(b.pol.get(j).getCoef(),b.pol.get(j).getP());
			rezultat.add(mon);
			j++;
		}
		while(i<this.pol.size())
		{
			Monom mon = new Monom(this.pol.get(i).getCoef(),this.pol.get(i).getP());
			rezultat.add(mon);
			i++;
		}
		poll.pol=rezultat;
		return poll;
	}
	
	public Polinom Integrare() 
	{
		Polinom rezultat = new Polinom("");

		for (Monom mon : this.pol) {

			if (mon.getP() != 0)
				rezultat.adaugare(mon.getCoef() / mon.getP(), mon.getP() + 1);
			else
				rezultat.adaugare(mon.getCoef(), (int) 1);

		}
		return rezultat;
	}
	
	public Polinom Derivare() 
	{
		Polinom rezultat = new Polinom("");

		for (Monom mon : this.pol) {
			if (mon.getP() != 0) {
				rezultat.adaugare(mon.getCoef() * mon.getP(), mon.getP() - 1);
			} else {
				rezultat.adaugare((double) 0, (int) 0);
			}
		}
		return rezultat;
	}
	
	public Polinom Inmultire(Polinom a) {
		Polinom rezultat = new Polinom("");
		boolean gasit;
		for (Monom mon1 : this.pol) {
			for (Monom mon2 : a.pol) {
				gasit = false;
				for (Monom mon3 : rezultat.pol) {
					if ((mon1.getP() + mon2.getP()) == mon3.getP()) 
					{
						mon3.set(mon3.getCoef() + mon2.getCoef() * mon1.getCoef(),
								mon1.getP() + mon2.getP());
						gasit = true;
					}
				}
				if (!gasit) 
				{
					rezultat.adaugare(mon2.getCoef() * mon1.getCoef(), mon1.getP() + mon2.getP());
				}
			}
		}
		return rezultat;
	}


	
}
