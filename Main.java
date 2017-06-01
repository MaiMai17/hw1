import java.io.*;
import java.util.*;

//辞書データを読み込み、ゲーム用の辞書配列を作る

public class Main {
    public static void main(String args[]) {
        try{
        File readFile = new File("dictionary.words");
        FileInputStream fis = new FileInputStream(readFile);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String str,str2,str3;
        char[] c;

        //単語に関する様々なデータの入るHashMap(単語の長さごとのArrayList)
        HashMap<String, ArrayList<dictionaryWord>> hashBag = new HashMap<String, ArrayList<dictionaryWord>>();

        while((str = br.readLine()) != null) { //辞書を一行ずつ読み、整理していく
            int wordlen = str.length();
            if(wordlen <= 16) { //文字の長さが16文字以下であれば、ゲームに使える単語として以下の処理を行う
                //小文字にする
                str2 = str.toLowerCase();

                //単語の中の文字をsort
                str = str2;
                c = str.toCharArray();
                Arrays.sort(c);
                str = new String(c);

                //文字列の長さをString型に変換
                str3 = String.valueOf(wordlen);
                HashBag_add(hashBag, str3, new dictionaryWord(str2, str)); //HashMapに挿入
            } //if文終了（16文字以下の処理のところ）
        } //while文終了（元の辞書の探索終了）

        //WordsComparatorクラスの条件に従いソートする(文字列の長さごとのArrayList)
        for(int i = 3; i <= 16; i++) {
            Collections.sort(hashBag.get(String.valueOf(i)), new dictionaryWordComparator());
        }
        /*
        for(int i = 0; i < 30; i++) {
            System.out.print(hashBag.get("8").get(i).original);
            System.out.print(" ");
            System.out.println(hashBag.get("8").get(i).abc);
        }
        */
        br.close();
        isr.close();
        fis.close();

        int j = 0;
        while(j < 10) { //ようやくゲームスタート

            //文字列を受け取る
            System.out.print("Enter Symbols : ");
            Scanner scan = new Scanner(System.in);
            String scanS = scan.next();

            //受け取った文字列をソート
            c = scanS.toCharArray();
            Arrays.sort(c);
            str = new String(c);
            str = str.toLowerCase();
            int len = str.length();

            //探索する文字列のリスト(array)を用意し、得点が高い順に並べ直す
            List<String> list = new ArrayList<>();
            for(int i = 3; i <= len; i++) {
                Combination(str, "", i, list);
            }
            Set<String> set = new HashSet<>(list);
            List<String> list2 = new ArrayList<>(set);
            ArrayList<searchWord> array = new ArrayList<>();
            for(int i = 0; i < list2.size(); i++) {
                array.add(new searchWord(list2.get(i), list2.get(i).length(), 0));
            }
            Collections.sort(array, new searchWordComparator());

            //遂に探索
            for(int i = 0; i <= array.size(); i++) {
                String sword = array.get(i).abc;
                int swordlen = sword.length();
                ArrayList<String> al = new ArrayList<>();
                int alsize = hashBag.get(String.valueOf(swordlen)).size();
                for(int k = 0; k < alsize; k++) {
                    al.add(hashBag.get(String.valueOf(swordlen)).get(k).abc);
                }
                int ret = Collections.binarySearch(al, sword);
                if(ret >= 0) {
                    System.out.print("Answer word : ");
                    System.out.println(hashBag.get(String.valueOf(swordlen)).get(ret).original);
                    break;
                }
            }
            j++;
        }
    }catch(IOException e){
        System.out.println(e);
    }
    }

    public static void HashBag_add(HashMap<String, ArrayList<dictionaryWord>> hashBag, String key, dictionaryWord value) {
        ArrayList<dictionaryWord> valueList = hashBag.get(key);
        if (valueList == null) {
            valueList = new ArrayList<dictionaryWord>();
        }
        valueList.add(value);
        hashBag.put(key, valueList);
    }

    public static void Combination(String q, String ans, int k, List<String> l){ //Combination
        // Base Case
        if(ans.length() == k) {
            l.add(ans);
        }
        // General Case
        else {
            while (q.length() > 0) {
                Combination(q.substring(1), ans + q.charAt(0), k, l);
                q = q.substring(1);
            }
        }
    }
}
