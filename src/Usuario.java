import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private Integer id;
    private String usuario;
    private String senha;
    private Integer idade;

    private Carro carro;

    public Usuario(Integer id, String usuario, String senha, Integer idade) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.idade = idade;
    }

    public Usuario(Integer id, String usuario, String senha, Integer idade, Carro carro) {
        this(id,usuario,senha,idade);
        this.carro = carro;
    }

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id_usuario");
        this.usuario = resultSet.getString("nome");
        this.senha = resultSet.getString("Senha");
        this.idade = resultSet.getInt("idade");
        int idCarro = resultSet.getInt("idcarro");
        if (idCarro !=0) {
            this.carro = new Carro(idCarro);
        }
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade +
                ", carro=" + carro+
                '}';
    }
}
