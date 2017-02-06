package utils;

import ranking.Group;
import view.Field;

import java.util.HashMap;
import java.util.Map;

public final class Printer {

    public Printer() {
    }

    public static void printResult(Field field, double fillFactor, HashMap<Group, Integer> group) {

        String spaces = "|---------------------------------------------------------|";

        System.out.println("Size of Field:\n" + spaces);
        System.out.println(printSizeField(field));

        System.out.println("Fill Factor:\n" + spaces);
        System.out.println(fillFactor + "\n");

        System.out.println("Degrees of Risk:\n" + spaces);
        System.out.println(printDegreesRisk());

        System.out.println("Field:\n" + spaces);
        System.out.println(printField(field));

        System.out.println("Group of Risk: \n" + spaces);
        System.out.println(printGroup(group));
    }


    public static String printField(Field field) {
        String fieldStr = "";
        for (int heightIndex = 0; heightIndex < field.getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < field.getWidthSize(); widthIndex++) {
                fieldStr += field.getCell(heightIndex, widthIndex).getState();
            }
            fieldStr += "\n";
        }
        return fieldStr;
    }

    public static String printSizeField(Field field) {
        String sizeStr = "";
        sizeStr += "height = " + field.getHeightSize() + "\n";
        sizeStr += "width = " + field.getWidthSize() + "\n";
        return sizeStr;
    }

    public static String printDegreesRisk() {
        String groupStr = "";
        for (Group element : Group.values()) {
            groupStr += element.name() + " = " + element.getMaxSize() + "\n";
        }
        return groupStr + "\n";
    }

    public static String printGroup(HashMap<Group, Integer> group) {
        String groupStr = "";
        for (Map.Entry entry: group.entrySet()){
            groupStr += entry.getKey() + " = " +  entry.getValue() + "\n";
        }

        return groupStr + "\n";
    }

    public static String printDemand() {
        return "Enter: -h value -w value -f value\n" +
                "h - height(integer), w - width(integer), f - fill factor(floating point)";
    }

}
