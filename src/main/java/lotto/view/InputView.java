package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoPrintMessages;

import javax.swing.text.View;

public class InputView implements InputViewer {
    public InputView() {}

    public int readPurchaseAmount() {
        printLottoAmountInputMessage();
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> readUserLotto() {
        printUserLottoInputMessage();
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readBonusNumber() {
        printBonusNumberInputMessage();
        return Integer.parseInt(Console.readLine());
    }

    private void printLottoAmountInputMessage() {
        System.out.print(LottoPrintMessages.INPUT_LOTTO_AMOUNT);
    }

    private void printUserLottoInputMessage() {
        System.out.print(LottoPrintMessages.INPUT_USERLOTTO);
    }

    private void printBonusNumberInputMessage() {
        System.out.print(LottoPrintMessages.INPUT_BONUS_NUMBER);

    }
}
