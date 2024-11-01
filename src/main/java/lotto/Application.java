package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchasePriceInput = Console.readLine();
            try {
                int purchasePrice = validatePurchasePrice(purchasePriceInput);

                if (purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위만 허용됩니다.");
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
//        String str = Console.readLine();
    }
    static int validatePurchasePrice(String purchasePriceInput) {
        try{
            return Integer.parseInt(purchasePriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 허용됩니다.");
        }
    }
}
