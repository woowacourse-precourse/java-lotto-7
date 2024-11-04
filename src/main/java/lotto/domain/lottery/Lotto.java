package lotto.domain.lottery;

import java.util.List;
import lotto.controller.LottoPolicy;
import lotto.exception.ExceptionMessage;

public class Lotto implements Lottery {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateDuplicateNumbers(List<Integer> validatedWinningNumbers) {
        if(validatedWinningNumbers.stream().distinct().toList().size()!=validatedWinningNumbers.size()){
            throw new IllegalArgumentException(
                    ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_DUPLICATE_NUMBER.getMessage());
        }
    }
    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoPolicy.WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현
    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public Integer countMatchingWinningNumbers(List<Integer> winningNumbers) {
        long count = numbers.stream().filter(winningNumbers::contains).count();
        return Integer.parseInt(Long.toString(count));
    }

    @Override
    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
