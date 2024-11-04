package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public static int getBuyingPrice() {
        while(true) {
            try {
                String buyingPrice = Console.readLine();
                InputValidator.buyingPriceValidator(buyingPrice);
                return Integer.parseInt(buyingPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static Lotto getWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        while(true) {
            try {
                String winningNumbers = Console.readLine();
                List<Integer> numbers = Arrays.stream(winningNumbers.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                Lotto winningLotto = new Lotto(numbers);
                return winningLotto;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static int getBonusNumber(Lotto winningNumber) {
        System.out.println("보너스 번호를 입력해주세요.");
        while(true) {
            try {
                String bonusNumber = Console.readLine();
                InputValidator.bonusNumberValidator(bonusNumber, winningNumber);
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
