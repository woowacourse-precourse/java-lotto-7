package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.validator.LottoBonusNumbersValidator;
import lotto.validator.LottoPurchaseValidator;
import lotto.util.Separator;

public class LottoInputView {
    public int inputPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            LottoPurchaseValidator.validatePurchaseStringInput(input);
            int lottoAmount = Integer.parseInt(input);
            LottoPurchaseValidator.validatePurchase(lottoAmount);
            return lottoAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public Lotto inputWinningNumbers() {
        try {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            List<Integer> winningNumbers = Separator.parseInputToList(input);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            LottoBonusNumbersValidator.validateBonusNumber(input, winningNumbers);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}

