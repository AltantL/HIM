package modele;

import constantes.ConstantesCalendrier;

import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable<Date> {
    private int chJourSemaine;

    public DateCalendrier() {
        super(0);

        Calendar today = Calendar.getInstance();

        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH)+1;
        chJour = today.get(Calendar.DAY_OF_MONTH);


        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1)
            chJourSemaine = 7;
        else
            chJourSemaine = dayOfWeek - 1;
    }


    public DateCalendrier(int parJour, int parMois, int parAnnee) {
        super(parJour, parMois, parAnnee);
        // chjourSemaine ??
        Calendar date = Calendar.getInstance();
        date.set(parAnnee, parMois-1,parJour);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1)
            chJourSemaine = 7;
        else
            chJourSemaine = dayOfWeek-1;
    }

    public DateCalendrier dateDuLendemain() {
        Date date = super.dateDuLendemain();

        return new DateCalendrier(date.chJour, date.chMois, date.chAnnee);
    }

    public DateCalendrier dateDeLaVeille() {
        Date date = super.dateDeLaVeille();

        return new DateCalendrier(date.chJour, date.chMois, date.chAnnee);
    }

    public interface Comparable {
        public int compareTo(Object object);
    }

    /**
     * recuperer le num de cette semaine
     * @return int, un numero de semaine de l'obet à plan this
     */
    public int getNumSemaine() {
        Calendar date = Calendar.getInstance();
        date.set(chAnnee, chMois-1,chJour);
        return date.get(Calendar.WEEK_OF_YEAR);
    }

    public int getJourSemaine() {
        return chJourSemaine;
    }

    public int getMois() { return chMois; }



    public String toString() {
        return JOURS_SEMAINE[chJourSemaine-1] + " " + chJour + " " + MOIS[chMois - 1] + " " + chAnnee;
    }

}
