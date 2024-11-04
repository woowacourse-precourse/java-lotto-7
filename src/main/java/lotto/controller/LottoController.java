package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.exceptions.ArgumentException;
import lotto.model.DrawingLotto;
import lotto.model.LottoNumber;
import lotto.model.Money;
import lotto.model.Quantity;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OuputView;

public class LottoController {
    private final InputView inputView = InputView.getInstance();
    private final OuputView ouputView = OuputView.getInstance();

    public void run() {
        int userMoney = inputMoney();
        Money money = Money.createMoney(userMoney);

        Quantity quantity = Quantity.from(money);
        List<LottoNumber> drawingLotto = DrawingLotto.createDrawingLotto(quantity);

        ouputView.printQuantityResult(quantity.getQuantity());
        ouputView.printLottoDrawResult(DrawingLotto.toString(drawingLotto));

        List<Integer> userWinningLotto = inputWinningLotto();
        int userBonusBall = inputBonusBall();

        WinningLotto winningLotto = WinningLotto.createWinningLotto(userWinningLotto, userBonusBall);




    }

    private int inputMoney() {
        while (true) {
            try {
                InputView.printMoneyInputRequestMessage();

                String userInput = inputView.inputMoney().trim();

                inputView.validateIsBlank(userInput);
                inputView.validateIsNumber(userInput);

                return Integer.parseInt(userInput);

            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningLotto() {
        while (true) {
            try {
                InputView.printWinningLottoInputRequestMessage();

                String userInput = inputView.inputWinningLotto().trim();

                inputView.validateIsBlank(userInput);
                inputView.validateIsNumberAndComma(userInput);

                return Arrays.stream(userInput.split(","))
                        .mapToInt(Integer::parseInt)
                        .boxed().toList();

            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private int inputBonusBall() {
        while (true) {
            try {
                InputView.printBonusBallInputRequestMessage();

                String userInput = inputView.inputBonusBall().trim();

                inputView.validateIsBlank(userInput);
                inputView.validateIsNumber(userInput);

                return Integer.parseInt(userInput);

            } catch (ArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
