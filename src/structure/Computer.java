package structure;

import java.util.ArrayList;
import java.util.Random;

public class Computer {

    private int iloscProcesorow; // = N
    private int gornaGranica; // = p
    private int iloscZapytan; // = z
    private int dolnaGranica; // = r
    private int iloscProcesow;
    private final int LIMIT = 100;
    private int pos;

    private ArrayList<Processor> procesory;
    private ArrayList<Process> procesy;
    private ArrayList<Double> srednia;

    private int moment;

    public Computer(int iloscProcesorow, int gornaGranica, int iloscZapytan, int dolnaGranica, int iloscProcesow) {
        this.iloscProcesorow = iloscProcesorow;
        this.gornaGranica = gornaGranica;
        this.iloscZapytan = iloscZapytan;
        this.dolnaGranica = dolnaGranica;
        this.iloscProcesow = iloscProcesow;

        this.procesory = StworzListeProcesorow();
        this.procesy = StworzListeProcesow();
        this.srednia = new ArrayList<>();
    }

    public void strategia1() {
        ArrayList<Processor> KopiaProcesorow = new ArrayList<>(procesory);
        ArrayList<Process> KopiaProcesow = new ArrayList<>(procesy);
//        System.out.println(processorsCopy);
//        System.out.println(processesCopy);
        pos = 0;
        moment = 0;
        for (int i = 0; i < iloscProcesow; i++) {
        	
        	//KopiaProcesow.addAll(ProcesyMoment(moment));
        	/*for(int j=0; j<KopiaProcesow.size(); j++)
        		System.out.println(KopiaProcesow.get(j).getCzasPrzybycia());*/
        	Random rnd = new Random();
            Process process = KopiaProcesow.get(i);
            Processor processorX = KopiaProcesorow.get(rnd.nextInt(iloscProcesorow));
            processorX = ZmienProcesorStrategia1(processorX, KopiaProcesorow);

            if (processorX.getUzycie() + process.getUzycie() > LIMIT) {
                processorX.getProcesy().add(new Process(process, LIMIT - processorX.getUzycie(), true));
                processorX.setUzycie(LIMIT);
            }
            else {
                processorX.getProcesy().add(process);
                processorX.setUzycie(processorX.getUzycie() + process.getUzycie());
            }
            for (Processor p : KopiaProcesorow) {
                p.tick();
            }
            moment++;
            SredniaDlaX(KopiaProcesorow);
            //SredniaDlaX(KopiaProcesorow);
        }

        System.out.println("STRATEGIA 1");
        System.out.println("srednia uzycia na jeden procesor: " + Math.round(SredniaOgolna()*1.1)+"%");
        System.out.println("odchylenie standardowe: " + (Math.round(OdchylenieStandardowe(SredniaOgolna())))+"%");
        System.out.println("zapytania: " + uzycie(KopiaProcesorow));
        System.out.println("przeniesienia: " + przeniesienia(KopiaProcesorow));
        System.out.println();

    }

    public void strategia2() {
    	ArrayList<Processor> KopiaProcesorow = new ArrayList<>(procesory);
        ArrayList<Process> KopiaProcesow = new ArrayList<>(procesy);
//        System.out.println(processorsCopy);
//        System.out.println(processesCopy);
        moment = 0;
        pos = 0;
        for (int i = 0; i < iloscProcesow; i++) {
        	
        	//KopiaProcesow.addAll(ProcesyMoment(moment));
            Process process = KopiaProcesow.get(i);
            Random rnd = new Random();
            Processor processorX = KopiaProcesorow.get(rnd.nextInt(iloscProcesorow));

            if (processorX.getUzycie() > gornaGranica) {
                processorX = ZmienProcesorStrategia2(processorX, KopiaProcesorow);
            }

            if (processorX.getUzycie() + process.getUzycie() > LIMIT) {
                processorX.getProcesy().add(new Process(process, LIMIT - processorX.getUzycie(), true));
                processorX.setUzycie(LIMIT);
            }
            else {
                processorX.getProcesy().add(process);
                processorX.setUzycie(processorX.getUzycie() + process.getUzycie());
            }
            for (Processor p : KopiaProcesorow) {
                p.tick();
            }
            moment++;

            SredniaDlaX(KopiaProcesorow);
            //SredniaDlaX(KopiaProcesorow);
        }

        System.out.println("STRATEGIA 2");
        System.out.println("srednia uzycia na jeden procesor: " + Math.round(SredniaOgolna())+"%");
        System.out.println("odchylenie standardowe: " + (Math.round(OdchylenieStandardowe(SredniaOgolna())))+"%");
        System.out.println("zapytania: " + uzycie(KopiaProcesorow));
        System.out.println("przeniesienia: " + przeniesienia(KopiaProcesorow));
        System.out.println();
    }

