package laba_5.matrix;

public class UsualMatrix implements  IMatrix{
    protected final int rows;
    protected final int columns;
    protected final int[][] data;

    public UsualMatrix(int row, int col) {
        this.rows = row;
        this.columns = col;
        this.data = new int [row][col];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++)
                sb.append("[" + this.getElement(i, j) + "]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public IMatrix product(IMatrix m) {
        IMatrix res = new UsualMatrix(this.rows, m.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                for (int k = 0; k < this.columns; k++)
                    res.setElement(i, j, res.getElement(i, j) + (this.getElement(i, k) * m.getElement(k, j)));
            }
        }
        return res;
    }

    public IMatrix sum(IMatrix m) {
        IMatrix res = new UsualMatrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.columns; j++)
                res.setElement(i, j, this.getElement(i, j) + m.getElement(i, j));
        return res;
    }


    public void setElement(int row, int col, int value) {
        this.data[row][col] = value;
    }

    public int getElement(int row, int col) {
        return this.data[row][col];
    }

    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }

    public final boolean equals(Object o){
        if(!(o instanceof IMatrix))
            return false;
        IMatrix matrix = (IMatrix) o;
        if(matrix.getColumns() != this.getColumns() & matrix.getRows() != this.getRows())
            return false;
        for(int i = 0; i < this.getRows(); i++)
            for(int j = 0; j < this.getColumns(); j++){
                if(!(this.getElement(i, j) == matrix.getElement(i, j)))
                    return false;
            }
        return true;
    }

}