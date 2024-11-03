package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Messages.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";

    public static Integer readPurchaseAmount() {
        while (true) {
            try {
                String rawPurchasePrice = Console.readLine();
                int purchasePrice = parseInt(rawPurchasePrice);
                checkPurchaseRange(purchasePrice);
                return purchasePrice; // 입력이 성공적으로 처리되면 반환
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage()); // 예외 메시지 출력
            }
        }
    }

    public static Lotto readWinningNum() {
        while (true) {
            try {
                String rawWinningInput = Console.readLine();
                return new Lotto(Arrays.asList(rawWinningInput.split(DELIMITER)).stream()
                        .map(InputView::parseInt)
                        .collect(Collectors.toList())); // 성공 시 반환
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage()); // 예외 메시지 출력
            }
        }
    }

    public static int readBonus(Lotto answer) {
        while (true) {
            try {
                String rawBonus = Console.readLine();
                int bonus = parseInt(rawBonus);
                checkBonus(bonus, answer);
                checkBonusRange(bonus);
                return bonus; // 성공 시 반환
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage()); // 예외 메시지 출력
            }
        }
    }


    public static int parseInt(String strNum) {
        int result = 0;
        try {
            result = Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getError());
        }
        return result;
    }

    public static void checkBonus(int bonusNumber, Lotto answer) {
        if (!(answer.getNumbers().stream()
                .allMatch(number -> number != bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getError());
        }
    }

    public static void checkBonusRange(int lottoNumber) {
        if (!(lottoNumber >= 1 && lottoNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE.getError());
        }
    }

    public static boolean checkRangeList(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
    }

    public static void checkPurchaseRange(int purchaseAmount) {
        if (!(purchaseAmount >= 1000 && purchaseAmount <= 200000000)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_RANGE.getError());
        }
    }
}
