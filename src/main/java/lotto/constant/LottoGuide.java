package lotto.constant;

public enum LottoGuide {
    PRICE_GUIDE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    WINNING_NUMBER_GUIDE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_GUIDE("보너스 번호를 입력해 주세요.");

    private final String message;

    private LottoGuide(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}