package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.validator.LottoValidator;
import lotto.util.Separator;

public class LottoInputView {
    public int inputPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            LottoValidator.validateStringInput(input);
            int lottoAmount = Integer.parseInt(input);
            LottoValidator.validatePurchase(lottoAmount);
            return lottoAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public Lotto inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = Separator.parseInputToList(input);
        return new Lotto(winningNumbers);
    }


    public int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
