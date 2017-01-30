package parserArgs;

import utils.ValueUtils;
import jdk.nashorn.internal.runtime.ParserException;
import org.apache.commons.cli.*;

public class Parser {
    CommandLine commandLine;

    public Parser() {
        commandLine = null;
    }

    public void parse(String[] args) throws ParseException {
        Options options = new Options();

        Option height = Option.builder("h").
                required(true).
                longOpt("height").
                hasArg().
                desc("").
                build();

        Option width = Option.builder("w").
                required(true).
                longOpt("width").
                hasArg().
                desc("").
                build();

        Option fillFactor = Option.builder("f").
                required(true).
                longOpt("fillFactor").
                hasArg().
                desc("").
                build();

        options.addOption(height);
        options.addOption(width);
        options.addOption(fillFactor);

        CommandLineParser parser = new DefaultParser();
        commandLine = parser.parse(options, args);
    }


    public StoreDataSector getData() throws ParseException {
        int height;
        int width;
        try {
            height = getValueInt("height");
            width = getValueInt("width");
        } catch (ParserException e) {
            throw new ParseException("");
        }


        String fillFactorStr = commandLine.getOptionValue("fillFactor");
        double fillFactor;
        if (ValueUtils.checkValueDouble(fillFactorStr)) {
            fillFactor = Double.parseDouble(fillFactorStr);
        } else {
            throw new ParseException("");
        }

        if (!checkBorder(height, width, fillFactor)) {
            throw new ParseException("");
        }

        return new StoreDataSector(height, width, fillFactor);
    }

    private boolean checkBorder(int height, int width, double fillFactor) {
        if (height < 0 || width < 0) {
            return false;
        }
        if (fillFactor < 0.0 || fillFactor > 1.0) {
            return false;
        }
        return true;
    }

    public int getValueInt(String str) throws ParseException {
        String valueStr = commandLine.getOptionValue(str);
        if (ValueUtils.checkValueInt(valueStr)) {
            return Integer.parseInt(valueStr);
        }
        throw new ParseException("");
    }
}
