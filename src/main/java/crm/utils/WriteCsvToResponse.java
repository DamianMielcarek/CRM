package crm.utils;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import crm.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

public class WriteCsvToResponse {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

    public static void writeCustomers(PrintWriter printWriter, List<Customer> customers) {
        try {
            ColumnPositionMappingStrategy columnPositionMappingStrategy = new ColumnPositionMappingStrategy();

            columnPositionMappingStrategy.setType(Customer.class);
            columnPositionMappingStrategy.generateHeader();

            String[] columns = new String[]{"id", "name", "email", "phone", "firstName", "lastName", "city", "address", "enabled"};
            columnPositionMappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(printWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(',')
                    .build();

            statefulBeanToCsv.write(customers);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

    public static void writeCustomer(PrintWriter printWriter, Customer customer) {
        try {
            ColumnPositionMappingStrategy columnPositionMappingStrategy = new ColumnPositionMappingStrategy();

            columnPositionMappingStrategy.setType(Customer.class);

            String[] columns = new String[]{"id", "name", "email", "phone", "firstName", "lastName", "city", "address", "enabled"};
            columnPositionMappingStrategy.setColumnMapping(columns);

            StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(printWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(columnPositionMappingStrategy)
                    .withSeparator(',')
                    .build();

            statefulBeanToCsv.write(customer);
        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }

}
