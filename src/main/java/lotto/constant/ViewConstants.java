package lotto.constant;

public enum ViewConstants {

    PRICE_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    BOUGHT_LOTTO_MESSAGE("개를 구매했습니다."),
    NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    WIN_RATE_MESSAGE("당첨 통계"),
    SEPARATE_LINE("---"),
    FIFTH_HIT_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_HIT_MESSAGE("4개 일치 (50,000원) - %d개"),
    THIRD_HIT_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    SECOND_HIT_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_HIT_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
    END_LINE("\n"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewConstants(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
