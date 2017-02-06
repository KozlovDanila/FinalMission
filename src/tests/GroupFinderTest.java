package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ranking.Group;
import ranking.GroupFinder;
import view.Field;

import java.util.HashMap;

public class GroupFinderTest {

    public Field createField() {
        Field field = new Field(4,4);
        field.getCell(0,0).setBusyCell();
        field.getCell(0,1).setBusyCell();
        field.getCell(1,0).setBusyCell();
        field.getCell(3,3).setBusyCell();
        field.getCell(3,0).setBusyCell();
        field.getCell(3,1).setBusyCell();
        field.getCell(2,1).setBusyCell();
        field.getCell(0,3).setBusyCell();
        return field;
    }

    public HashMap<Group, Integer> createMap() {
        HashMap<Group, Integer> group = new HashMap<>();
        group.put(Group.MINOR, 2);
        group.put(Group.NONE, 2);
        group.put(Group.CRITICAL, 0);
        group.put(Group.MAJOR, 0);
        group.put(Group.NORMAL, 0);
        return group;
    }


    @Test
    public void checkFindGroup() {
        Field field = createField();
        HashMap<Group, Integer> group = createMap();
        GroupFinder finder = new GroupFinder(field);
        Assert.assertEquals(finder.find(), group);
    }

}