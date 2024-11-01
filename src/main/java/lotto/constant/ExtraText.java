package lotto.constant;

public enum ExtraText {
    WINNING_NUMBER_SEPARATOR(","),
    NEW_LINE("\n");
    private String text;

    ExtraText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
