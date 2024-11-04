package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.LottoValidator.*;
import static lotto.domain.LottoValidator.validateInput;
import static lotto.domain.LottoValidator.validateLottoNumbers;
import static lotto.domain.LottoValidator.validateMoney;
import static lotto.util.InputMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class InputView {
    public static int inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
        String input = input();
        validateNumber(input);

        int money = Integer.parseInt(input);
        validateMoney(money);
        return money;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        String input = input();

        ArrayList<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        validateLottoNumbers(numbers);
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(input());
    }

    public static WinningLotto inputWinningLotto() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        validateWinningLotto(winningLotto);

        return winningLotto;
    }

    private static String input() {
        String input = readLine();
        validateInput(input);
        return input;
    }
}
