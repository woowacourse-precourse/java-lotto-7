package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public void getLottoPurchaseAmount() {
        int lottoPurchaseAmount = Integer.parseInt(Console.readLine());

        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로만 입력이 가능합니다.");
        }
    }

    public List<Integer> getWinningNumber() {
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            integerList.add(i, Integer.parseInt(winningNumbers.get(i)));
        }

        return integerList;
    }
}