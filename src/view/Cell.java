package view;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public String getState() {
        return state.getState();
    }
}
