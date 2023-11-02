package org.ull.es.dap.connections;

public class ParserVehicles extends Parser{
    public ParserVehicles(CSVReader csvReader) {
        super(csvReader);
    }

    @Override
    protected Object convert(String value, String columnName) {
        if (columnName.equals("Year")){
            return Integer.parseInt(value);
        } else if (columnName.equals("Price")) {
            return Double.parseDouble(value);
        }
        else {
            return value;
        }
    }
}