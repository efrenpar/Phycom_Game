/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phycomgame.model;

import java.util.ArrayList;

/**
 *
 * @author Israel
 */
public class Reto {
    protected String enunciado;
    protected ArrayList<String> opciones;
    protected String respuesta;
    protected boolean completado = false;

    public Reto(String enunciado, ArrayList<String> opciones, String respuesta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuesta = respuesta;
    }
    
    

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public ArrayList<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList<String> opciones) {
        this.opciones = opciones;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    
    
}
