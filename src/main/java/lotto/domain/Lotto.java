package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // 오름차순으로 정렬한 리스트를 새로 반환
    public List<Integer> sortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    // 당첨번호 리스트를 입력받아 맞춘 갯수 반환
    public int countWinningNumbers(List<Integer> winningNumbers) {
        int countWin = 0;
        // 내 로또 번호와 비교해서 맞는 갯수 찾기
        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                countWin++;
            }
        }
        return countWin;
    }

    // 맞춘 갯수와 보너스 점수를 입력받아 등수 반환
    public int checkRank(int countWin, int bonusNumber) {
        if (countWin == 6) {
            return 1;
        }
        if (countWin == 5 && numbers.contains(bonusNumber)) {
            return 2;
        }
        if (countWin == 5 && !numbers.contains(bonusNumber)) {
            return 3;
        }
        if (countWin == 4) {
            return 4;
        }
        if (countWin == 3) {
            return 5;
        }
        return 0;
    }

    // lotto 출력용
    @Override
    public String toString() {
        StringJoiner lottoJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            lottoJoiner.add(String.valueOf(number));
        }
        return lottoJoiner.toString();
    }
}
