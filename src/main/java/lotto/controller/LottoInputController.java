package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.dto.WinningLottoDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoInputController {

    private final InputView inputView;

    public LottoInputController(InputView inputView) {
        this.inputView = inputView;
    }

    public Integer inputSingleValue(Supplier<Integer> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLottoDTO inputWinningCondition() {
        Lotto winningNumbers = inputLottoNumbers(inputView::inputWinningNumbers);
        while (true) {
            try {
                Integer bonusNumber = inputSingleValue(inputView::inputBonusNumber);
                return new WinningLottoDTO(winningNumbers, new BonusNumber(winningNumbers, bonusNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputLottoNumbers(Supplier<List<Integer>> input) {
        while (true) {
            try {
                return new Lotto(input.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
