package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

    public int getCustomerMoney() {
        String input = Console.readLine();
        Verifier.validateMoney(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        String[] splittedInput = input.split(",");
        Verifier.validateLottoNumbers(splittedInput);
        return convertToIntegerList(splittedInput);
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        Verifier.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }

    private List<Integer> convertToIntegerList(String[] values) {
        return Stream.of(values)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
