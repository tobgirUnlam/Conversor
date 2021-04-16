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
public class KilometrosPorHoraAMillasPorHoraConversor extends Conversor {

    private final double MILLASPORHORAAKILOMETROSPORHORA = 1.609;

    @Override
    public String getLabelValor1() {
        return "Km/h";
    }

    @Override
    public String getLabelValor2() {
        return "M/h";
    }

    @Override
    public double ConvertirSegunValor1(double valor1) {
            double resultado = valor1 * MILLASPORHORAAKILOMETROSPORHORA;
            return resultado;
    }

    @Override
    public double ConvertirSegunValor2(double valor2) {
            double resultado = valor2 / MILLASPORHORAAKILOMETROSPORHORA;
            return resultado;        
    }

}
