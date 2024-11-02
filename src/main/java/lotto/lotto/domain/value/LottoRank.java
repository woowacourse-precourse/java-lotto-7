package lotto.lotto.domain.value;

public enum LottoRank {

    FAIL(0, null,null, 0),
    MATCHED3(3, "5,000원", "3개 일치",5000),
    MATCHED4(4, "50,000원", "4개 일치",50000),
    MATCHED5(5, "1,500,000원", "5개 일치",1500000),
    MATCHED5_BONUS(5, "30,000,000원", "5개 일치, 보너스 볼 일치",30000000),
    MATCHED6(6, "2,000,000,000원", "6개 일치",2000000000);

    private final int matchCount;
    private final String valueMessage;
    private final String conditionMessage;
    private final long value;

    LottoRank(int matchCount, String valueMessage, String conditionMessage, long value) {
        this.matchCount = matchCount;
        this.valueMessage = valueMessage;
        this.conditionMessage = conditionMessage;
        this.value = value;
    }

    public String getValueMessage() {
        return valueMessage;
    }

    public long getValue() {
        return value;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getConditionMessage() {return conditionMessage;}
}
