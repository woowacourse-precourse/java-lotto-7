package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.message.ErrorMessage;
import lotto.util.Validation;
import lotto.view.InputView;

import java.util.List;

public class LottoController {


    public void play() {
        List<Lotto> Lottos = getLottos();
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumber);
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        try {
            int bonusNumber = InputView.getBonusNumber();
            if(Validation.isDuplicate(bonusNumber, winningNumber)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_PRESENT.getErrorMessage());
            }
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }

    private List<Lotto> getLottos() {
        try {
            int price = InputView.getPrice();
            return LottoStore.purchaseLotto(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos();
        }

    }

    private List<Integer> getWinningNumber() {
        try {
            return InputView.getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }
}
