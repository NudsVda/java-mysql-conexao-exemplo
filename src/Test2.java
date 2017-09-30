import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {

    public static void main(String[] args) throws SQLException {

        // Chamando a nossa conexao
        MysqlConnector mysqlConnector = new MysqlConnector();

        PessoaPersistencia pessoaPersistencia = new PessoaPersistencia(mysqlConnector);
        pessoaPersistencia.insert("Joao","2018-01-01","ola mundo");
        pessoaPersistencia.delete(1);
        pessoaPersistencia.update(1,"Maria","2019-01-01","qualquer coisa");
        ResultSet resultSet = pessoaPersistencia.select();
        while (resultSet.next()){
            String nome = resultSet.getString(2);
            String data_cadastro = resultSet.getString(3);
            String observacoes = resultSet.getString(4);
            System.out.println(
                    "Pessoa: " + nome
                            + " Cadastro em: " + data_cadastro
                            + " Obs: " + observacoes);
        }

        mysqlConnector.disconnect();

    }


}
