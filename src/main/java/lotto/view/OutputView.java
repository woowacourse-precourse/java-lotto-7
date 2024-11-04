package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private static final String INPUT_PAY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_COUNT_VIEWPOINT = "개를 구매했습니다.";
    private static final String LOTTO_STATISTICS_TITLE = "당첨 통계";
    private static final String LOTTO_STATISTICS_SEPARATOR = "---";
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void requestInputPayMoney() {
        System.out.println(INPUT_PAY_MONEY);
    }

    public void requestInputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
    }

    public void requestInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printLottoCount(Integer lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_VIEWPOINT);
    }
    public void printPurchasedLotto(List<Lotto> lottoTickets){
        for (Lotto lottoNumbers : lottoTickets) {
            System.out.println(lottoNumbers.getNumbers());
        }
    }

    public void printLottoStatistics(List<Integer> statistics, double profitRate) {
        System.out.println(LOTTO_STATISTICS_TITLE);
        System.out.println(LOTTO_STATISTICS_SEPARATOR);

        System.out.printf("3개 일치 (5,000원) - %d개%n", statistics.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", statistics.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", statistics.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", statistics.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", statistics.get(4));

        System.out.printf(TOTAL_PROFIT_RATE + "%n", profitRate);
    }


}
