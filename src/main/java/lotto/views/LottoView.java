package lotto.views;
import camp.nextstep.edu.missionutils.Console;
import static lotto.utils.MessageFormatter.formatErrorMessage;

public class LottoView {
    void displayMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput() {
        return Console.readLine();
    }
}