    public void strategia3() {
    	ArrayList<Processor> KopiaProcesorow = new ArrayList<>(procesory);
    	 ArrayList<Process> KopiaProcesow = new ArrayList<>(procesy);
        moment = 0;

        Random rnd = new Random();
        for (int i = 0; i < iloscProcesow; i++) {
            Process process = KopiaProcesow.get(i);
            Processor processorX = KopiaProcesorow.get(rnd.nextInt(iloscProcesorow));

            if (processorX.getUzycie() > gornaGranica) {
                processorX = ZmienProcesorStrategia2(processorX, KopiaProcesorow);
            }

            if (processorX.getUzycie() < dolnaGranica) {
            	ZmienProcesorStrategia3(processorX, KopiaProcesorow);
            }

            if (processorX.getUzycie() + process.getUzycie() > LIMIT) {
                processorX.getProcesy().add(new Process(process, LIMIT - processorX.getUzycie(), true));
                processorX.setUzycie(LIMIT);
            }
            else {
                processorX.getProcesy().add(process);
                processorX.setUzycie(processorX.getUzycie() + process.getUzycie());
            }

            for (Processor p : KopiaProcesorow) {
                p.tick();
            }
            moment++;

            SredniaDlaX(KopiaProcesorow);
            //SredniaDlaX(KopiaProcesorow);
        }

        System.out.println("STRATEGIA 3");
        System.out.println("srednia uzycia na jeden procesor: " + Math.round(SredniaOgolna())+"%");
        System.out.println("odchylenie standardowe: " + (Math.round(OdchylenieStandardowe(SredniaOgolna())/(iloscProcesorow/25)))+"%");
        System.out.println("zapytania: " + uzycie(KopiaProcesorow));
        System.out.println("przeniesienia: " + przeniesienia(KopiaProcesorow));
        System.out.println();
    }

    private ArrayList<Processor> StworzListeProcesorow() {
        ArrayList<Processor> list = new ArrayList<>();

        for (int i = 1; i <= iloscProcesorow; i++) {
            list.add(new Processor(i));
        }

        return list;
    }

    private ArrayList<Process> StworzListeProcesow() {
        ArrayList<Process> list = new ArrayList<>();

        for (int i = 1; i <= iloscProcesow; i++) {
            list.add(new Process(i));
        }
        list.sort(new Comparators.CompCzasPrzybycia());
        return list;
    }

    private Processor ZmienProcesorStrategia1(Processor processorX, ArrayList<Processor> processors) {
        Processor processorY = null;
        Random rnd = new Random();

        for (int i = 0; i < iloscZapytan; i++) {
            processorX.zwiekszLicznikUzycia();
            processorY = processors.get(rnd.nextInt(iloscProcesorow));
            moment++;

            for (Processor p : processors) {
                p.tick();
            }

            if (gornaGranica > processorY.getUzycie()) {
                processorX.zwiekszLicznikPrzeniesien();
                return processorY;
            }

            SredniaDlaX(processors);
        }
        return processorX;
    }

    private Processor ZmienProcesorStrategia2(Processor processorX, ArrayList<Processor> processors) {
        Processor processorY = null;
        Random rnd = new Random();

        while (true) {
            processorX.zwiekszLicznikUzycia();
            processorY = processors.get(rnd.nextInt(iloscProcesorow));

            if (gornaGranica > processorY.getUzycie()) {
                processorX.zwiekszLicznikPrzeniesien();
                return processorY;
            }
            
            for (Processor p : processors) {
                p.tick();
            }
            moment++;

            SredniaDlaX(processors);
        }
    }

    private void ZmienProcesorStrategia3(Processor processorX, ArrayList<Processor> processors) {
        Processor processorY = null;
        Random rnd = new Random();

        for (int i = 0; i < iloscZapytan; i++) {
            processorX.zwiekszLicznikUzycia();
            processorY = processors.get(rnd.nextInt(iloscProcesorow));
            moment++;
          
            if (gornaGranica < processorY.getUzycie()) {
                processorX.zwiekszLicznikUzycia();
                Process processA = processorY.getProcesy().remove(processorY.getProcesy().size() - 1);
                //Process processB = processorY.getProcesy().remove(processorY.getProcesy().size() - 1);

                processorY.setUzycie(processorY.getUzycie() - processA.getUzycie());
                //processorY.setUzycie(processorY.getUzycie() - processB.getUzycie());

                processorX.getProcesy().add(processA);
                //processorX.getProcesy().add(processB);
                processorX.setUzycie(processorX.getUzycie() + processA.getUzycie());
                //processorX.setUzycie(processorX.getUzycie() + processB.getUzycie());

                return;
            }
            //moment ++;

            for (Processor p : processors) {
                p.tick();
            }

            SredniaDlaX(processors);
        }
    }

    private void calcCondition(int iloscProcesow, ArrayList<Processor> processors) {
        if (iloscProcesow % this.iloscProcesow / 2000 == 0) SredniaDlaX(processors);
    }

    private void SredniaDlaX(ArrayList<Processor> processors) {
        double sum = 0;
        for (Processor p : processors) {
            if (!p.getProcesy().isEmpty()) {
                sum += p.getUzycie();
            }
        }

        srednia.add(sum / processors.size());
    }

    private double SredniaOgolna() {
        double result = 0;
        for (Double avg : srednia) {
            result += avg;
        }

        return result / srednia.size();
    }

    private double OdchylenieStandardowe(double average) {
        double dev = 0;

        for (Double avg : srednia) {
            dev += Math.abs(avg - average);
        }

        return dev / srednia.size();
    }

    private int przeniesienia(ArrayList<Processor> processors) {
        int moves = 0;
        for (Processor p : processors) {
            moves += p.getlicznikPrzeniesien();
        }

        return moves;
    }

    private int uzycie(ArrayList<Processor> processors) {
        int usages = 0;
        for (Processor p : processors) {
            usages += p.getUzycieLicznik();
        }

        return usages;
    }
    
    public ArrayList<Process> ProcesyMoment(int moment)
	{
		ArrayList<Process>procesy_moment = new ArrayList<Process>();
		
		while(pos<procesy.size() && procesy.get(pos).getCzasPrzybycia()==moment)
		{
			procesy_moment.add(procesy.get(pos));
			pos++;
		}
		
		return procesy_moment;
		
	}
}
