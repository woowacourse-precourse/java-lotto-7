package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validation.BonusNumberValidation;
import lotto.validation.WinningNumberValidation;

import java.util.List;

import static lotto.util.PurchaseUtils.getThousandUnitCount;

public class InputView {
    public int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputPurchaseAmount = Console.readLine();
                return getThousandUnitCount(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public Lotto readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨번호를 입력해 주세요.");
                String inputWinningNumbers = Console.readLine();
                List<Integer> lottoNumbers = WinningNumberValidation.parseLottoNumbers(inputWinningNumbers);
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                return BonusNumberValidation.parseBonusNumber(winningNumber, inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
