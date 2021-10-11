package DictionaryMain;

public class Word {
    private String word_target;
    private String word_explain;

    public Word(String word_target_, String word_explain_) {
        word_target = word_target_;
        word_explain = word_explain_;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }
    public int compareTo(Word x) {
        return this.getWord_explain().compareTo(x.getWord_explain());
    }
}
