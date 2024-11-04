package lotto;

public enum EnumValue {
    // NO_CORRECT(0, 0, false,"0개 일치"),
    ATHREE_CORRECT(3, 5000, false, "3개 일치", "5,000"),
    BFOUR_CORRECT(4, 50000, false, "4개 일치", "50,000"),
    CFIVE_CORRECT(5, 1500000, false, "5개 일치", "1,500,000"),
    DFIVE_CORRECT_BONUS(5, 30000000, true, "5개 일치, 보너스 볼 일치", "30,000,000"),
    ESIX_CORRECT(6, 2000000000, false, "6개 일치", "2,000,000,000");
    private final int matchCount;     // 일치하는 번호 개수
    private final boolean bonusMatch; // 보너스 번호 일치 여부
    private final int winMoney;          // 당첨 금액

    private final String winMoneyStr;

    private final String tag;

    EnumValue(int matchCount, int winMoney, boolean bonusMatch, String tag, String moneyStr) {
        this.matchCount = matchCount;
        this.winMoney = winMoney;
        this.bonusMatch = bonusMatch;
        this.tag = tag;
        this.winMoneyStr = moneyStr;
    }

    public int getMoney() {
        return winMoney;
    }

    public String getMoneyStr() {
        return winMoneyStr;
    }

    public String getTag() {
        return tag;
    }


    public static String winningResult(boolean hasBonus, int correctNum) {
        for (EnumValue value : values()) {
            if (value.bonusMatch == hasBonus && value.matchCount == correctNum) {
                return value.name();
            }
        }
        return "NO_CORRECT";
    }

}



