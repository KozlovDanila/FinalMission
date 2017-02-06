package app;

import org.apache.commons.cli.ParseException;
import parserArgs.InputData;
import parserArgs.Parser;
import ranking.Group;
import ranking.GroupFinder;
import utils.GeneratorFillFactor;
import utils.Printer;
import view.Field;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {

        InputData data = new InputData();

        try {
            data = createData(args);
        } catch (ParseException e) {
            printException();
        }catch ( NumberFormatException e) {
           printException();
        }

        Field field = createField(data);
        GroupFinder finder = new GroupFinder(field);
        HashMap<Group, Integer> group = finder.find();
        Printer.printResult(field, data.getFillFactor(), group);
    }

    private static void printException() {
        System.out.println(Printer.printDemand());
        System.exit(0);
    }

    private static InputData createData(String[] args) throws ParseException {
        Parser parser = new Parser();
        parser.parse(args);
        return parser.getData();
    }

    private static Field createField(InputData data) {
        int fillFactor = GeneratorFillFactor.generate(data.getHeight(), data.getWidth(), data.getFillFactor());
        Field field = new Field(data.getHeight(), data.getWidth());
        field.createRandomBusyPlace(fillFactor);
        return field;
    }

}
