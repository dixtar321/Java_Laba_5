package laba_5.matrix;

public class SquareMatrix extends UsualMatrix {

    public SquareMatrix(int size) {
        super(size, size);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j)
                    data[i][j] = 1;
            }
        }
    }
}