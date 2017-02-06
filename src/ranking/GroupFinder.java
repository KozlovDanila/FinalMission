package ranking;

import view.Field;

import java.util.HashMap;

public class GroupFinder {

    private Field field;

    public GroupFinder(Field field) {
        this.field = field.clone();
    }

    public HashMap<Group, Integer> find() {
        HashMap<Group, Integer> group = new HashMap<>();
        int countGroup = 0;
        for (Group elementGroup : Group.values()) {
            group.put(elementGroup, countGroup);
        }
        return findGroup(group);
    }

    private HashMap<Group, Integer> findGroup(HashMap<Group, Integer> group) {

        for (int heightIndex = 0; heightIndex < field.getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < field.getWidthSize(); widthIndex++) {
                if (field.getCell(heightIndex, widthIndex).getState().equals("|X|")) {
                    int sizeOfGroup = findSizeGroup(heightIndex, widthIndex);
                    putGroup(sizeOfGroup, group);
                }
            }
        }
        return group;
    }

    private int findSizeGroup(int heightIndex, int widthIndex) {
        int size = 0;
        boolean nonArrayHeightIndex = checkToBeInArray(heightIndex, field.getHeightSize());
        boolean nonArrayWidthIndex = checkToBeInArray(widthIndex, field.getWidthSize());
        if (nonArrayHeightIndex && nonArrayWidthIndex) {
            if (field.getCell(heightIndex, widthIndex).getState().equals("|X|")) {
                size++;
                field.getCell(heightIndex, widthIndex).setFreeCell();
                size += findSizeGroup(heightIndex, widthIndex + 1);
                size += findSizeGroup(heightIndex + 1, widthIndex);
                size += findSizeGroup(heightIndex, widthIndex - 1);
                size += findSizeGroup(heightIndex - 1, widthIndex + 1);
            }
        }
        return size;
    }

    private boolean checkToBeInArray(int currentIndex, int borderArray) {
        return currentIndex >= 0 && currentIndex < borderArray;
    }


    private void putGroup(int sizeOfGroup, HashMap<Group, Integer> group) {
        Group[] groups = Group.values();
        for (Group element : groups) {
            if (element.getMaxSize() >= sizeOfGroup) {
                group.put(element, group.get(element) + 1);
                return;
            }
        }
    }
}