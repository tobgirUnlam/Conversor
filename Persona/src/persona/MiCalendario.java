/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.GregorianCalendar;

/**
 *
 * @author Tobias
 */
public class MiCalendario extends GregorianCalendar {

    public MiCalendario() {
    }

    public MiCalendario(int dia, int mes, int anio) throws MiCalendarioException {
        super(anio, mes-1, anio);
        setLenient(false);
        try {
            get(YEAR);
        } catch (Exception ex) {
            throw new MiCalendarioException("Error en la fecha");
        }

    }

}
