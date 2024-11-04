package lotto.view.output;

import java.util.List;
import lotto.model.Lotto;

public enum OutputMessageEnum {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%s개를 구매했습니다."),
    LOTTO_NUMBERS("[%s]"),
    WINNING_STATISTICS("당첨 통계"),
    STATISTICS_SEPARATOR("---"),
    MATCH_THREE("3개 일치 (5,000원) - %s개"),
    MATCH_FOUR("4개 일치 (50,000원) - %s개"),
    MATCH_FIVE("5개 일치 (1,500,000원) - %s개"),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    MATCH_SIX("6개 일치 (2,000,000,000원) - %s개"),
    TOTAL_RETURN_RATE("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print() {
        System.out.println(message);
    }

    public void printf(Object... args) {
        System.out.printf(message + "%n", args);
    }

    public String format(Object... args) {
        return String.format(message, args);
    }

    public static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto numbers : lottoNumbers) {
            LOTTO_NUMBERS.printf(numbers.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}