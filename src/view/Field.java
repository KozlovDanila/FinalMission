package view;

public class Field {

    Cell[][] arrayOfState;

    public Field(int height, int width, int fillFactor) {
        arrayOfState = new Cell[height][width];
        setFieldFullFree();
        for (int fillFactorIndex = 1; fillFactorIndex <= fillFactor; fillFactorIndex++ ) {
            int heightIndex = (int) (Math.random() * height);
            int widthIndex = (int) (Math.random() * width);
            if (!getCell(heightIndex, widthIndex).getState().equals("|X|")) {
                setCell(heightIndex, widthIndex, new BusyPlace());
            } else {
                fillFactorIndex--;
            }
        }
    }

    private void setFieldFullFree() {
        for (int heightIndex = 0; heightIndex < getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < getWidthSize(); widthIndex++) {
                arrayOfState[heightIndex][widthIndex] = new Cell(new FreePlace());
            }
        }
    }

    public void setCell(int heightIndex, int widthIndex, State state) {
        arrayOfState[heightIndex][widthIndex] = new Cell(state);
    }

    public int getWidthSize() {
        return arrayOfState[0].length;
    }

    public int getHeightSize() {
        return arrayOfState.length;
    }

    public Cell getCell(int heightIndex, int widthIndex) {
        return arrayOfState[heightIndex][widthIndex];
    }

    public void print() {
        for (int heightIndex = 0; heightIndex < getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < getWidthSize(); widthIndex++) {
                System.out.print(arrayOfState[heightIndex][widthIndex].getState());
            }
            System.out.println();
        }
    }
}
