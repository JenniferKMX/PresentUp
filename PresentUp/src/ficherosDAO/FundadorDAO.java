package ficherosDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import datos.Fundador;

public class FundadorDAO {

    public static Fundador leer(DataInputStream dis) throws IOException {
        Fundador fundador = new Fundador();
        fundador.setId();
        fundador.setNombre(dis.readUTF());
        fundador.setCargo(dis.readUTF());
        fundador.setBiograf(dis.readUTF());
        return fundador;
    }

    public static void escribir(DataOutputStream dos, Fundador fundador) throws IOException {
        dos.writeInt(fundador.getId());
        dos.writeUTF(fundador.getNombre());
        dos.writeUTF(fundador.getCargo());
        dos.writeUTF(fundador.getBiograf());
    }

}
