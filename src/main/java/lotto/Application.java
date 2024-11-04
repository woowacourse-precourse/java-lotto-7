package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        // 이후 단계에서 로또 발행 기능을 추가할 예정입니다.
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
