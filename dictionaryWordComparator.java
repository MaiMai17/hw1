import java.util.Comparator;

public class dictionaryWordComparator implements Comparator<dictionaryWord> {
    //比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
    public int compare(dictionaryWord dw1, dictionaryWord dw2) {
        String s1 = dw1.getAbcWord();
        String s2 = dw2.getAbcWord();

        return s1.compareTo(s2);
    }
}
