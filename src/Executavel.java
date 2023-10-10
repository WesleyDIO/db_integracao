import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Executavel {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(9800,"Toreto","careca123",50,new Carro(2,"Dodge", "preto", 1979, "preto", 100000.0));
        try(ICRUD<Carro, Integer> crudCarro = new CarroDAO(); ICRUD<Usuario, Integer> crudUsuario = new UsuarioDAO()) {
            try {
                crudCarro.buscarUm(usuario1.getCarro().getId());
            } catch (NoSuchElementException e) {
                crudCarro.inserir(usuario1.getCarro());
            }
            crudUsuario.inserir(usuario1);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

}