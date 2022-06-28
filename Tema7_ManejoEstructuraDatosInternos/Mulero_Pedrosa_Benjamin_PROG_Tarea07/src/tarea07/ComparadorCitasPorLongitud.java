/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea07;

import java.util.Comparator;

/**
 *
 * @author benmu
 */
public class ComparadorCitasPorLongitud implements Comparator<CitaLiteraria> {
@Override
public int compare (CitaLiteraria uno, CitaLiteraria dos){

return  uno.getTexto().length()-dos.getTexto().length();
}
    
}
