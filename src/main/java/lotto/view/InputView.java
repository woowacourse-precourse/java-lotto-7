package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.utils.Constant;
import lotto.utils.Validator;

public class InputView {
    private Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public String inputPurchaseAmount() {
        System.out.println(Constant.PURCHASE_AMOUNT_PROMPT);
        String purchaseAmount = Console.readLine();

        validator.validateInputPurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public ArrayList<Integer> inputLottoNumber() {
        ArrayList<Integer> inputLottoNumbers = new ArrayList<>();

        System.out.println(Constant.WINNING_NUMBERS_PROMPT);
        String numbers = Console.readLine();

        validator.validateInputLottoNumber(numbers);

        String[] LottoNumbers = numbers.split(",");

        for (String number : LottoNumbers) {
            inputLottoNumbers.add(Integer.valueOf(number.trim()));
        }

        return inputLottoNumbers;

    }

    public String inputBonusNumber() {
        System.out.println(Constant.BONUS_NUMBER_PROMPT);
        String bonusNumber = Console.readLine();

        return bonusNumber;
    }


}
