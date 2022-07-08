package packagemain;

import structure.Computer;

public class Main {

    public static void main(String[] args) {

    	int ilosc_Procesorow = 50;
    	int gorna_granica = 80;
    	int ileProcesorowSprawdzic = 5;
    	int dolna_granica = 20;
    	int iloscProcesow = 20000;
        System.out.println("========== 50 PROCESORÓW ==========");

        Computer comp1 = new Computer(ilosc_Procesorow, gorna_granica, ileProcesorowSprawdzic, dolna_granica, iloscProcesow);

        comp1.strategia1();

        Computer comp2 = new Computer(ilosc_Procesorow, gorna_granica, ileProcesorowSprawdzic, dolna_granica, iloscProcesow);

        comp2.strategia2();

        Computer comp3 = new Computer(ilosc_Procesorow, gorna_granica, ileProcesorowSprawdzic, dolna_granica, iloscProcesow);

        comp3.strategia3();
        
        ilosc_Procesorow = 100;

        System.out.println("========== 100 PROCESORÓW ==========");

        Computer comp4 = new Computer(ilosc_Procesorow, gorna_granica, ileProcesorowSprawdzic, dolna_granica, iloscProcesow);

        comp4.strategia1();

        Computer comp5 = new Computer(ilosc_Procesorow, gorna_granica, ileProcesorowSprawdzic, dolna_granica, iloscProcesow);

        comp5.strategia2();

        Computer comp6 = new Computer(ilosc_Procesorow, gorna_granica, ileProcesorowSprawdzic, dolna_granica, iloscProcesow);

        comp6.strategia3();
        
    }
}
