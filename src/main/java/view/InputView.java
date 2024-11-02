package view;

import camp.nextstep.edu.missionutils.Console;
import convert.InputConvertor;
import java.util.List;

public class InputView {

    private final InputConvertor inputConvertor;

    public InputView(InputConvertor inputConvertor) {
        this.inputConvertor = inputConvertor;
    }

    public int inputPurchaseAmount() {
        ViewMessage.INPUT_PURCHASE_AMOUNT.print();
        String inputPurchaseAmount = Console.readLine();
        return inputConvertor.convertPurchaseAmount(inputPurchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        ViewMessage.INPUT_WINNING_NUMBERS.print();
        String inputWinningNumbers = Console.readLine();
        return inputConvertor.convertInputWinningNumbers(inputWinningNumbers);
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        ViewMessage.INPUT_BONUS_NUMBER.print();
        String inputBonusNumber = Console.readLine();
        return inputConvertor.convertInputBonusNumber(inputBonusNumber, winningNumbers);
    }
}
