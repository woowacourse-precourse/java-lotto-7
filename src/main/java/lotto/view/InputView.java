package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해야 합니다");
        }

        if (price < 0) {
            throw new IllegalArgumentException("음이 아닌 정수여야 합니다");
        }
        
        return price;
    }
}
