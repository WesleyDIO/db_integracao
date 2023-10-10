import java.sql.ResultSet;
import java.sql.SQLException;

public class Carro {
    private int id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

    public Carro(int id, String marca, String modelo, Integer ano, String cor,Double preco) {
        this.id = id;
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }

    public Carro(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.modelo = resultSet.getString("modelo");
        this.marca = resultSet.getString("marca");
        this.ano = resultSet.getInt("ano");
        this.preco = resultSet.getDouble("preco");
        this.cor = resultSet.getString("cor");
    }

    public Carro(Integer id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getAno() {
        return ano;
    }


    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", marca='" + getMarca() + '\'' +
                ", cor='" + getCor() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", preco=" + getPreco() +
                ", ano=" + getAno() +
                '}';
    }
}
