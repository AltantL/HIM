package vue;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.Date;
import modele.DateCalendrier;


public class VBoxRoot extends VBox {

    public VBoxRoot() {
//        DateCalendrier aujourd = new DateCalendrier();
//        Label labelAujourdHui = new Label(aujourd.toString());
//        this.getChildren().add(labelAujourdHui);
//
//        Label labelLendemain = new Label(aujourd.dateDuLendemain().toString());
//        this.getChildren().add(labelLendemain);

        VBox boiteVBox = new VBox();
        CalendrierDuMois date = new CalendrierDuMois(02, 2020);
        Label dateLabel = new Label("Mois: " + date.getMois() + " Annee: " + date.getAnnee());

        for (DateCalendrier dateCalendrier: date.getDates()){
            Label dateLabel2 = new Label(date.toString());
            boiteVBox.getChildren().add(dateLabel2);
        }

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setContent(boiteVBox);

        this.getChildren().addAll(dateLabel, boiteVBox);

    }


}
