package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoGame;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;



public class Controller {

    LottoGame lottoGame;

    public void run() {
        int lottoAmount = promptForLottoAmount();
        generateUserLottoTickets(lottoAmount);
        List<Integer> winningNumbers = promptForWinningNumbers();
        int bonusNumber = promptForBonusNumber();
        calculateAndDisplayResults(winningNumbers, bonusNumber);
    }

    private int promptForLottoAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return InputView.inputLottoAmount();
    }

    private void generateUserLottoTickets(int lottoAmount) {
        lottoGame = new LottoGame(lottoAmount);
        lottoGame.generateUserLotto();
        OutputView.printUserLottoNumber(lottoGame.getUserLottoList());
    }

    private List<Integer> promptForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return InputView.inputLottoWinningNumbers();
    }

    private int promptForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return InputView.inputLottoBonusNumber();
    }

    private void calculateAndDisplayResults(List<Integer> winningNumbers, int bonusNumber) {
        lottoGame.generateWinningResults(winningNumbers, bonusNumber);
    }

}
