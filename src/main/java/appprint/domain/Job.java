package appprint.domain;

import java.util.function.Function;

/**
 * Total Pages, Color Pages, Double Sided
 * 0            1           2
 */
public class Job {

    private static String FIELDS [] = {"Total Pages", "Color Pages", "Double Sided"};

    private int totalPages;
    private int colorPages;
    private boolean isDouble;

    /**
     * This constructor parse a line from the CSV file into a Job instance. Validations and error handling are carried out
     */
    public Job(String line) {
        if(line == null || line.isEmpty()){
            throw new RuntimeException("Error trying to parse empty line");
        }

        try {
            String[] values = line.split(",");

            if(values.length < 3){
                throw new RuntimeException("Invalid amount of columns");
            }

            this.totalPages = parseField(s -> Integer.parseInt(s), values[0], 0);
            this.colorPages = parseField(s -> Integer.parseInt(s), values[1], 1);
            this.isDouble = parseField(s -> Boolean.parseBoolean(s), values[2], 2);
        }catch (Exception e){
            throw new RuntimeException(String.format("Error trying to parse line: '%s'. %s",line,  e.getMessage()));
        }
    }

    /**
     * This is a generic method to parse a given field to a given Type and handles errors with appropriate messages
     * @param parser
     * @param value
     * @param field
     * @param <T>
     * @return T
     */
    private <T> T parseField(Function<String,T> parser, String value, int field){
        try{
            return parser.apply(value.trim());
        }catch (NumberFormatException e){
            throw new RuntimeException(String.format("Use only integer values for field %s.", FIELDS[field]));
        }catch (Exception e){
            throw new RuntimeException(String.format("Problems found for field %s", FIELDS[field]));
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getColorPages() {
        return colorPages;
    }

    public boolean isDouble() {
        return isDouble;
    }

    @Override
    public String toString() {
        return String.format("Total Pages = %d - Color Pages = %d - Double = %b",
                getTotalPages(), getColorPages(),isDouble());
    }

    public int getBlackAndWhitePages() {
        return totalPages - colorPages;
    }
}
