package lotto;

public enum WinningCriteria {
    FIRST_PLACE("6개 일치 (2,000,000,000원) - ", 1),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 2),
    THIRD_PLACE("5개 일치 (1,500,000원) - ", 3),
    FOURTH_PLACE("4개 일치 (50,000원) - ", 4),
    FIFTH_PLACE("3개 일치 (5,000원) - ", 5);

    WinningCriteria(String information, int code) {
        this.information = information;
        this.code = code;
    }

    private String information;
    private int code;

    public String getInformation() {
        return information;
    }

//    public WinningCriteria getWinningCriteriaToNumberOfWinning(Integer numberOfWinning) {
//
//    }
}
