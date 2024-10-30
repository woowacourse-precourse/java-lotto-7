package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConst;
import lotto.util.validator.InputValidator;

public class InputView {

    private class InputMessage {

        public static String READ_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
        public static String READ_WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
        public static String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    }

    public static int readMoney() {
        System.out.println(InputMessage.READ_MONEY_MESSAGE);
        String money = Console.readLine();
        InputValidator.validateMoney(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(InputMessage.READ_WIN_NUMBER_MESSAGE);
        String winningNumbers = Console.readLine();
        InputValidator.validateWinningNumbers(winningNumbers);
        String[] nums = winningNumbers.split(LottoConst.COMMA);
        return convertToList(nums);
    }

    private static List<Integer> convertToList(String[] nums) {
        return Arrays.stream(nums)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println(InputMessage.READ_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
