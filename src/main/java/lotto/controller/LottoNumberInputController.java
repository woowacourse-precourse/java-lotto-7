package lotto.controller;

import lotto.dto.WinningLottoDTO;
import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoNumberInputController {

    public static WinningLottoDTO inputWinningLotto(InputView inputView) {
        while (true) {
            try {
                Lotto winningLottoNumbers = new Lotto(inputView.inputMultipleInteger(inputView::inputWinningNumbers));
                Integer bonusNumber = inputView.inputSingleInteger(inputView::inputBonusNumber);

                return new WinningLottoDTO(winningLottoNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
