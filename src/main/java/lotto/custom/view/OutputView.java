package lotto.custom.view;

import lotto.custom.model.Lotto;
import lotto.custom.model.Lottos;

public class OutputView {
    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void displayLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + PromptMessages.DISPLAY_LOTTO_COUNT_PROMPT);
    }

    public void displayLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}