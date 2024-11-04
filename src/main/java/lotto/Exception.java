package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int validateLottoPurchase(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("[ERROR] 정수가 입력돼야 합니다.");
        }
        return isDivide1000(Integer.parseInt(input));

    }

    public int validateBonusNumber(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("[ERROR] 정수가 입력돼야 합니다.");
        }
        return Integer.parseInt(input);

    }

    public int isDivide1000(int inputNumber){
        if(!(inputNumber % 1000 == 0)){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
        return inputNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> parseLottoNumbers(String rawNumbers) {
        String[] rawNumberSplit = rawNumbers.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String numberInput : rawNumberSplit) {
            if (!isInteger(numberInput)) {
                throw new IllegalArgumentException("[ERROR] 모든 로또 번호는 정수여야 합니다."); // 개선된 메시지
            }
            int number = Integer.parseInt(numberInput);
            lottoNumbers.add(number);
        }
        validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateUniqueLottoNumbers(numbers);
        validateLottoNumberRange(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUniqueLottoNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다르게 입력해야 합니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
