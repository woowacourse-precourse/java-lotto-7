package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class LottoView {
    public int getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return getValidatedInput(lotto.valid.InputValidator::validatePurchasePrice);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getValidatedInput(lotto.valid.InputValidator::validateWinningNumbers);
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getValidatedInput(lotto.valid.InputValidator::validateBonusNumber);
    }

    private <T> T getValidatedInput(InputValidator<T> validator) {
        while (true) {
            try {
                String input = Console.readLine();
                return validator.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    private interface InputValidator<T> {
        T validate(String input);
    }

    public void displayLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayResult(LottoResult result) {
        System.out.println(result);
    }
}
