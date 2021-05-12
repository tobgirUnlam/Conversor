/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpersona;

import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Alumno;
import persona.AlumnoException;
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
        Persona persona = new Persona();
        try {
            persona.setDni(10);
            persona.setNombre("   José  Maria ");
            persona.setApellido("Garcia");
            
            persona.setFechaNacimiento(new MiCalendario(29, 2, 2020));
            System.out.println(persona.getFechaNacimiento());
            
            
            Persona maria = new Persona(20);
            maria.setNombre("María");
            maria.setApellido("Gomez");

            Persona otraPersona = new Persona(30, "Juana", "Martinez");

            Persona otraPersona2 = new Persona(40, "Miguel", "Juarez", null, 'm');
            otraPersona2.setSexo('f');
            otraPersona2.setFechaNacimiento(new MiCalendario(2, 10, 2021));
            
            System.out.println("Fecha Nac: "+ otraPersona2.getFechaNacimiento());
            
            MiCalendario fechaNac = new MiCalendario(23, 8, 1992);
            MiCalendario fechaIng = new MiCalendario(1, 3, 1993);
            Alumno alu = new Alumno(4004600, "Juan Luis Juan Luis Juan Luis Juan Luis", "Perez", fechaNac, fechaIng, 5, 0.335, 'M', true);
            alu.setSexo('M');
            //alu.setActivo(false);
            
            System.out.println("Alumno ==>"+ alu);
			
			System.out.println("TODO OK");
            
        } catch (AlumnoException alumnoException) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, alumnoException);
            return;
        } catch (PersonaException | MiCalendarioException ex) {
            Logger.getLogger(TestPersona.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }
    
}
