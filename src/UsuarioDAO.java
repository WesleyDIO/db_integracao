import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDAO extends DAOPadrao<Usuario, Integer> {

    private Connection connection = Banco.conectar();
    private String comandoSql;

    public UsuarioDAO() throws SQLException {
        super( "usuario");
    }

    public void inserir( Usuario usuario){
         comandoSql = "insert into usuario value(?,?,?,?,?);";
        try ( PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setInt(1,usuario.getId());
            statement.setString(2, usuario.getUsuario());
            statement.setString(3,usuario.getSenha());
            statement.setInt(4,usuario.getIdade());
            try {
                statement.setInt(5,usuario.getCarro().getId());
            } catch (NullPointerException e) {
               statement.setNull(5,0);
            }
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void atualizar( Usuario obj) {
        Usuario usuarioEncontrado = buscarUm(obj.getId());
         comandoSql = "update usuario set nome = ?, senha = ?, idade = ?, id_carro = ? where id_usuario = ?";
        try(PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setString(1, obj.getUsuario());
            statement.setString(2,obj.getSenha());
            statement.setInt(3,obj.getIdade());
            try {
                statement.setInt(4, obj.getCarro().getId());
            }catch (NullPointerException e){
                statement.setNull(4,0);
            }
            statement.setInt(5,usuarioEncontrado.getId());
            statement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public Usuario converter(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet);
    }
}
