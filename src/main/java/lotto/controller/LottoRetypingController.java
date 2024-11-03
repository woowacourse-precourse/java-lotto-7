package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.dto.WinningLottoDTO;
import lotto.model.LottoBonusNumber;
import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoRetypingController {

    private final InputView inputView;

    public LottoRetypingController(InputView inputView) {
        this.inputView = inputView;
    }

    public Long retypeSingleInput(Supplier<Long> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto retypeLottoNumberInput(Supplier<List<Integer>> input) {
        while (true) {
            try {
                return new Lotto(input.get());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLottoDTO retypeWinningCondition() {
        Lotto winningNumbers = retypeLottoNumberInput(inputView::inputWinningNumbers);

        while (true) {
            try {
                Long extraLottoNumber = retypeSingleInput(inputView::inputBonusNumber);
                LottoBonusNumber bonusNumber = new LottoBonusNumber(winningNumbers, extraLottoNumber.intValue());
                return new WinningLottoDTO(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
