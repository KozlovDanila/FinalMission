package parserArgs;

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


    public InputData getData() throws ParseException, NumberFormatException {
        int height = Integer.parseInt(commandLine.getOptionValue("height"));
        int width = Integer.parseInt(commandLine.getOptionValue("width"));
        double fillFactor = Double.parseDouble(commandLine.getOptionValue("fillFactor"));

        if (!checkCorrectData(height, width, fillFactor)) {
            throw new NumberFormatException();
        }

        return new InputData(height, width, fillFactor);
    }

    private boolean checkCorrectData(int height, int width, double fillFactor) {
        if (checkValueLessThanZero(height) || checkValueLessThanZero(width)) {
            return false;
        }
        if (checkCorrectFillFactor(fillFactor)) {
            return false;
        }
        return true;
    }

    private boolean checkValueLessThanZero(int value) {
        return value < 0;
    }

    private boolean checkCorrectFillFactor(double fillFactor) {
        return fillFactor < 0 || fillFactor > 1.0 ;
    }
}
