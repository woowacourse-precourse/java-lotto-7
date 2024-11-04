package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PriceInput {
    public int inputPrice() {
        int price = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                price = Integer.parseInt(Console.readLine());
                validatePrice(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 잘못된 형식의 입력입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 투입할 금액은 1,000원 이상이면서, 1,000 단위로만 입력할 수 있습니다.");
            }
        }
    }

    public void validatePrice(int price) {
        if (price < 1000 || (price%1000) != 0) {
            throw new IllegalArgumentException();
        }
    }
}
