package lotto.Controller;

import java.util.List;
import lotto.Domain.LottoGame;
import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
import lotto.Domain.PurchaseAmount;
import lotto.Domain.WinningNumbers;
import lotto.Utils.Formatter;
import lotto.Utils.UserInput;
import lotto.View.OutputView;

public class LottoGameController {
    private final UserInput userInput;
    private LottoGame game;

    public LottoGameController() {
        userInput = new UserInput();
    }

    public void run() {
        ready();
        draw();
    }

    private void ready() {
        game = LottoGame.create();
        Lottos issuedLottos;
        while (true) {
            try {
                String amountInput = userInput.purchaseAmount();
                PurchaseAmount amount = PurchaseAmount.from(amountInput);
                LottoMachine machine = LottoMachine.create();
                issuedLottos = machine.buyLottos(amount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        game.setIssuedLottos(issuedLottos);

        OutputView.printMessage();

        String result = Formatter.formatLottoCount(issuedLottos);
        OutputView.printMessage(result);

        List<String> lottoResult = Formatter.formatLottos(issuedLottos);
        OutputView.printMessages(lottoResult);
    }

    private void draw() {
        OutputView.printMessage();
        WinningNumbers winningNumbers = WinningNumbers.create();
        while (true) {
            try {
                String winningNumbersInput = userInput.winningNumbers();
                winningNumbers.registerMainNumbers(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }

        OutputView.printMessage();

        String bonusNumberInput = userInput.bonusNumber();
        winningNumbers.registerBonus(bonusNumberInput);

        game.setWinningNumbers(winningNumbers);
    }

}