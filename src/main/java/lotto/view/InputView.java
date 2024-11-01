package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int getMoneyFromUser() {
        String input = Console.readLine();

        int money = Integer.parseInt(input);

        return money;
    }

    public List<Integer> getLottoWinningNumberFromUser() {
        String input = Console.readLine();

        String[] splitInput = input.split(",");

        List<Integer> lottoWinningNumber = Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .toList();

        return lottoWinningNumber;

    }

    public int getLottoBonusNumberFromUser() {
        String input = Console.readLine();

        int lottoBonusNumber = Integer.parseInt(input);

        return lottoBonusNumber;
    }
}
