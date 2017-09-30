import java.sql.*;
import java.util.ArrayList;

public class PessoaPersistencia {

    private Connection connection;

    public PessoaPersistencia(MysqlConnector connector) {
        this.connection = connector.getConnection();
    }

    public void insert(String nome, String data, String observacoes) {
        try {
            String sql = "INSERT INTO pessoa (nome,data_cadastro, observacoes) VALUES (?,?,?)";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, data);
            statement.setString(3, observacoes);
            statement.executeLargeUpdate();
        } catch (SQLException e) {
            System.out.println("Deu pau em inserir: " + e);
        }
    }

    public void update(int id, String nome, String dataCadastro, String observacoes){
        try {
            String update = "UPDATE pessoa SET nome=?, data_cadastro=?,observacoes=? WHERE id = ?";
            PreparedStatement statementUp = this.connection.prepareStatement(update);
            statementUp.setString(1,nome);
            statementUp.setString(2,dataCadastro);
            statementUp.setString(3,observacoes);
            statementUp.setInt(4,id);
            int linhasAtualizadas = statementUp.executeUpdate();
            System.out.println("Linhas atualizadas: " + linhasAtualizadas);
        } catch (SQLException e) {
            System.out.println("Deu pau ao atualizar");
        }
    }

    public ResultSet select() throws SQLException {
            String select = "SELECT * FROM pessoa";
            ResultSet resultSet = this.connection.createStatement().executeQuery(select);
            return resultSet;
    }

    public void delete(int id) {
        try {
            String delete = "DELETE FROM pessoa WHERE id > ?";
            PreparedStatement statementdel = this.connection.prepareStatement(delete);
            statementdel.setInt(1,id);
            statementdel.executeUpdate();
        } catch (Exception e) {
            System.out.println("Deu pau ao remover: " + e);
        }
    }


}
