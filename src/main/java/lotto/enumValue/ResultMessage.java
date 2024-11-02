package lotto.enumValue;

public enum ResultMessage {
    ANNOUNCE(CommonMessage.NEW_LINE.getMessange() + "당첨 통계" + CommonMessage.NEW_LINE.getMessange() + "---" + CommonMessage.NEW_LINE.getMessange()),
    FIRST("6개 일치 (2,000,000,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    FIFTH("3개 일치 (5,000원) - "),
    RESULT1("총 수익률은 "),
    RESULT2("%입니다.");

    private final String resultDescription;

    ResultMessage(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public String getDescription() {
        return resultDescription;
    }
}
