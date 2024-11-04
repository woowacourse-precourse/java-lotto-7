package lotto.controller;

import lotto.dto.WinningNumberDto;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Prize;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoMachineController {
    public void start() {
        LottoMachine lottoMachine = createLottoMachine();

        OutputView.printLottoNumbers(lottoMachine.toSortedLottoStrings());

        WinningNumber winningNumber = createWinningNumber();

        WinningNumberDto winningNumberDto = winningNumber.toWinningNumberDto();
        Map<Prize, Integer> prizeCount = lottoMachine.calculateWinningCounts(winningNumberDto);
        double returnRate = lottoMachine.calculateReturnRate(prizeCount);

        OutputView.printWinningResults(prizeCount, returnRate);
    }

    // 구입 금액 입력
    private LottoMachine createLottoMachine() {
        while (true) {
            try {
                int money = InputView.inputMoney();
                return new LottoMachine(money);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage() + "\n");
            }
        }
    }

    // 당첨 번호 입력
    private Lotto createWinningLotto() {
        while (true) {
            try {
                String numbers = InputView.inputWinningNumbers();
                return Lotto.from(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력
    private WinningNumber createWinningNumber() {
        Lotto lotto = createWinningLotto();
        while (true) {
            try {
                int bonus = InputView.inputBonusNumber();
                return new WinningNumber(lotto, bonus);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
