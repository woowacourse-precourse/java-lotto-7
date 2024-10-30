package lotto.controller;

import static lotto.util.validator.LottoNumberValidator.validateDuplicated;

import lotto.dto.WinningLottoDTO;
import lotto.model.Lotto;
import lotto.view.InputView;

public class InputController {

    public static WinningLottoDTO inputWinningLotto(InputView inputView) {
        while (true) {
            try {
                Lotto lottoNumber = new Lotto(inputView.inputMultipleInteger(inputView::inputWinningNumbers));
                Integer bonusNumber = inputView.inputSingleInteger(inputView::inputBonusNumber);
                validateDuplicated(lottoNumber, bonusNumber);
                return new WinningLottoDTO(lottoNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
