/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phycomgame.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author Israel
 */
public class Reloj implements Runnable {
    private String horario;
    private int sec;
    private int min;
    private Label show;
    private boolean terminado = false; 

    public Reloj(String horario, int sec, int min,Label show) {
        this.horario = horario;
        this.sec = sec;
        this.min = min;
        this.show = show;
    }
    
    public void contar(){
    
        if(sec > 0 && sec <= 60){
        
            sec--;
        }
        else if(min > 0 && sec == 0){
        
            min--;
            sec+=60;
        }
        else{
        
            terminado = true;
        }
        this.horario = this.min+":"+this.sec;
        
    }

    public Label getShow() {
        return show;
    }

    public void setShow(Label show) {
        this.show = show;
    }
    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    
    
    
    @Override
    public void run() {
        while (!terminado){
            try {
                this.contar();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        show.setText(horario);
                        
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void iniciar(){
    
        Thread hilo = new Thread(this);
        hilo.setDaemon(true);
        hilo.start();
    }
    
}
