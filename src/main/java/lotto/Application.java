package lotto;

import lotto.enums.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        lottoMachine.buyLotto(parseMoney(money));

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        lottoMachine.findWinningLotto(parseNumbers(winningNumbers), parseBonusNumber(bonusNumber));
    }

    public static Long parseMoney(String money) {
        try {
            return Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.MONEY_TYPE_ERROR.getMessage());
        }
    }

    public static List<Integer> parseNumbers(String numbers) {
        try {
            return List.of(numbers.split(",")).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_TYPE_ERROR.getMessage());
        }
    }

    public static Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_TYPE_ERROR.getMessage());
        }
    }
}
