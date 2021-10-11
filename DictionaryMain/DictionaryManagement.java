package DictionaryMain;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    //Dictionary dictionary = new Dictionary();
    public static void addWord(String addWord_target, String addWord_explain) {
        Word addWord = new Word(addWord_target, addWord_explain);
        listWord.add(addWord);
    }

    public static void showAllWords() {
        int countList = listWord.size();
        for (int i = 0; i < countList; i++) {
            System.out.println(i + 1 + "   |" + listWord.get(i).getWord_target() + "\t\t|" + listWord.get(i).getWord_explain());
        }
    }

    public static void insertFromFile() {
        try {
            File dic = new File("D:/java/Dictionary/src/Database/dictionaries.txt");
            Scanner scanner = new Scanner(dic);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                int nho = 0;
                int dem = 0;
                String addWord_target = "";
                String addWord_explain = "";
                for(int i = 2; i < word.length(); ++i) {
                    if(word.charAt(i) == '(') nho = 1;
                    if(nho == 0)  addWord_target += word.charAt(i);
                    if(dem >= 4 && (addWord_explain != "" || word.charAt(i) != ' '))
                        addWord_explain += word.charAt(i);
                    if(word.charAt(i) == '/' || word.charAt(i) == '(' || word.charAt(i) == ')') {
                        dem++;
                        if (dem == 4) i++;

                    }
                }
                if(dem == 0) System.out.println(addWord_target);
                Word addWord = new Word(addWord_target, addWord_explain);
                listWord.add(addWord);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String dictionaryLookup(String lookWord) {
        int countList = listWord.size();
        int i = 0;
        while ((i < countList)) {
            if (lookWord.equals(listWord.get(i).getWord_target())) {
                    return listWord.get(i).getWord_explain();
            } else {
                i++;
            }
        }
        return null;
    }

    public static ArrayList<String> dictionarySeacher(String word) {
        Collections.sort(listWord, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord_target().compareTo(o2.getWord_target());
            }
        });
        ArrayList<String> s = new ArrayList<>();
        int n = word.length();
        for(Word x : listWord)
            if(x.getWord_target().length() >= n){
                String x1 = x.getWord_target().substring(0, n);
                //System.out.println(x1);
                if(x1.equals(word)) {
                    s.add(x.getWord_target());
                }
            }
        return s;
    }


}
