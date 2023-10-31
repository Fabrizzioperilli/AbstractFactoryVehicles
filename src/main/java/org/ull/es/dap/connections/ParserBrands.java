package org.ull.es.dap.connections;

public class ParserBrands extends Parser{
    public ParserBrands(CSVReader csvReader) {
        super(csvReader);
    }

    @Override
    protected Object convert(String value, String columnName) {
            return value;
    }
}
