package lotto.constant;

public enum LottoGuide {
    PRICE_GUIDE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    WINNING_NUMBER_GUIDE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_GUIDE("보너스 번호를 입력해 주세요."),
    RESULT_GUIDE("당첨 통계"),
    LINE_SEPARATOR("---"),
    RESULT_FIFTH("3개 일치 (5,000원) - %d개\n"),
    RESULT_FOURTH("4개 일치 (50,000원) - %d개\n"),
    RESULT_THIRD("5개 일치 (1,500,000원) - %d개\n"),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    RESULT_FIRST("6개 일치 (2,000,000,000원) - %d개\n");

    private final String message;

    private LottoGuide(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}