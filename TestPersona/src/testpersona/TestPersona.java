/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpersona;

import java.util.logging.Level;
import java.util.logging.Logger;
import persona.MiCalendario;
import persona.MiCalendarioException;
import persona.Persona;
import persona.PersonaException;

/**
 *
 * @author Tobias
 */
public class TestPersona {

    public static void main(String[] args) {
        try {
            Persona pepe = new Persona();

            pepe.setDni(10);

            pepe.setNombre("JOsé");
            pepe.setApellido("García");
            pepe.setFechaNac(new MiCalendario(10, 04, 2000));
            Persona maria = new Persona(20);
            maria.setNombre("María");
            maria.setApellido("Gómez");

            Persona otraPersona = new Persona(20, "Juana", "Martinez");
            Persona otraPersona2 = new Persona(40, "Miguel", "Juarez", null);

            System.out.println("OK");
        } catch (PersonaException | MiCalendarioException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
