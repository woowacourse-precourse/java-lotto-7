package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputConsole {

    public static PurchaseAmount readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = parseAmount(input);
        return new PurchaseAmount(amount);
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public static Lotto readLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();

        try {
            String[] winningNumbersString = input.split(",");
            for (String winningNumberStr : winningNumbersString) {
                winningNumbers.add(Integer.parseInt(winningNumberStr));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            readLottoWinningNumber();
        }
        return new Lotto(winningNumbers);
    }

    public static int readBonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(input);

            if (lotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException("보너스 번호는 기존 로또 번호와 중복될 수 없습니다.");
            }

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return readBonusNumber(lotto);
        }
    }
}
