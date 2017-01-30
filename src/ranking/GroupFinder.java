package ranking;

import view.Field;
import view.FreePlace;

public class GroupFinder {

    private Field field;

    public GroupFinder(Field field) {
        this.field = field.clone();
    }

    public Group[] findGroup() {
        Group[] group = Group.values();

        for (int heightIndex = 0; heightIndex < field.getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < field.getWidthSize(); widthIndex++) {
                if (field.getCell(heightIndex, widthIndex).getValueState() == "|X|") {
                    int sizeOfGroup = findSizeGroup(heightIndex, widthIndex);
                    putGroup(sizeOfGroup, group);
                }
            }
        }
        return group;
    }


    private int findSizeGroup(int heightIndex, int widthIndex) {
        int size = 0;
        if ((heightIndex >= 0 && heightIndex < field.getHeightSize()) && (widthIndex >= 0 && widthIndex < field.getWidthSize())) {
            if (field.getCell(heightIndex, widthIndex).getValueState() == "|X|") {
                size++;
                field.setCell(heightIndex, widthIndex, new FreePlace());
                size += findSizeGroup(heightIndex, widthIndex + 1);
                size += findSizeGroup(heightIndex + 1, widthIndex);
                size += findSizeGroup(heightIndex, widthIndex - 1);
                size += findSizeGroup(heightIndex - 1, widthIndex + 1);
            }
        }
        return size;
    }


    private void putGroup(int sizeOfGroup, Group[] group) {
        int indexGroup = 0;
        while (group[indexGroup].getMaxCount() < sizeOfGroup && indexGroup < group.length) {
            indexGroup++;
        }
        group[indexGroup].increaseCount();
    }
}