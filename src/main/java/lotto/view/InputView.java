package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConst;
import lotto.util.validator.InputValidator;

public class InputView {

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        InputValidator.validateMoney(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        InputValidator.validateWinningNumbers(winningNumbers);
        String[] nums = winningNumbers.split(LottoConst.COMMA);
        return Arrays.stream(nums)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
