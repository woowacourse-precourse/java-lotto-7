package lotto;

public enum MatchCount {
    NOT_MATCH("0"),
    THREE_MATCH("5000"),
    FOUR_MATCH("50000"),
    FIVE_MATCH("1500000"),
    FIVE_MATCH_WITH_BONUS_NUMBER("30000000"),
    SIX_MATCH("2000000000");
    private final String winningMoney;

    MatchCount(String money){
        this.winningMoney = money;
    }
    String getMoney(){
        return winningMoney;
    }
}
