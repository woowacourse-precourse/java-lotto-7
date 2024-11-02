package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;
import java.util.TreeSet;

public class InputView {

    private static final int LOTTO_PRICE = 1000;

    public static long inputPurchaseMoney() {

        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();

        if (!isNumeric(inputPrice)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수로 입력해 주세요.");
        }

        long userPrice = Integer.parseInt(inputPrice);
        if (userPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE + "단위로 입력해 주세요.");
        }
        System.out.println();

        return userPrice;
    }

    public static Set<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine().trim();
        if (!winningNumbersInput.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }
        String[] inputNumbers = winningNumbersInput.split(",");
        if (inputNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로, 6개 입력해 주세요.");
        }

        Set<Integer> winningNumbers = new TreeSet<>();
        for (String inputNumber : inputNumbers) {
            if (!isNumeric(inputNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력해 주세요.");
            }

            int number = Integer.parseInt(inputNumber);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 1 이상의 양수로 입력해 주세요.");
            }
            if (number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
        System.out.println();

        return winningNumbers;
    }

    public static int inputBonusWinningNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        if (!inputBonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상의 양수로 입력해 주세요.");
        }
        if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        winningNumbers.add(bonusNumber);
        if (winningNumbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }
        System.out.println();
        return bonusNumber;
    }

    private static boolean isNumeric(String inputPrice) {
        return inputPrice.chars().allMatch(Character::isDigit);
    }
}
