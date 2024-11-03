package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public Integer getPurchaseCost() {
        Integer purchaseCost = Integer.valueOf(Console.readLine());

        if (purchaseCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }

        return purchaseCost;
    }

    public List<Integer> getWinningLottoInput() {
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer getWinningLottoBonusNumberInput() {
        return Integer.parseInt(Console.readLine());
    }
}
