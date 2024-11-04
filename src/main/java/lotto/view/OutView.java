package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.enums.Prize;

public class OutView {
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNIG_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PRIZE_COUNT_MESSAGE = "당첨 통계\n---\n";
    private static final String FIFTH_PRIZE_FORMAT = "3개 일치 (5,000원) - %d개\n";
    private static final String FORTH_PRIZE_FORMAT = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PRIZE_FORMAT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PRIZE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PRIZE_FORMAT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String EARN_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";


    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + " : " + errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printLottoCount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_COUNT_MESSAGE);
    }

    public void printWinningNumberInputMessage() {
        System.out.println();
        System.out.println(WINNIG_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoResult(Map<Prize, Long> lottoResult) {
        System.out.println();
        System.out.printf(PRIZE_COUNT_MESSAGE);
        System.out.printf(FIFTH_PRIZE_FORMAT, lottoResult.get(Prize.FIFTH));
        System.out.printf(FORTH_PRIZE_FORMAT, lottoResult.get(Prize.FOURTH));
        System.out.printf(THIRD_PRIZE_FORMAT, lottoResult.get(Prize.THIRD));
        System.out.printf(SECOND_PRIZE_FORMAT, lottoResult.get(Prize.SECOND));
        System.out.printf(FIRST_PRIZE_FORMAT, lottoResult.get(Prize.FIRST));

    }

    public void printEarnRate(double earnRate) {
        System.out.printf(EARN_RATE_FORMAT, earnRate);
    }
}
