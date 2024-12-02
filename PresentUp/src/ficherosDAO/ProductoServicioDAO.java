package ficherosDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import datos.ProductoServicio;

public class ProductoServicioDAO {

    public static ProductoServicio leer(DataInputStream dis) throws IOException {
        ProductoServicio prodserv = new ProductoServicio();
        prodserv.setDescripcion(dis.readUTF());
        prodserv.setPublico(dis.readUTF());
        return prodserv;
    }

    public static void escribir(DataOutputStream dos, ProductoServicio prodserv) throws IOException {
        dos.writeUTF(prodserv.getDescripcion());
        dos.writeUTF(prodserv.getPublico());
    }

}
