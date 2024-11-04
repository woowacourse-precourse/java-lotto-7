package lotto.contants.message;

public enum NoticeMessage {
    PAYMENT("구입금액을 입력해 주세요."),
    CONUT_BUY("개를 구매했습니다."),
    PRIZE_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    TOTAL("\n당첨 통계\n---"),
    RANK_FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    RANK_SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK_THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    RANK_FOURTH_PRIZE("4개 일치 (50,000원) - "),
    RANK_FIFTH_PRIZE("3개 일치 (5,000원) - ");

    private final String message;

    NoticeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
