package structure;

import java.util.ArrayList;

public class Processor {

    private int id;
    private int uzycie;
    private int UzycieLicznik;
    private int licznikPrzeniesien;
    private ArrayList<Process> procesy;

    public Processor(int id) {
        this.id = id;
        this.uzycie = 0;
        this.UzycieLicznik = 0;
        this.licznikPrzeniesien = 0;
        this.procesy = new ArrayList<>();
    }

    public Processor(Processor processor) {
        this.id = processor.id;
        this.uzycie = 0;
        this.UzycieLicznik = 0;
        this.licznikPrzeniesien = 0;
        this.procesy = new ArrayList<>();
    }

    public int getUzycieLicznik() {
        return UzycieLicznik;
    }

    public void setUzycieLicznik(int UzycieLicznik) {
        this.UzycieLicznik = UzycieLicznik;
    }

    public int getlicznikPrzeniesien() {
        return licznikPrzeniesien;
    }

    public void setlicznikPrzeniesien(int movesCounter) {
        this.licznikPrzeniesien = movesCounter;
    }

    public ArrayList<Process> getProcesy() {
        return procesy;
    }

    public void setProcesses(ArrayList<Process> procesy) {
        this.procesy = procesy;
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

    public void setUzycie(int usage) {
        this.uzycie = usage;
    }

    public void zwiekszLicznikUzycia() {
        this.UzycieLicznik++;
    }

    public void zwiekszLicznikPrzeniesien() {
        this.licznikPrzeniesien++;
    }

    public void tick() {
        if (procesy.isEmpty()) 
        	return;

        for (int i = 0; i < procesy.size(); i++) {
            Process process = procesy.get(i);
            process.setczasTrwania(process.getczasTrwania() - 1);
            if (process.getczasTrwania() == 0) {
            	uzycie -= process.getUzycie();
            	procesy.remove(process); // i--
            }
        }
    }
    
}
