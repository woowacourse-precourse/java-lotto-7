package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // 1 . 구매 금액 입력 및 로또 수량 계산
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = getValidPurchasePrice();
        int lottoQuantity = purchasePrice / 1000;


    }

    private static int getValidPurchasePrice() {
        while (true) {
            try {
                int purchasePrice = getInt(Console.readLine());
                if (purchasePrice < 1000 || purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 1000이상, 1000원 단위여야 합니다.");
                }
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }
    
    private static int getInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }
    }
}
