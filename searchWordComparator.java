import java.util.*;

public class searchWordComparator implements Comparator<searchWord> {
    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(searchWord sw1, searchWord sw2) {
        String s1 = sw1.getAbcWord();
        String s2 = sw2.getAbcWord();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        //得点を計算する（この得点にしたがって降順に並べる）
        int scr1 = sw1.calculateScore(c1);
        int scr2 = sw2.calculateScore(c2);

        //得点が同じ時は長い単語の方を優先させる
        int cnt1 = s1.length();
        int cnt2 = s2.length();

        if (scr1 < scr2) {
            return 1;
        } else if (scr1 == scr2) {
            if(cnt1 < cnt2) {
                return 1;
            } else if (cnt1 == cnt2) {
                return 0;
            } else {
              return -1;
            }
        } else {
            return -1;
        }
    }
}
