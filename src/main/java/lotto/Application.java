package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();

            int numberOfLottos = purchaseAmount / 1000;
            System.out.println("");
            System.out.println(numberOfLottos + "개를 구매했습니다.");

            for (int i = 0; i < numberOfLottos; i++) {
                Lotto lotto = LottoGenerator.generateLotto();
                System.out.println(lotto.getNumbers());
            }

            List<Integer> winningNumbers = WinningNumbers.getWinningNumbers();

//            System.out.println("당첨 번호: " + winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력이 가능합니다.");
        }
    }

}
