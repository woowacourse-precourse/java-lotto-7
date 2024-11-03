package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.global.utils.NumberFormatter;

public class InputHandler {
    /**
     * 사용자로부터 구입 금액을 입력받는다.
     * @return 구입한 금액(액수)
     */
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        InputValidator.validateStringTypeAmount(purchaseAmount);
        int purchaseAmountAsInt = NumberFormatter.parseToInt(purchaseAmount);
        InputValidator.validateIntegerTypeAmount(purchaseAmountAsInt);

        return purchaseAmountAsInt;
    }

    /**
     * 사용자로부터 6개의 당첨 번호를 입력 받는다.
     * @return 6개의 당첨번호가 담긴 리스트
     */
    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        InputValidator.validateWinningNumbers(winningNumbers);
        List<Integer> lottoNumbers = NumberFormatter.parseToList(winningNumbers);
        InputValidator.validateLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    /**
     * 사용자로부터 1개의 보너스 번호를 입력 받는다.
     * @return 1개의 1이상 45 이하의 정수
     */
    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);

        return NumberFormatter.parseToInt(bonusNumber);
    }
}
