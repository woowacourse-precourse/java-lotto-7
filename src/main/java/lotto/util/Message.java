package lotto.util;

public enum Message {
    ERROR_TAG("[ERROR]"),
    BLANK(""),
    WHITE_SPACE(" "),
    COMMA(","),
    COLON_WITH_SPACE(" : "),
    DASH("-"),
    ;

    String sentence;

    Message(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}
