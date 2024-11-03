package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoInput {

    public static int getValidPurchasePrice() {
        while (true) {
            try {
                int purchasePrice = InputParser.parsePrice(Console.readLine());
                InputValidator.validatePrice(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }

    public static List<Integer> getValidWinningNo() {
        while (true) {
            try {
                int[] numbers = InputParser.getIntArray(InputParser.split(Console.readLine()));
                List<Integer> winningNumber = InputParser.getWinningNumber(numbers);
                InputValidator.validLotto(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n당첨 번호를 입력해 주세요.");
            }
        }
    }

    public static int getValidBonus(List<Integer> winningNumber) {
        while (true) {
            try {
                int bonus = InputParser.parsePrice(Console.readLine());
                InputValidator.validateBonus(winningNumber, bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("\n보너스 번호를 입력해 주세요.");
            }
        }
    }

}