import java.util.Random;
import java.util.Scanner;
public class DadiMenu {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int scelta = 0;
        String[] opzioni = {"=== Gioco Dadi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Exit "};
        Random faccia = new Random();



        int valoreG1, valoreG2, valoreRobot;
        int punteggioG1 = 0, punteggioG2 = 0;

        int valoreFaccia;


        scelta = Menu(opzioni, tastiera);

        switch (scelta) {
            case 1: {
                valoreG1 = faccia.nextInt(6) + 1;
                valoreG2 = faccia.nextInt(6) + 1;
                System.out.println("Giocatore 1");
                System.out.println("\nGiocatore 2");
                determinaVincitore(valoreG1, valoreG2);
                break;
            }
            case 2: {
                valoreG1 = faccia.nextInt(6) + 1;
                valoreRobot = faccia.nextInt(6) + 1;

                System.out.println("Giocatore 1");
                System.out.println("\nGiocatore 2");
                determina(valoreG1, valoreRobot);
                break;

            }
            case 3: {
                System.out.println("GIOCO FINITO");
                break;
            }
        }


    }


    private static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));
        return scelta;

    }

    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void determinaVincitore(int valoreG1, int valoreG2) {
        System.out.println("\nPunteggio finale:");

        if (valoreG1 > valoreG2) {
            System.out.println("Vince Giocatore 1 con " + valoreG1 + " punti!");
        } else if (valoreG1 < valoreG2) {
            System.out.println("Vince Giocatore 2 con " + valoreG2 + " punti!");
        } else {
            System.out.println("La partita è finita in parità!");
        }
    }


    private static void determina(int valoreG1, int valoreRobot) {
        System.out.println("\nPunteggio finale:");

        if (valoreG1 > valoreRobot) {
            System.out.println("Vince Giocatore 1 con " + valoreG1 + " punti!");
        } else if (valoreG1 < valoreRobot) {
            System.out.println("Vince il robot con " + valoreRobot + " punti!");
        } else {
            System.out.println("La partita è finita in parità!");
        }
    }




}