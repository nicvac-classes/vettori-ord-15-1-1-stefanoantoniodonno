//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().

    public static void SortingAuto(int[] V, int N, String[] R){
        int i, j, t;
        String ts;
        boolean scambio = true;

        i = 0;
        while(i < N && scambio == true){
            j = 0;
            scambio = false;
            while(j < (N-1)-i){
                if(V[j] > V[j+1]){
                    t = V[j];
                    V[j] = V[j+1];
                    V[j+1] = t;
                    ts = R[j];
                    R[j] = R[j+1];
                    R[j+1] = ts;
                    scambio = true;
                }
                j++;
            }
            i++;
        }
    }

    public static int RicercaSequenziale(int[] V, String[] R, int N, int numero){
        int controlli, i;
        boolean trovato = false;

        i = 0;
        controlli = 0;
        while(i < N && !trovato){
            controlli ++;
            if(V[i] == numero){
                trovato = true;
            }
            i++;
        }
        
        System.out.println("il pilota con la posizione " + numero + " è: " + R[i]);
        
        return controlli;
    }

    public static int RicercaBinaria(int[] V, String[] R, int N, int numero){
        int controlli, inizio, fine, medio = 0;
        boolean trovato = false;
        controlli = 0;
        inizio = 0;
        fine = N - 1;
        while(inizio <= fine && !trovato){
            medio = inizio + (fine - inizio) / 2;
            controlli ++;
            if(V[medio] == numero){
                trovato = true;
            }else if(V[medio] < numero){
                inizio = medio + 1;
            }else{
                fine = medio - 1;
            }
        }

        System.out.println("il pilota con la posizione " + numero + " è: " + R[medio]);
        
        return controlli;
    }

    public static void main(String args[]){
       Scanner in = new Scanner(System.in);
       Random rand = new Random();

       int N, i;
       
        System.out.print("Inserire il numero di macchine che hanno corso a monza: ");
        N = Integer.parseInt(in.nextLine());

        String[] nomi = new String[N];
        int[] posizioni = new int[N];

        for(i = 0; i < N; ++i){
            System.out.print("Inserire il nome del " + (i+1) + " pilota: ");
            nomi[i] = in.nextLine();
            posizioni[i] = rand.nextInt(N) + 1;
        }

        SortingAuto(posizioni, N, nomi);

        for(i = 0; i < N; i++){
            System.out.println("Con la posizione: " + posizioni[i] + " abbiamo: " + nomi[i]);
        }

        int posizione, controlli;

        System.out.print("Inserire la posizione del pilota: ");
        posizione = in.nextInt();
        controlli = RicercaSequenziale(posizioni, nomi, N, posizione);
        System.out.println("Numero di controlli nella ricerca sequenziale: " + controlli);

        System.out.print("Inserire la posizione del pilota: ");
        posizione = in.nextInt();
        controlli = RicercaBinaria(posizioni, nomi, N, posizione);
        System.out.println("Numero di controlli nella ricerca binaria: " + controlli);

    }
}