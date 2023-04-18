package laba_5;
import matrix.IMatrix;
import matrix.SparseMatrix;
import matrix.UsualMatrix;
import graph.IGraph;
import graph.adjactive_matrix;
import graph.adjactive_list;

public class Main{

    public static void main(String[] args) {
        int size = 1000;
        UsualMatrix u1 = new UsualMatrix(size, size);
        UsualMatrix u2 = new UsualMatrix(size, size);
        SparseMatrix sm1 = new SparseMatrix(size, size);
        SparseMatrix sm2 = new SparseMatrix(size, size);


        for (int i = 0; i < size; i++) {
           int firstTmpI = (int) ((Math.random() * (size) + 0));
           int firstTmpJ = (int) ((Math.random() * (size) + 0));
            int firstTmpVal = (int) ((Math.random() * (9) + 1));
            u1.setElement(firstTmpI, firstTmpJ, firstTmpVal);
            sm1.setElement(firstTmpI, firstTmpJ, firstTmpVal);
        }

        for (int i = 0; i < size; i++) {
            int firstTmpI = (int) ((Math.random() * (size) + 0));
            int firstTmpJ = (int) ((Math.random() * (size) + 0));
            int firstTmpVal = (int) ((Math.random() * (9) + 1));
            u2.setElement(firstTmpI, firstTmpJ, firstTmpVal);
            sm2.setElement(firstTmpI, firstTmpJ, firstTmpVal);
            
        }

       // IMatrix res1 = u1.product(u2);
       // IMatrix res2 = sm1.product(sm2);
        //System.out.println(u1);
        //System.out.println(sm1);
        System.out.println(u1.equals(sm1));
        System.out.println(u2.equals(sm2));
        //System.out.println(res1.equals(res2));

        adjactive_matrix dop_m1 = new adjactive_matrix(5);
        System.out.println(dop_m1);
    }
}