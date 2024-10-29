package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class InputView {
    public int inputLottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        Validator.validateLottoAmount(amount);
        return Integer.parseInt(amount);
    }

    public String inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        Validator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
