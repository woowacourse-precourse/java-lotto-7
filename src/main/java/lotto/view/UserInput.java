package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import lotto.Validator;

public class UserInput {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        Validator.validatePositiveAmount(amount);
        Validator.validatePurchaseAmount(amount);

        return amount;
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            Validator.validateNumberRange(num);
            winNumbers.add(num);
        }
        Validator.validateLottoSize(winNumbers);
        Validator.validateDuplicate(winNumbers);

        return winNumbers;
    }

    public static int inputBonusNumber(List<Integer> winNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        Validator.validateNumberRange(bonusNumber);
        Validator.validateBonusDuplicate(winNumbers, bonusNumber);

        return bonusNumber;
    }

}
