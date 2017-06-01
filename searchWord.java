import java.util.*;

public class searchWord {
    String abc; //単語の文字列をsortしたもの
    int count; //文字数
    int score; //得点

    public searchWord (String abc, int cnt, int scr) {
        this.abc = abc;
        this.count = cnt;
        this.score = scr;
    }

    public String getAbcWord() {
        return abc;
    }
    public int getCount() {
        return count;
    }
    public int getScore() {
        return score;
    }

    public int calculateScore(char[] c) {
        int scr = 0;
        for(char cha : c) {
            switch (cha) {
                case 'c':
                    scr += 2;
                    break;
                case 'f':
                    scr += 2;
                    break;
                case 'h':
                    scr += 2;
                    break;
                case 'l':
                    scr += 2;
                    break;
                case 'm':
                    scr += 2;
                    break;
                case 'p':
                    scr += 2;
                    break;
                case 'v':
                    scr += 2;
                    break;
                case 'w':
                    scr += 2;
                    break;
                case 'y':
                    scr += 2;
                    break;
                case 'j':
                    scr += 3;
                    break;
                case 'k':
                    scr += 3;
                    break;
                case 'q':
                    scr += 3;
                    break;
                case 'x':
                    scr += 3;
                    break;
                case 'z':
                    scr += 3;
                    break;
                default:
                    scr++;
                    break;
            } //switch文終了
        } //for文終了（得点計算部分）
        return scr;
    }
}
