package view;

public class Cell {

    private String state;

    public Cell(String state) {
        this.state = state;
    }

    public void setFreeCell() {
        state = " - ";
    }

    public void setBusyCell() {
        state = "|X|";
    }

    public String getState() {
        return state;
    }
}
