package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int inputMoney = Money.inputMoney();

        int numberOfLotto = inputMoney / 1000;
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        BuyLotto lottoList = new BuyLotto(numberOfLotto);
        lottoList.printLottoList();

        Lotto lotto = inputWinningNumbers();
        
        int bonusNumber = inputBonusNumber(lotto.getLotto());

        Result result = new Result(inputMoney);
        Result.compareLottoNumber(lottoList.getLottoList(), lotto.getLotto(), bonusNumber);
        Result.printResults();
        result.printRateOfReturn();
    }

    private static int inputBonusNumber(List<Integer> winningNumber) {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            return validateBonusNumber(winningNumber, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumber);
        }
    }

    private static int validateBonusNumber(List<Integer> winningNumber, String input) {
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
            }

            if (winningNumber.contains(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WITH_WINNING_NUMBER.getMessage());
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private static Lotto inputWinningNumbers() {
        try {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String userInput = Console.readLine();
            List<Integer> userNumbers = parseIntegers(userInput);
            return new Lotto(userNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private static List<Integer> parseIntegers(final String userInput) {
        try {
            return Arrays.stream(userInput.split(","))
                    .map(number -> Integer.parseInt(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}
