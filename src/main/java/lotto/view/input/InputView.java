package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static int readPurchaseAmount(){
        System.out.println("\n구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.validatePurchaseAmount(input);
    }
    public static List<Integer> readWinningNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.validateWinningNumbers(input);
    }

    public static int readBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.validateNumber(input);
    }


}