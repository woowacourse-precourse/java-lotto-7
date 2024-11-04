package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.global.utils.NumberFormatter;

public class InputHandler {

    private static final int LOTTO_PRICE = 1000;

    InputValidator inputValidator = new InputValidator();

    /**
     * 사용자로부터 구입 금액을 입력받는다.
     * @return 구입한 로또 개수
     */
    public int getNumberOfLottoTickets() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        inputValidator.validateStringTypeAmount(purchaseAmount);
        int purchaseAmountAsInt = NumberFormatter.parseToInt(purchaseAmount);
        inputValidator.validateIntegerTypeAmount(purchaseAmountAsInt);

        return purchaseAmountAsInt / LOTTO_PRICE;
    }

    /**
     * 사용자로부터 6개의 당첨 번호를 입력 받는다.
     * @return 6개의 당첨번호가 담긴 리스트
     */
    public List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        inputValidator.validateWinningNumbers(winningNumbers);
        List<Integer> lottoNumbers = NumberFormatter.parseToList(winningNumbers);
        inputValidator.validateLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    /**
     * 사용자로부터 1개의 보너스 번호를 입력 받는다.
     * @return 1개의 1이상 45 이하의 정수
     */
    public int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        inputValidator.validateBonusNumber(bonusNumber);

        return NumberFormatter.parseToInt(bonusNumber);
    }
}
