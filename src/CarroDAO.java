import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class CarroDAO extends DAOPadrao <Carro,Integer>{

    private Connection connection  = Banco.conectar();
    private String comandoSql;

    public CarroDAO() throws SQLException {
        super( "carro");
    }

    @Override
    public void inserir(Carro obj) {
        comandoSql = "INSERT INTO carro Values(?,?,?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setInt(1,obj.getId());
            statement.setString(2,obj.getMarca());
            statement.setString(3,obj.getModelo());
            statement.setInt(4,obj.getAno());
            statement.setString(5,obj.getCor());
            statement.setDouble(6,obj.getPreco());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Carro converter(ResultSet resultSet) throws SQLException {
        return new Carro(resultSet);
    }

    @Override
    public void atualizar( Carro obj) {
      comandoSql = "update carro set marca= ?, modelo = ?, ano = ?, cor = ?, preco = ? where idcarro = ?";
        try(PreparedStatement statement = connection.prepareStatement(comandoSql)){
            statement.setString(1, obj.getMarca());
            statement.setString(2,obj.getModelo());
           statement.setInt(3,obj.getAno());
           statement.setString(4,obj.getCor());
           statement.setDouble(5,obj.getPreco());
           statement.setInt(6,obj.getId());
            statement.execute();
      }catch (SQLException e){
           throw new RuntimeException(e);
      }
    }

}
