/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author Tobias
 */
public abstract class Conversor {

    public abstract String getLabelValor1();

    public abstract String getLabelValor2();

    public abstract double ConvertirSegunValor1(double valor1);
    
    public abstract double ConvertirSegunValor2(double valor1);
    
    @Override
    public String toString() {
        return getLabelValor1() + " a " + getLabelValor2();
    }
}
