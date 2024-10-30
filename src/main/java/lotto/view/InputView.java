package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import lotto.utils.Validator;

public class InputView {
    private Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        validator.validateInputPurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public ArrayList<Integer> inputLottoNumber() {
        ArrayList<Integer> inputLottoNumbers = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();

        String[] LottoNumbers = numbers.split(",");

        for (String number : LottoNumbers) {
            inputLottoNumbers.add(Integer.valueOf(number.trim()));
        }

        return inputLottoNumbers;

    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return bonusNumber;
    }


}
