package lotto;

import lotto.input.InputValidationMessage;
import lotto.input.WinLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        getBonusNum(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        // 숫자가 6자리 인지 확인
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        // 중복인지 확인
        checkDuplicate(numbers);

    }

    private void checkDuplicate(List<Integer> numbers){

        Set<Integer> uniqueNumbers = new HashSet<>(numbers); // 중복을 제거하여 Set에 추가
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_NUMBER_CANNOT_DUPLICATE.getMessage());
        }

    }

    public static void getNumsers(){
        new Lotto(WinLotto.inputWinLotto());
    }

    public static void getBonusNum(List<Integer> numbers) {
        int bonusNum = WinLotto.inputBonusLotto();

        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException(InputValidationMessage.MESSAGE_BONUS_NUMBER_CANNOT_DUPLICATE.getMessage());
        }
    }
}
