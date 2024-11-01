package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPrice() {
        String price = Console.readLine();
        if (price.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.");
        }
        return price;
    }
}
