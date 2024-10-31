package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

public class InputView {
    public String readLine() {
        String readLine = Console.readLine();
        return readLine.trim();
    }
    public double readPurchaseAmount() {
        String readLine = readLine();
        try {
            return Double.parseDouble(readLine);
        }catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
    }
}
