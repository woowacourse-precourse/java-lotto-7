package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        System.out.println("\n" + numberOfLottos + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);

                if (amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException();
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            }
        }
    }
}
