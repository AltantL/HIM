package modele;

import java.util.Calendar;
import java.util.Scanner;

public class Date{

    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date(int parJour, int parMois, int parAnnee){
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }


    public Date(int parAnnee){
        chJour = 1;
        chMois = 1;
        chAnnee = parAnnee;
    }


    public static boolean estBissextile(int parAnnee){
        if (parAnnee % 4 == 0 && parAnnee % 100 != 0 || parAnnee % 400 == 0)
            return true;
        return false;
    }

    public static int dernierJourMois(int parMois, int parAnnee){
        switch(parMois){
            case 2: if (estBissextile(parAnnee))
                return 29;
                return 28;
            case 4 : case 6 : case 9 : case 11 : return 30;

            default : return 31;
        }
    }

    public boolean estValide(){
        if (chAnnee < 1583)
            return false;
        if (chMois < 1 || chMois > 12)
            return false;
        if (chJour < 1 || chJour > dernierJourMois(chMois, chAnnee) )
            return false;
        return true;
    }

    public static Date lireDate() {
        System.out.println("Entrez un jour, un mois, une année:");
        Scanner scanner = new Scanner(System.in);
        int jour = scanner.nextInt();
        int mois = scanner.nextInt();
        int annee = scanner.nextInt();
        return new Date(jour, mois, annee);
    }


    /**
     * la méthode compareTo() retourne positif si la date passé en paramètre est après la date objet appelant
     * sinon si la date passée en paramètre est avant la date objet appelant, retourne négatif
     * sinon retourne 0 si les deux dates sont égaux
     * @param parDate
     * @return int
     */
    public int compareTo(Date parDate){
        if (this.chAnnee > parDate.chAnnee)
            return 1;
        if (this.chAnnee < parDate.chAnnee)
            return -1;
        if (this.chMois > parDate.chMois)
            return 1;
        if (this.chMois < parDate.chMois)
            return -1;
        if (this.chJour > parDate.chJour)
            return 1;
        if (this.chJour < parDate.chJour)
            return -1;
        return 0;
    }


    /**
     * La méthode dateDuLendemain() renvoie la date du lendemain de l'objet appelant
     * @return Date
     */
    public Date dateDuLendemain(){
        if (chJour == Date.dernierJourMois(chMois, chAnnee)){
            if (chMois == 12){
                Date leLendemain = new Date(1,1,chAnnee+1);
                return leLendemain;
            }

            Date leLendemain = new Date(1,chMois+1, chAnnee);
            return leLendemain;

        }
        Date leLendemain = new Date(chJour+1, chMois, chAnnee);
        return leLendemain;
    }


    /**
     * Le méthode dateDeLaVeille() renvoie la date de la veille de l'objet appelant(la date qu'on a mis)
     * @return Date
     */
    public Date dateDeLaVeille(){
        if (chJour == 1) {
            if (chMois == 1){
                Date veille = new Date(Date.dernierJourMois(chMois-1, chAnnee-1), 12, chAnnee-1);
                return veille;
            }
            Date veille = new Date(Date.dernierJourMois(chMois-1, chAnnee), chMois-1, chAnnee);
            return veille;
        }
        Date veille = new Date(chJour-1, chMois, chAnnee);
        return veille;
    }





    public String toString(){
        return  chJour + "-" + chMois + "-" + chAnnee ;
    }
}
