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
public class LitrosAGalonConversor extends Conversor {

    private final double UN_GALON = 3.785;

    @Override
    public String getLabelValor1() {
        return "Litros";
    }

    @Override
    public String getLabelValor2() {
        return "Galones";
    }

    @Override
    public double ConvertirSegunValor1(double valor1) {
            double resultado = valor1 / UN_GALON;
            return resultado;
    }

    @Override
    public double ConvertirSegunValor2(double valor2) {
            double resultado = valor2 * UN_GALON;
            return resultado;        
    }

}
