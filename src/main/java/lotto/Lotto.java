package lotto;

import java.util.ArrayList;
import java.util.List;

// 리스트로 로또를 갖고온다음 진행해야될듯?
public class Lotto {
    // validator를 지난 numbers 이어야 한다.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public int calculateAmountNumbersThatMatchWinningNumbers(List<Integer> lottoWinningNumber) {
        // 변경할 수 없는 객체를 변경가능하도록 변경 -> 왜 변경가능하지가 않지?
        List<Integer> numbersThatMatchLotteryWinningNumbers = new ArrayList<>(lottoWinningNumber);

        numbersThatMatchLotteryWinningNumbers.retainAll(numbers);

        return numbersThatMatchLotteryWinningNumbers.size();
    }

    public boolean isMatchBonusNumber(int lottoBonusNumber) {
        return numbers.contains(lottoBonusNumber);
    }
}
