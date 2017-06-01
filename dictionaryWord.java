import java.util.*;

public class dictionaryWord {
    String original; //元の単語
    String abc; //単語の文字列をsortしたもの

    public dictionaryWord (String original, String abc) {
        this.original = original;
        this.abc = abc;
    }

    public String getOriginalwords() {
        return original;
    }
    public String getAbcWord() {
        return abc;
    }
}
