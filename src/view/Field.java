package view;

public class Field {

    Cell[][] arrayOfState;

    public Field(int height, int weight) {
        arrayOfState = new Cell[height][weight];
//        for (int heightIndex = 0; heightIndex < height; heightIndex++) {
//            for (int weightIndex = 0; weightIndex < weight; weightIndex++) {
//                if ((heightIndex + weightIndex) % 2 == 0) {
//                    arrayOfState[heightIndex][weightIndex] = new Cell(new BusyPlace());
//                } else {
//                    arrayOfState[heightIndex][weightIndex] = new Cell(new FreePlace());
//                }
//            }
//        }
    }

    public int getWeightSize() {
        return arrayOfState[0].length;
    }

    public int getHeightSize() {
        return arrayOfState.length;
    }

    public Cell getCell(int heightIndex, int weightIndex) {
        return arrayOfState[heightIndex][weightIndex];
    }

    public void print() {
        for (int heightIndex = 0; heightIndex < getHeightSize(); heightIndex++) {
            for (int weightIndex = 0; weightIndex < getWeightSize(); weightIndex++) {
                System.out.print(arrayOfState[heightIndex][weightIndex].getState());
            }
            System.out.println();
        }
    }
}
