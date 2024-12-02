package ficherosDAO;

import datos.Empresa;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EmpresaDAO {

    public static Empresa leer(DataInputStream dis) throws IOException {
        Empresa empresa = new Empresa();
        empresa.setNomEmpresa(dis.readUTF());
        empresa.setEslogan(dis.readUTF());
        empresa.setValores(dis.readUTF());
        return empresa;
    }

    public static void escribir(DataOutputStream dos, Empresa empresa) throws IOException {
        dos.writeUTF(empresa.getNomEmpresa());
        dos.writeUTF(empresa.getEslogan());
        dos.writeUTF(empresa.getValores());
    }

}
