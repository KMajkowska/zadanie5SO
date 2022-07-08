package structure;

import java.util.*;

public class Process {

    private int id;
    private int uzycie;
    private int czasTrwania;
    private int czasPrzybycia;
    private int pos=0;

    public Process(int id) {
        this.id = id;
        this.uzycie = randomUzycie();
        this.czasTrwania = randomCzasTrwania();
        this.czasPrzybycia = randomizeCzasPrzybycia();
    }

    public Process(Process process, boolean prolong) {
        this.id = process.id;
        this.uzycie = process.uzycie;
        if (prolong) {
            this.czasTrwania = process.czasTrwania;
        }
        else {
            this.czasTrwania = process.czasTrwania;
        }
    }

    public Process(Process process, int usage, boolean prolong) {
        this.id = process.id;
        this.uzycie = usage;
        if (prolong) {
            this.czasTrwania = 3 * process.czasTrwania;
        }
        else {
            this.czasTrwania = process.czasTrwania;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUzycie() {
        return uzycie;
    }

    public void setUzycie(int uzycie) {
        this.uzycie = uzycie;
    }

    public int getczasTrwania() {
        return czasTrwania;
    }
        
    public int getCzasPrzybycia() {
		return czasPrzybycia;
	}

	public void setCzasPrzybycia(int czasPrzybycia) {
		this.czasPrzybycia = czasPrzybycia;
	}

	public String toString()
    {
    	return "czas: " + czasPrzybycia;
    }

    public void setczasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    private int randomUzycie() {
        Random rnd = new Random();
        return rnd.nextInt(80);
    }

    private int randomCzasTrwania() {
        Random rnd = new Random();
        return rnd.nextInt(300) + 100;
    }
    
    private int randomizeCzasPrzybycia(){
        Random rnd = new Random();
        return Math.abs(rnd.nextInt(300));
    }
    
}
