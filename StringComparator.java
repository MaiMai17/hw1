import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(String s1, String s2) {

        return s1.compareTo(s2);
    }
}
