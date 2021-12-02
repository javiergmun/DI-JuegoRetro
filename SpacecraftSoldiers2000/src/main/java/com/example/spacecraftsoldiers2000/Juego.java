package com.example.spacecraftsoldiers2000;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

//vista
public class Juego extends BorderPane {

    private final JuegoController controlador;
    private StackPane pista;
    private Rectangle cielo;
    private Rectangle puntero;
    private Rectangle paredIzquierda;
    private Rectangle paredDerecha;
    private Rectangle paredSuperior;
    private Rectangle paredInferior;
    private Rectangle nave1;
    private Rectangle misil;
    //Image fondo = new Image (getClass().getResourceAsStream("src/Images/fondo.png"));
   //ImageView imageView = new ImageView(fondo);

    public Juego(){
        //instanciar
        this.paredIzquierda= new Rectangle();
        this.cielo= new Rectangle();
        this.puntero= new Rectangle();
        this.paredDerecha= new Rectangle();
        this.paredSuperior= new Rectangle();
        this.paredInferior= new Rectangle();
        this.nave1= new Rectangle();
        this.misil = new Rectangle();
        this.pista= new StackPane();
        this.controlador = new JuegoController(pista,puntero,cielo, paredIzquierda, paredDerecha,
                paredSuperior, paredInferior, nave1,misil);


        // inicializar, dar color y tamaño
        cielo.setFill(new ImagePattern(new Image("nubes.png")));
        cielo.heightProperty().bind(pista.heightProperty());
        cielo.widthProperty().bind(pista.widthProperty());

        puntero.setFill(new ImagePattern(new Image("puntero.png")));
        puntero.heightProperty().bind(pista.heightProperty().divide(15));
        puntero.widthProperty().bind(pista.heightProperty().divide(15));

        paredIzquierda.setFill(Color.RED);
        paredIzquierda.heightProperty().bind(pista.heightProperty());
        paredIzquierda.widthProperty().bind(pista.widthProperty().divide(20));

        paredDerecha.setFill(Color.RED);
        paredDerecha.heightProperty().bind(pista.heightProperty());
        paredDerecha.widthProperty().bind(pista.widthProperty().divide(20));

        paredInferior.setFill(Color.RED);
        paredInferior.heightProperty().bind(pista.heightProperty().divide(2000));
        paredInferior.widthProperty().bind(pista.widthProperty());

        paredSuperior.setFill(Color.RED);
        paredSuperior.heightProperty().bind(pista.heightProperty().divide(2000));
        paredSuperior.widthProperty().bind(pista.widthProperty());

        nave1.setFill(new ImagePattern(new Image("caza.png")));
        nave1.heightProperty().bind(pista.heightProperty().divide(11));
        nave1.widthProperty().bind(pista.heightProperty().divide(15));

        //misil.setFill(new ImagePattern(new Image("misil.png")));
       // misil.heightProperty().bind(pista.heightProperty().divide(11));
        //misil.widthProperty().bind(pista.heightProperty().divide(15));

        //colocar
        pista.getChildren().addAll(cielo,puntero,paredIzquierda,paredDerecha,paredInferior,paredSuperior,nave1,misil);
        pista.setAlignment(paredIzquierda, Pos.CENTER_LEFT);
        pista.setAlignment(paredDerecha, Pos.CENTER_RIGHT);
        pista.setAlignment(paredInferior, Pos.BOTTOM_CENTER);
        pista.setAlignment(paredSuperior, Pos.TOP_CENTER);
        pista.setAlignment(nave1, Pos.CENTER);
        pista.setAlignment(cielo, Pos.CENTER);
        pista.setAlignment(puntero, Pos.CENTER);
        pista.setAlignment(misil, Pos.CENTER);
        //pista.getChildren().add(imageView);
        this.setCenter(pista);
        
        //INSTANCIO CONTROLADOR
        
    }

}
