package app;

import ParserArgs.Parser;
import ParserArgs.StoreDataSector;
import Utils.GenerateFillFactor;
import org.apache.commons.cli.ParseException;
import view.Field;

public class App {

    public static void main(String[] args) {

        StoreDataSector data = new StoreDataSector();

        try {
            data = checkValidInput(args);
            Field field = createField(data);

            //поиск
            //печать

        } catch (ParseException e) {
            System.out.println(data.printDemand());
        }
    }

    private static StoreDataSector checkValidInput(String[] args) throws ParseException {
        Parser parser = new Parser();
        parser.parse(args);
        return parser.getData();
    }

    private static Field createField(StoreDataSector data) {
        int height = data.getHeight();
        int width = data.getWidth();
        double fillFactorPercent =  data.getFillFactor();
        int fillFactor = GenerateFillFactor.generate(height, width, fillFactorPercent);
        return new Field(height, width, fillFactor);
    }

}
