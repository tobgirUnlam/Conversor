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
public class MetrosAKilometrosConversor extends Conversor {

    private final double UN_KILOMETRO = 1000;

    @Override
    public String getLabelValor1() {
        return "Metros";
    }

    @Override
    public String getLabelValor2() {
        return "Kilometros";
    }

    @Override
    public String ConvertirSegunValor1(double valor1) {
            double resultado = valor1 / UN_KILOMETRO;
            return Double.toString(resultado);
    }

    @Override
    public String ConvertirSegunValor2(double valor2) {
            double resultado = valor2 * UN_KILOMETRO;
            return Double.toString(resultado);        
    }

}
