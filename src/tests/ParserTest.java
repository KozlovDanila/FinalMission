package tests;

import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;
import parserArgs.Parser;
import parserArgs.InputData;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    public void checkGetData() {
        String[] args = {"-h","2", "-w", "3", "-f", "0.3"};
        InputData store = new InputData();
        try {
            parser.parse(args);
            store = parser.getData();
        } catch (ParseException e) {
        }
        Assert.assertEquals(store.getHeight(), 2);
        Assert.assertEquals(store.getWidth(), 3);
    }

}