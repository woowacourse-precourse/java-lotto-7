package lotto.controller;

import lotto.dto.WinningNumberDto;
import lotto.model.LottoMachine;
import lotto.model.Prize;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoMachineController {
    public void start() {
        LottoMachine lottoMachine = createLottoMachine();

        OutputView.printLottoNumbers(lottoMachine.displayLottos());

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

    // 당첨 번호 및 보너스 번호 입력
    private WinningNumber createWinningNumber() {
        while (true) {
            try {
                String numbers = InputView.inputWinningNumbers();
                int bonus = InputView.inputBonusNumber();
                return new WinningNumber(numbers, bonus);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
