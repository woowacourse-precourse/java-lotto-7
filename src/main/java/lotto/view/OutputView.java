package lotto.view;


import lotto.domain.Lotties;
import lotto.domain.Lotto;

public class OutputView {
    private static final String OUTPUT_NUM_OF_LOTTO = "개를 구매했습니다.";

    public void printNumberOfLotto(long size) {
        System.out.println(size + OUTPUT_NUM_OF_LOTTO);
    }

    public void printLotties(Lotties lotties) {
        for (Lotto lotto : lotties.getLottoTickets()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }
}
