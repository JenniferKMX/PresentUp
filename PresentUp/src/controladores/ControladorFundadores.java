package controladores;

import java.awt.event.ActionListener;

import interfaz.AniadirFund;
import datos.Fundador;

import java.awt.event.ActionEvent;

public class ControladorFundadores {
    private AniadirFund fundadores;

    public ControladorFundadores(AniadirFund fundadores){
        this.fundadores = fundadores;
        // Agregar listener al botón de guardar
        this.fundadores.guardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarFundador();
            }
        });
    }
    private void guardarFundador(){

        String nombreFundador = fundadores.getNombreFundador2().getText();
        String cargo = fundadores.getCargoFundador2().getText();
        String breveBiografia = fundadores.getBiografia2().getText();

        Fundador fundador = new Fundador(nombreFundador, cargo, breveBiografia);
    }

}
