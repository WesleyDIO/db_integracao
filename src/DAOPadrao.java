import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DAOPadrao<T,ID> implements ICRUD<T,ID> {

    protected Connection connection;

    protected String comandoSql;
    private String tabela;

    public DAOPadrao(String tabela) throws SQLException {
        this.connection =  Banco.conectar();
        this.tabela = tabela;
    }

    public Set<T> buscarTodos() {
        comandoSql = "Select * from "+tabela+";";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)){
            ResultSet resultSet = statement.executeQuery();
            Set<T> lista = new HashSet<>();
            while(resultSet.next()) {
                lista.add(converter(resultSet));
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public T buscarUm(Integer id){
        comandoSql = "Select * from "+tabela+" where id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(comandoSql)){
                statement.setInt(1,id);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                return converter(resultSet);
                }throw  new NoSuchElementException();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer id) {
        comandoSql = "DELETE FROM " + tabela + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(comandoSql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract T converter(ResultSet resultSet) throws SQLException;

    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}
