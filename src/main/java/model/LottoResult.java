package model;

public enum LottoResult {
    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    FAIL("낙첨", 0);

    private final String rankInformation;
    private final Integer reward;

    LottoResult(String rankInformation, Integer reward) {
        this.rankInformation = rankInformation;
        this.reward = reward;
    }

    public String getMessage() {
        String returnFormat = "%s (%,d원)";
        return String.format(returnFormat, rankInformation, reward);
    }

    public Integer getReward() {
        return reward;
    }
}
