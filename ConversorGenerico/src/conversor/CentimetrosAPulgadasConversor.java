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
public class CentimetrosAPulgadasConversor extends Conversor {

    private final double UNA_PULGADA = 2.54;

    @Override
    public String getLabelValor1() {       
        return "Centimetros";                       
    }

    @Override
    public String getLabelValor2() {
        return "Pulgadas";
    }

    @Override
    public double ConvertirSegunValor1(double valor1) {
        double resultado = valor1 * UNA_PULGADA;
        return resultado;
    }

    @Override
    public double ConvertirSegunValor2(double valor2) {
        double resultado = valor2 / UNA_PULGADA;
        return resultado;
    }

}
