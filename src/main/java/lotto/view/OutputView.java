package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private final static String LOTTO_COUNT_STRING = "개를 구매했습니다.";
    private final static String WINNING_STATISTIC_STRING = "당첨 통계\n---";

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_STRING);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    // winning 통계 보여주는 메소드
    // 수익률 보여주는 메소드
}
