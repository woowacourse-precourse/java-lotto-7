package lotto.model;

import camp.nextstep.edu.missionutils.Console;

// Input에 필요한 메서드 모음
public class InputModel {

    // 구입금액 입력 받은 후 반환
    public int getPrice() {
        int price;
        try {
            price = validatePrice(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("구입금액을 다시 입력해 주세요.");
            price = getPrice();
        }
        return price;
    }

    // 구입금액 입력 유효성 검사
    static int validatePrice(String inputPriceText) {
        int price;
        isEmptyOrNull(inputPriceText);
        price = isNumber(inputPriceText);
        isOverThousand(price);
        isDivisibleThousand(price);
        return price;
    }

    private static void isEmptyOrNull(String priceText) {
        if (priceText == null || priceText.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 입력입니다.");
        }
    }

    private static int isNumber(String priceText) {
        int price;
        try {
            price = Integer.parseInt(priceText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        return price;
    }

    private static void isOverThousand(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이어야 합니다.");
        }
    }

    private static void isDivisibleThousand(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }
}
