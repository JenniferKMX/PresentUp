package controladores;

import java.awt.event.ActionListener;

import interfaz.FormularioFinanciacion;
import financiacion.Financiacion;
import java.awt.event.ActionEvent;

public class ControladorFinanciacion{
    private FormularioFinanciacion financiacion;

    public ControladorEmpresa(FormularioFinanciacion financiacion){
        this.financiacion = financiacion;
        // Agregar listener al botón de guardar
        this.financiacion.getFinalizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarFinanciacion();
            }
        });
    }
    private void guardarFinanciacion(){

        float eurosSolicitados = Float.parseFloat(financiacion.getEuros());
        String usoFondos = financiacion.getMotivoDinero();
        String proyeccionIngresos = financiacion.getIngresosPoryectados();
        String proyeccionGastos = financiacion.getGastosPoryectados();

        Financiacion financiacion = new Financiacion(eurosSolicitados, usoFondos, proyeccionIngresos, proyeccionGastos);
    }
}

