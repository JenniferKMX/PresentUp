package ficherosDAO;

import java.io.DataInputStream;
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

}
