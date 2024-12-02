package ficherosDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import datos.Financiacion;

public class FinanciacionDAO {

    public static Financiacion leer(DataInputStream dis) throws IOException {
        Financiacion financiacion = new Financiacion();
        financiacion.setEurosSolicitados(dis.readFloat());
        financiacion.setUsoFondos(dis.readUTF());
        financiacion.setProyeccionIngresos(dis.readUTF());
        financiacion.setProyeccionGastos(dis.readUTF());
        return financiacion;
    }

    public static void escribir(DataOutputStream dos, Financiacion f) throws IOException {
        dos.writeFloat(f.getEurosSolicitados());
        dos.writeUTF(f.getUsoFondos());
        dos.writeUTF(f.getProyeccionIngresos());
        dos.writeUTF(f.getProyeccionGastos());
    }

}
