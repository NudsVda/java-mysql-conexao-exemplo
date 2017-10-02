import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {

        // Chamando a nossa conexao
        MysqlConnector mysqlConnector = new MysqlConnector();
        mysqlConnector.connect();

        //fazendo um insert
        String sql = "INSERT INTO pessoa (nome,data_cadastro, observacoes) VALUES (?,?,?)";

        PreparedStatement statement = mysqlConnector.getConnection().prepareStatement(sql);
        statement.setString(1,"Catatau");
        statement.setString(2,"2017-10-10");
        statement.setString(3,"Meio mau pagador");
        statement.executeUpdate();


        //fazendo um select
        String select = "SELECT * FROM pessoa";
        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()){
            String nome = resultSet.getString(2);
            String data_cadastro = resultSet.getString(3);
            String observacoes = resultSet.getString(4);
            System.out.println(
                    "Pessoa: " + nome
                            + " Cadastro em: " + data_cadastro
                            + " Obs: " + observacoes);
        }



        //fazendo update
        String update = "UPDATE pessoa SET nome=? WHERE id = 2";
        PreparedStatement statementUp = mysqlConnector.getConnection().prepareStatement(update);
        statementUp.setString(1,"Chiquinha");
        int linhasAtualizadas = statementUp.executeUpdate();
        System.out.println("Linhas atualizadas: " + linhasAtualizadas);



        //deletando
        String delete = "DELETE FROM pessoa WHERE id = ?";
        PreparedStatement statementdel = mysqlConnector.getConnection().prepareStatement(delete);
        statementdel.setInt(1,31);
        statementdel.executeUpdate();


        mysqlConnector.disconnect();



    }


}
