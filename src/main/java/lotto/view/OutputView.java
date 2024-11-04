package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String INPUT_CASH_MESSAGE = "구입금액을 입력해주세요.";
    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_DETAIL_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_DETAIL_5TH_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String WINNING_DETAIL_4TH_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String WINNING_DETAIL_3TH_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String WINNING_DETAIL_2TH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String WINNING_DETAIL_1TH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public OutputView() {
    }

    public void printInputCashMessage() {
        System.out.println(INPUT_CASH_MESSAGE);
    }

    public void printLottoAmountMessage(Integer lottoAmount) {
        System.out.println(lottoAmount + LOTTO_AMOUNT_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printInputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningDetail(Integer count1st,
                                   Integer count2nd,
                                   Integer count3rd,
                                   Integer count4th,
                                   Integer count5th,
                                   Float earningRate) {
        System.out.println(WINNING_DETAIL_MESSAGE);
        System.out.printf(WINNING_DETAIL_5TH_MESSAGE, count5th);
        System.out.printf(WINNING_DETAIL_4TH_MESSAGE, count4th);
        System.out.printf(WINNING_DETAIL_3TH_MESSAGE, count3rd);
        System.out.printf(WINNING_DETAIL_2TH_MESSAGE, count2nd);
        System.out.printf(WINNING_DETAIL_1TH_MESSAGE, count1st);
        System.out.printf(EARNING_RATE_MESSAGE, earningRate);
    }
}
