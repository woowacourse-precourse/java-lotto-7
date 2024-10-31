package lotto.view;

import lotto.model.Lottos;
import lotto.model.Lotto;

public class OutputView {

    private static final String LOTTO_CNT_MSG = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS = "[%s]\n";

    public void showHowManyLotto(Lottos lottos) {
        System.out.println();
        System.out.printf(LOTTO_CNT_MSG, lottos.size());
    }

    public void showAllLottoNums(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            showLottoNums(lotto);
        }
    }

    private void showLottoNums(Lotto lotto) {
        String numbers = String.join(", ", lotto.lottoNums()
                .stream()
                .map(String::valueOf)
                .toList());
        System.out.printf(LOTTO_NUMBERS, numbers);
    }
}
