package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class OutputView {
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void renderErrorMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }

    public void renderNewLine() {
        System.out.println();
    }

    public void renderGeneratedLottos(final LottoGame lottoGame) {
        renderNewLine();
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, lottoGame.getLottoCount());
        renderNewLine();
        lottoGame.getGeneratedLottos().forEach(this::renderLotto);
    }

    public void renderLotto(final Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

}
