package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.LottoInfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.common.LottoInfo.*;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers() {
        winningNumbers = inputWinningNumbers();
        bonusNumber = inputBonusNumber();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> inputWinningNumbers() {
        while(true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                String input = Console.readLine();
                validateWinningNumbersInput(input);

                return Arrays.stream(input.split(LOTTO_NUMBER_INPUT_DELIMITER))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while(true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try {
                String input = Console.readLine();
                validateBonusNumberInput(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbersInput(String input) {
        isNumberOnlyInInput(input);
        isRightSize(input);
        isInRightRangeInInputNumbers(input);
        isDuplicated(input);
    }

    private void validateBonusNumberInput(String input) {
        isNumberOnlyInInput(input);
        isInRightRangeInInputNumbers(input);
    }

    private void isNumberOnlyInInput(String input) {
        String delimiterRemovedInput = input.replace(LOTTO_NUMBER_INPUT_DELIMITER, "");
        if(!Pattern.matches("^[0-9]*$", delimiterRemovedInput)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자 이외의 값이 섞여있습니다.");
        }
    }

    private void isRightSize(String input) {
        List<String> inputContents = List.of(input.split(LOTTO_NUMBER_INPUT_DELIMITER));
        if(inputContents.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void isInRightRangeInInputNumbers(String input) {
        isNumberOnlyInInput(input);

        List<Integer> numbers = Arrays.stream(input.split(LOTTO_NUMBER_INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if(!numbers.stream().allMatch(i -> i>=LOTTO_START_NUMBER && i<=LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void isDuplicated(String input) {
        List<String> inputLottoNumbers = List.of(input.split(LOTTO_NUMBER_INPUT_DELIMITER));
        Set<String> duplicateRemovedInputLottoNumbers = new HashSet<>(inputLottoNumbers);

        if(inputLottoNumbers.size()!=duplicateRemovedInputLottoNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호은 중복되면 안됩니다.");
        }
    }
}