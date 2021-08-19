package eu.xenit.poc.facets;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class PGBatchInserterTest {

    @Test
    void createDataTest() throws SQLException {
        PGBatchInserter pgBatchInserter = new PGBatchInserter("jdbc:postgresql://localhost/facetpoc", "my_user", "my_password");
        Supplier<String> col1Supplier = new RandomStringGeneratorWithMaxCardinality(5, 9, 10);
        Supplier<String> col2Supplier = new RandomStringGeneratorWithMaxCardinality(10, 15, 100);
        Supplier<String> col3Supplier = new RandomStringGeneratorWithMaxCardinality(3, 5, 1000);
        Supplier<String> col4Supplier = new RandomStringGenerator(2, 10);
        pgBatchInserter.creatTestData(1000000, "INSERT INTO sampledata (col1, col2, col3, col4) VALUES (?, ?, ?, ?)", col1Supplier, col2Supplier, col3Supplier, col4Supplier );
    }

}