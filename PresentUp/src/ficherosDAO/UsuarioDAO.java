package ficherosDAO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import datos.Usuario;

public class UsuarioDAO {

    public static Usuario leer(DataInputStream dis) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setNom(dis.readUTF());
        usuario.setApes(dis.readUTF());
        usuario.setEmail(dis.readUTF());
        usuario.setPassword(dis.readUTF());
        usuario.setPref(dis.readUTF());
        usuario.setTlf(dis.readUTF());
        return usuario;
    }

    public static void escribir(DataOutputStream dos, Usuario usuario) throws IOException {
        dos.writeUTF(usuario.getNom());
        dos.writeUTF(usuario.getApes());
        dos.writeUTF(usuario.getEmail());
        dos.writeUTF(usuario.getPassword());
        dos.writeUTF(usuario.getPref());
        dos.writeUTF(usuario.getTlf());
    }

}
