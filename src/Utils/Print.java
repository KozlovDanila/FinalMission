package utils;

import ranking.Group;
import view.Field;

public final class Print {

    public Print() {
    }

    public static void printResult(Field field, double fillFactor, Group[] group) {

        System.out.println("Size of Field:\n|---------------------------------------------------------|");
        System.out.println(printSizeField(field));

        System.out.println("Fill Factor:\n|-----------------------------------------------------------|");
        System.out.println(fillFactor + "\n");

        System.out.println("Degrees of Risk:\n|-------------------------------------------------------|");
        System.out.println(printDegreesRisk(group));

        System.out.println("Field:\n|-----------------------------------------------------------------|");
        System.out.println(printField(field));

        System.out.println("Group of Risk: \n|--------------------------------------------------------|");
        System.out.println(printGroup(group));
    }


    public static String printField(Field field) {
        String fieldStr = "";
        for (int heightIndex = 0; heightIndex < field.getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < field.getWidthSize(); widthIndex++) {
                fieldStr += field.getCell(heightIndex, widthIndex).getValueState();
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

    public static String printDegreesRisk(Group[] group) {

        String groupStr = "";
        for (Group element : group) {
            groupStr += element.name() + " = " + element.getMaxCount() + "\n";
        }
        return groupStr + "\n";
    }

    public static String printGroup(Group[] group) {
        String groupStr = "";
        for (Group element : group) {
            groupStr += element.name() + " = " + element.getCount() + "\n";
        }
        return groupStr + "\n";
    }

}
