package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String INPUT_MONEY = Console.readLine();

        if (validateMoney(INPUT_MONEY)) {
        }

    }

    private static boolean validateMoney(String inputMoney) {
        return inputMoney.Integer.parseInt(inputMoney);
    }
}
