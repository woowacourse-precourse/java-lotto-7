package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class LottoWinningNumber {

    private HashMap<Integer, String> winningNumbers = new HashMap<>();

    public HashMap<Integer, String> input() {
        InputMessageEnum.WINNING_NUMBERS.printMessage();
        String winningNumber = readLine();
        InputMessageEnum.BONUS_NUMBER.printMessage();
        String bonusNumber = readLine();

        return combineWinningNumbersAndBonus(winningNumber, bonusNumber);
    }

    private HashMap<Integer, String> combineWinningNumbersAndBonus(String winningNumber, String bonusNumber) {
        Lotto numbers = new Lotto(parseNumbers(winningNumber));
        numbers.getNumbers().forEach(n -> winningNumbers.put(n, "winningNumber"));
        winningNumbers.put(Integer.parseInt(bonusNumber), "bonusNumber");
        return winningNumbers;
    }

    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}