package lotto.view;

import static lotto.vaildate.Validate.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.vaildate.Validate;

public class InputView {

    private static final String START_PRICE_INPUT = "구입금액을 입력해 주세요.";
    private static final String START_WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String PREFIX = ",";

    public int buyLottoPriceInput() {
        System.out.println(START_PRICE_INPUT);
        return readLottoPrice();
    }

    public List<Integer> winningNumberInput() {
        System.out.println(START_WINNING_NUMBERS_INPUT);
        return readWinningNumbers();
    }
    
    private int readLottoPrice() {
        try {
            return purchasePriceValidate(consoleReadLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return readLottoPrice();
        }
    }

    private List<Integer> readWinningNumbers() {
        try {
            return readAndValidateWinningNumbers();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return readWinningNumbers();
        }
    }

    private List<Integer> readAndValidateWinningNumbers() {
        return winningNumbersValidate(getWinningNumbers());
    }

    private List<Integer> getWinningNumbers() {
        return Arrays.stream(consoleReadLine().split(PREFIX))
                .map(Validate::parseIntegerValidate)
                .toList();
    }

    private static String consoleReadLine() {
        String line = Console.readLine();
        System.out.println();
        return line;
    }

    private void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }


}
