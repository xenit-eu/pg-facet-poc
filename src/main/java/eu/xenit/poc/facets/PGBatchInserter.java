package eu.xenit.poc.facets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Supplier;

public class PGBatchInserter {

    private String url;
    private String user;
    private String password;

    public PGBatchInserter(String url, String user, String password) {
        this.url = url;
        this.password = password;
        this.user = user;
    }

    public void creatTestData(int rows, String statement, Supplier<String>... stringSuppliers) throws SQLException {
        try (Connection connection = connect();
                PreparedStatement preparedStatement = connection.prepareStatement(statement)) {
            for (int i = 0; i <= rows; i++) {
                for (int j = 1; j <= stringSuppliers.length; j++) {
                    preparedStatement.setString(j, stringSuppliers[j-1].get());
                }
                preparedStatement.addBatch();
                if (i % 100 == 0 || i == rows) {
                    preparedStatement.executeBatch();
                }
            }
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
