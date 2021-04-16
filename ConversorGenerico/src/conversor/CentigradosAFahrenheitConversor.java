package conversor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tobias
 */
public class CentigradosAFahrenheitConversor extends Conversor {

    private final double FAHRENHEIT = 32;

    @Override
    public String getLabelValor1() {
        return "Centigrados";
    }

    @Override
    public String getLabelValor2() {
        return "Farenheit";
    }

    @Override
    public double ConvertirSegunValor1(double valor1) {
            double resultado = (valor1 * 1.8) + FAHRENHEIT;
            return resultado;
    }

    @Override
    public double ConvertirSegunValor2(double valor2) {
            double resultado = (valor2 - FAHRENHEIT) * 0.55 ;
            return resultado;        
    }

}
