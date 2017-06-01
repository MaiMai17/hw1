/* 組合せに必要なメソッドを備える */

import java.util.ArrayList;

    /*
      -------------------------------------------
      <手順>
     （1）Permutationクラスを利用して順列を作成する。
     （2）Permutationクラスで生成した順列を1つ1つ読み込む。
     （3）読み込んだ順列がユニークな組合せならばcomに保持。
      -------------------------------------------
     */

public class Combination {
    char[] c;
    int n, r, count;

    public Combination(int n, int r){
        this.n = n;
        this.r = r;
        c = new char[20];
        count = 0;
        for ( int i = 0; i < 20; i++)
             c[i] = "";
    }

    public void combine(int m) {
        if ( m <= r ) {
            for ( int i = c[m-1] + 1; i <= n-r+m; i++ ){
                c[m] = i;
                combine(m+1);
            }
        }
        else {
            count = count + 1 ;
            for ( int i = 1; i <= r; i++ ){
                System.out.print(" " + c[i]);
            }
            System.out.println();
        }
    }
}
