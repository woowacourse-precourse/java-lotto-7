package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = getMoney();
        Lotto lottoWinningNumbers = getLottoWinningNumbers();
        int lottoBonusNumber = getLottoBonusNumber();

    }

    private int getMoney() {
        while (true) {
            try {
                outputView.showMoneyInputComments();
                return inputView.getMoneyFromUser();

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getLottoWinningNumbers() {
        while (true) {
            try {
                outputView.showLottoWinningNumbersInputComments();
                return inputView.getLottoWinningNumbersFromUser();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getLottoBonusNumber() {
        while (true) {
            try {
                outputView.showLottoBonusNumberInputComments();
                return inputView.getLottoBonusNumberFromUser();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
