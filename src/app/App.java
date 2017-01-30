package app;

import org.apache.commons.cli.ParseException;
import parserArgs.Parser;
import parserArgs.StoreDataSector;
import ranking.Group;
import ranking.GroupFinder;
import utils.GenerateFillFactor;
import utils.Print;
import utils.Randomiser;
import view.Field;

public class App {

    public static void main(String[] args) {

        StoreDataSector data = new StoreDataSector();

        try {
            data = createData(args);
        } catch (ParseException e) {
            System.out.println(data.printDemand());
        }

        Field field = createField(data);
        GroupFinder finder = new GroupFinder(field);
        Group[] group = finder.findGroup();
        Print.printResult(field, data.getFillFactor(), group);
    }

    private static StoreDataSector createData(String[] args) throws ParseException {
        Parser parser = new Parser();
        parser.parse(args);
        return parser.getData();
    }

    private static Field createField(StoreDataSector data) {
        int height = data.getHeight();
        int width = data.getWidth();
        double fillFactorPercent = data.getFillFactor();
        int fillFactor = GenerateFillFactor.generate(height, width, fillFactorPercent);
        Field field = new Field(height, width);
        Randomiser.createRandomBusyPlace(field, fillFactor);
        return field;
    }

}
