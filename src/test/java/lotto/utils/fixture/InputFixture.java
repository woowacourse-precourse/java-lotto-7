package lotto.utils.fixture;

public enum InputFixture {
    VALID_RAW_PURCHASE_AMOUNT("10000")
    , VALID_RAW_WINNING_NUMBERS("1,2,3,4,5,6")
    , VALID_RAW_BONUS_NUMBER("10")
    ,;


    private final String input;
    InputFixture(String input) {
        this.input = input;
    }
    public String getInput() {
        return input;
    }

}
