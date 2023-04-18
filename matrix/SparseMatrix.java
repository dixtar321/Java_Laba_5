package laba_5.matrix;
import java.util.LinkedList;
import java.util.ListIterator;

public class SparseMatrix implements IMatrix{

    private static class Node{
        private final int rowIdx;
        private final int colIdx;
        private int val;

        public Node(int row, int col, int value){
            this.rowIdx = row;
            this.colIdx = col;
            this.val = value;
        }

    }

    private final int rows;
    private final int columns;
    private final LinkedList<Node> data = new LinkedList<>();

    public SparseMatrix(int row, int col){
        this.rows = row;
        this.columns = col;
    }

    public void setElement(int row, int col, int val){
        ListIterator<Node> it = this.data.listIterator();

        while(it.hasNext()){
            Node cur = (Node)it.next();
            if(cur.rowIdx == row & cur.colIdx == col) {
                it.previous().val = val;
                return;
            }
        }
        this.data.add(new Node(row, col, val));
    }

    public int getElement(int row, int col){
        ListIterator<Node> it = this.data.listIterator();

        while(it.hasNext()){
            Node cur = (Node)it.next();
            if(cur.rowIdx == row & cur.colIdx == col)
                return cur.val;
        }
        return 0;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++)
                sb.append("[" + this.getElement(i, j) + "]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public IMatrix product(IMatrix m){
        int resVal = 0;
        IMatrix res = new SparseMatrix(this.rows, m.getColumns());

        // for(Node node : this.data){
        //     for(int j = 0; j < this.columns; j++){
        //         int sum = result.getElement(node.rowIdx, j) + node.value * data.getElement(node.colIdx, j);
        //         result.setElement(node.rowIdx, sum, resVal);
        //     }
        // }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    resVal += this.getElement(i, k) * m.getElement(k, j);
                }
                res.setElement(i, j, resVal);
                resVal = 0;
            }
        }
        return res;
    }

    public int getRows(){return this.rows;}
    public int getColumns(){return this.columns;}

    public IMatrix sum(IMatrix m){
        IMatrix res = new SparseMatrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.columns; j++) {
                int elem1 = this.getElement(i, j);
                int elem2 = m.getElement(i, j);
                if(elem1 != 0 & elem2 != 0)
                    res.setElement(i, j, elem1 + elem2);
            }
        return res;
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