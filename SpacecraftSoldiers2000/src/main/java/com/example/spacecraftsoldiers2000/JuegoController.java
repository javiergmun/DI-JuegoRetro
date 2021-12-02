package com.example.spacecraftsoldiers2000;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.effect.*;
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
    private Rectangle enemigo1;
    private Rectangle enemigo2;
    private Rectangle enemigo3;
    private Rectangle enemigo4;
    private Rectangle enemigo5;
    private Rectangle vida1;
    private Rectangle vida2;
    private Rectangle vida3;
    //private int contadorAux;
    private double velocidad;
    private Timeline animacion;
    private double desplazamientoX1;
    private double desplazamientoY1;


    public JuegoController(StackPane pista, Rectangle puntero, Rectangle cielo, Rectangle paredIzquierda, Rectangle paredDerecha,
                           Rectangle paredSuperior, Rectangle paredInferior, Rectangle nave1, Rectangle misil, Rectangle enemigo1,
                           Rectangle enemigo2, Rectangle enemigo3, Rectangle enemigo4, Rectangle enemigo5, Rectangle vida1,
                           Rectangle vida2, Rectangle vida3) {
        this.pista = pista;
        this.puntero = puntero;
        this.cielo = cielo;
        this.paredIzquierda = paredIzquierda;
        this.paredDerecha = paredDerecha;
        this.paredSuperior = paredSuperior;
        this.paredInferior = paredInferior;
        this.nave1 = nave1;
        this.misil = misil;
        nave1.setTranslateX(0);
        nave1.setTranslateY(200);
        this.enemigo1 = enemigo1;
        this.enemigo2 = enemigo2;
        this.enemigo3 = enemigo3;
        this.enemigo4 = enemigo4;
        this.enemigo5 = enemigo5;
        this.vida1 = vida1;
        this.vida2 = vida2;
        this.vida3 = vida3;
        this.velocidad = 4;
        //this.contadorAux=0;

        inicializarJuego();
        inicializarControles1();
    }

    private void inicializarJuego() {
        this.animacion = new Timeline(new KeyFrame(Duration.millis(17), t -> {  //le digo TO-DO lo que tiene que hacer en cada frame de la app
            detectarColision1();
            moverNave1();
            moverCielo();
            moverPuntero();
            moverDisparo();
            moverEnemigos();
        }));
        animacion.setCycleCount(animacion.INDEFINITE);
    }

    private void inicializarControles1() {
        pista.setOnKeyPressed(g -> {
            switch (g.getCode()) {

                case SPACE:
                    animacion.play();
                    paredIzquierda.setFill(Color.DARKBLUE);
                    paredDerecha.setFill(Color.DARKBLUE);
                    paredSuperior.setFill(Color.DARKBLUE);
                    paredInferior.setFill(Color.DARKBLUE);
                    crearEnemigos();
                    break;
                case A:
                    desplazamientoX1 = -1 * velocidad;

                    break;
                case W:
                    desplazamientoY1 = -1 * velocidad;
                    break;
                case D:
                    desplazamientoX1 = 1 * velocidad;

                    break;
                case S:

                    desplazamientoY1 = 1 * velocidad;
                    break;
                case E:
                    disparar();
            }
        });
        pista.setOnKeyReleased(g -> {
            switch (g.getCode()) {

                case A:
                    desplazamientoX1 = 0;
                    break;
                case D:
                    desplazamientoX1 = 0;
                    break;
                case S:
                    desplazamientoY1 = 0;
                case W:
                    desplazamientoY1 = 0;
            }
        });
        pista.setFocusTraversable(true);
    }

    private void moverNave1() {
        nave1.setTranslateX(nave1.getTranslateX() + desplazamientoX1);
        vida1.setTranslateX(nave1.getTranslateX()+20);
        vida2.setTranslateX(nave1.getTranslateX());
        vida3.setTranslateX(nave1.getTranslateX()-20);
    }

    private void moverPuntero() {
        puntero.setTranslateX(puntero.getTranslateX() + desplazamientoX1);
        puntero.setTranslateY(puntero.getTranslateY() + desplazamientoY1);
    }

    private void moverCielo() {
        cielo.setTranslateY(cielo.getTranslateY() + 10);
    }

    private void disparar() {
        misil.setTranslateY(nave1.getTranslateY() - 28);
        misil.setTranslateX(nave1.getTranslateX());
    }

    private void moverDisparo() {
        misil.setTranslateY(misil.getTranslateY() - 30);
        misil.setFill(new ImagePattern(new Image("misil.png")));
        misil.heightProperty().bind(pista.heightProperty().divide(11));
        misil.widthProperty().bind(pista.heightProperty().divide(15));
    }

    private void crearEnemigos() {
        enemigo1.setFill(new ImagePattern(new Image("enemigo1.png")));
        enemigo1.setTranslateX((int) Math.floor(Math.random() * 220 - 220));
        enemigo1.setTranslateY(-250);
        enemigo1.heightProperty().bind(pista.heightProperty().divide(15));
        enemigo1.widthProperty().bind(pista.heightProperty().divide(15));

        enemigo2.setFill(new ImagePattern(new Image("enemigo2.png")));
        enemigo2.setTranslateX((int) Math.floor(Math.random() * 220 - 220));
        enemigo2.setTranslateY(-250);
        enemigo2.heightProperty().bind(pista.heightProperty().divide(15));
        enemigo2.widthProperty().bind(pista.heightProperty().divide(15));

        enemigo3.setFill(new ImagePattern(new Image("enemigo3.png")));
        enemigo3.setTranslateX((int) Math.floor(Math.random() * 220 - 220));
        enemigo3.setTranslateY(-250);
        enemigo3.heightProperty().bind(pista.heightProperty().divide(15));
        enemigo3.widthProperty().bind(pista.heightProperty().divide(15));

        enemigo4.setFill(new ImagePattern(new Image("enemigo4.png")));
        enemigo4.setTranslateX((int) Math.floor(Math.random() * -210 + 210));
        enemigo4.setTranslateY(-250);
        enemigo4.heightProperty().bind(pista.heightProperty().divide(15));
        enemigo4.widthProperty().bind(pista.heightProperty().divide(15));

        enemigo5.setFill(new ImagePattern(new Image("enemigo5.png")));
        enemigo5.setTranslateX((int) Math.floor(Math.random() * -210 + 210));
        enemigo5.setTranslateY(-250);
        enemigo5.heightProperty().bind(pista.heightProperty().divide(15));
        enemigo5.widthProperty().bind(pista.heightProperty().divide(15));
    }

    private void moverEnemigos() {
        //ENEMIGO 1
        enemigo1.setTranslateY(enemigo1.getTranslateY() + 1.5);
        //ENEMIGO 2
        enemigo2.setTranslateY(enemigo2.getTranslateY() + 1);
        enemigo2.setTranslateX(enemigo2.getTranslateX() + 3);
        //ENEMIGO 3
        enemigo3.setTranslateY(enemigo3.getTranslateY() + 0.9);
        //ENEMIGO 4
        enemigo4.setTranslateY(enemigo4.getTranslateY() + 1);
        enemigo4.setTranslateX(enemigo4.getTranslateX() + 5);
        //ENEMIGO 5
        enemigo5.setTranslateY(enemigo5.getTranslateY() + 0.5);
        enemigo5.setTranslateX(enemigo5.getTranslateX() - 2);
    }


    private void detectarColision1() {
        //PUNTERO, NAVE  CON PAREDES
        if (nave1.getBoundsInParent().intersects(paredDerecha.getBoundsInParent()))
            nave1.setTranslateX(-207);
        if (nave1.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent()))
            nave1.setTranslateX(207);
        if (puntero.getBoundsInParent().intersects(paredSuperior.getBoundsInParent()))
            puntero.setTranslateY(-230);
        if (puntero.getBoundsInParent().intersects(nave1.getBoundsInParent()))
            puntero.setTranslateY(164);
        if (puntero.getBoundsInParent().intersects(paredDerecha.getBoundsInParent()))
            puntero.setTranslateX(-207);
        if (puntero.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent()))
            puntero.setTranslateX(207);
        if (cielo.getTranslateY() == 500)
            cielo.setTranslateY(-500);
        // ENEMIGOS CON MISIL
        if (misil.getBoundsInParent().intersects(enemigo1.getBoundsInParent())) {
            enemigo1.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo1.setTranslateY(-250);
            misil.setTranslateY(-500);
        }
        if (misil.getBoundsInParent().intersects(enemigo2.getBoundsInParent())) {
            enemigo2.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo2.setTranslateY(-250);
            misil.setTranslateY(-500);
        }
        if (misil.getBoundsInParent().intersects(enemigo3.getBoundsInParent())) {
            enemigo3.setTranslateX((int) Math.floor(Math.random() * -210 + 210));
            enemigo3.setTranslateY(-250);
            misil.setTranslateY(-500);
        }
        if (misil.getBoundsInParent().intersects(enemigo4.getBoundsInParent())) {
            enemigo4.setTranslateX((int) Math.floor(Math.random() * -210 + 210));
            enemigo4.setTranslateY(-250);
            misil.setTranslateY(-500);
        }
        if (misil.getBoundsInParent().intersects(enemigo5.getBoundsInParent())) {
            enemigo5.setTranslateX((int) Math.floor(Math.random() * -210 + 210));
            enemigo5.setTranslateY(-250);
            misil.setTranslateY(-500);
        }
        //ENEMIGOS CON PAREDES or  CON NAVE
        if (enemigo1.getBoundsInParent().intersects(paredInferior.getBoundsInParent()) ||
                (enemigo1.getBoundsInParent().intersects(nave1.getBoundsInParent()))) {
            enemigo1.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo1.setTranslateY(-250);
            vida1.setVisible(false);
            //restar puntos y vida
        }
        if (enemigo2.getBoundsInParent().intersects(paredInferior.getBoundsInParent()) ||
                (enemigo2.getBoundsInParent().intersects(nave1.getBoundsInParent()))) {
            enemigo2.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo2.setTranslateY(-250);
            vida1.setVisible(false);
        }
        if (enemigo3.getBoundsInParent().intersects(paredInferior.getBoundsInParent()) ||
                (enemigo3.getBoundsInParent().intersects(nave1.getBoundsInParent()))) {
            enemigo3.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo3.setTranslateY(-250);
            vida1.setVisible(false);
        }
        if (enemigo4.getBoundsInParent().intersects(paredInferior.getBoundsInParent()) ||
                (enemigo4.getBoundsInParent().intersects(nave1.getBoundsInParent()))) {
            enemigo4.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo4.setTranslateY(-250);
        }
        if (enemigo5.getBoundsInParent().intersects(paredInferior.getBoundsInParent()) ||
                (enemigo5.getBoundsInParent().intersects(nave1.getBoundsInParent()))) {
            enemigo5.setTranslateX((int) Math.floor(Math.random() * 210 - 210));
            enemigo5.setTranslateY(-250);
            vida1.setVisible(false);
        }
        // ENEMIGOS CON PAREDES LATERALES
        if (enemigo2.getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            enemigo2.setTranslateX(-enemigo2.getTranslateX());
        }
        if (enemigo4.getBoundsInParent().intersects(paredDerecha.getBoundsInParent())) {
            enemigo4.setTranslateX(-enemigo4.getTranslateX());
        }
        if (enemigo5.getBoundsInParent().intersects(paredIzquierda.getBoundsInParent())) {
            enemigo5.setTranslateX(-enemigo5.getTranslateX());
        }
        }
    }





