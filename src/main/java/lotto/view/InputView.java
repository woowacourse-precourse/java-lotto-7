package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class InputView {
    public String inputCost() {
        return Console.readLine();
    }

    public Lotto inputWinningLottoNumbers() {
        String input = Console.readLine();
        List<Integer> winningLottoNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .toList();
        return new Lotto(winningLottoNumbers);
    }

    public int bonusWinningLottoNumber() {
        String input = Console.readLine();
        Console.close();
        return Integer.parseInt(input);
    }
}
