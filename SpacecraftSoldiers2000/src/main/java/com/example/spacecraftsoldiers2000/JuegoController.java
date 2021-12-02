package com.example.spacecraftsoldiers2000;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class JuegoController {


    private StackPane pista;
    private Rectangle cielo;
    private Rectangle puntero;
    private boolean start;
    private Rectangle paredIzquierda;
    private Rectangle paredDerecha;
    private Rectangle paredSuperior;
    private Rectangle paredInferior;
    private Rectangle nave1;
    private Rectangle misil;
    private double velocidad;
    private Timeline animacion;
    private double desplazamientoX1;
    private double desplazamientoY1;


    public JuegoController(StackPane pista,Rectangle puntero, Rectangle cielo, Rectangle paredIzquierda, Rectangle paredDerecha,
                           Rectangle paredSuperior, Rectangle paredInferior, Rectangle nave1, Rectangle misil) {
        this.pista = pista;
        this.puntero= puntero;
        this.cielo = cielo;
        this.paredIzquierda = paredIzquierda;
        this.paredDerecha = paredDerecha;
        this.paredSuperior = paredSuperior;
        this.paredInferior = paredInferior;
        this.nave1 = nave1;
        this.misil = misil;
        nave1.setTranslateX(0);
        nave1.setTranslateY(200);
        this.velocidad= 4;


        inicializarJuego();
        inicializarControles1();


    }
    private void inicializarJuego(){
        this.animacion= new Timeline(new KeyFrame(Duration.millis(17),t->{  //le digo TO-DO lo que tiene que hacer en cada frame de la app
            detectarColision1();
            moverNave1();
            moverCielo();
            moverPuntero();
            moverDisparo();
        }));
        animacion.setCycleCount(animacion.INDEFINITE);
    }

    private void inicializarControles1() {
        pista.setOnKeyPressed(g->{
            switch (g.getCode()){

                case SPACE:
                    animacion.play();
                    paredIzquierda.setFill(Color.DARKBLUE);
                    paredDerecha.setFill(Color.DARKBLUE);
                    paredSuperior.setFill(Color.DARKBLUE);
                    paredInferior.setFill(Color.DARKBLUE);

                break;
                case A:
                    desplazamientoX1= -1*velocidad;

                    break;
                case W:
                    desplazamientoY1=-1*velocidad;
                    break;
                case D:
                    desplazamientoX1 = 1*velocidad;

                    break;
                case S:

                    desplazamientoY1 = 1*velocidad;
                    break;
                case E:
                    disparar();
            }
        });
        pista.setOnKeyReleased(g->{
            switch (g.getCode()){

                case A:
                    desplazamientoX1= 0;
                    break;
                case D:
                    desplazamientoX1 = 0;
                    break;
                case S:
                    desplazamientoY1=0;
                case W:
                    desplazamientoY1=0;
            }
        });
        pista.setFocusTraversable(true);
    }

    private void moverNave1() {
            nave1.setTranslateX(nave1.getTranslateX() + desplazamientoX1);

        }
    private void moverPuntero() {
        puntero.setTranslateX(puntero.getTranslateX() + desplazamientoX1);
        puntero.setTranslateY(puntero.getTranslateY() + desplazamientoY1);
    }
    private void moverCielo(){
        cielo.setTranslateY(cielo.getTranslateY()+10);
    }
    private void disparar(){
        boolean impacto = false;
        misil.setFill(new ImagePattern(new Image("misil.png")));
        misil.heightProperty().bind(pista.heightProperty().divide(11));
        misil.widthProperty().bind(pista.heightProperty().divide(15));
        misil.setTranslateX(nave1.getTranslateX());
        misil.setTranslateY(nave1.getTranslateY()-28);
    }
    private void moverDisparo() {
        misil.setTranslateY(misil.getTranslateY()-30);
    }


    private void detectarColision1() {
        if (nave1.getBoundsInParent().intersects(paredDerecha.getBoundsInParent()))
            nave1.setTranslateX(-207);
        if (nave1.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent()))
            nave1.setTranslateX(207);
        if (puntero.getBoundsInParent().intersects(paredSuperior.getBoundsInParent()))
            puntero.setTranslateY(-230);
        if (puntero.getBoundsInParent().intersects(nave1.getBoundsInParent()))
            puntero.setTranslateY(164);
        if (puntero.getBoundsInParent().intersects(paredDerecha.getBoundsInParent()))
            //nave1.setEffect(new Bloom(2));
            puntero.setTranslateX(-207);
        if (puntero.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent()))
            puntero.setTranslateX(207);
        if (cielo.getTranslateY() == 500)
            cielo.setTranslateY(-500);
        if (misil.getBoundsInParent().intersects(paredSuperior.getBoundsInParent()));

    }
}
