package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Lotto에 numbers 이외의 필드를 추가할 수 없다.
// numbers의 접근제어자 변경 불가
// Lotto의 패키지 변경 가능


public class Lotto {
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
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(List<Integer> winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count; // 일치하는 번호 수 반환
    }

    public boolean contains(int number) {
        return numbers.contains(number); // 특정 번호가 포함되어 있는지 확인
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public String toFormattedString() {
        String lottoNumber = "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","))
                + "]";
        return lottoNumber;
    }

    public int getResult(WinningNumbers winningNumbers) {
        int match = winningNumbers.countMatch(numbers);
        if (match < WinningMatch.valueOfMinMatch().getMatch()) {
            return WinningMatch.valueOfMinMatch().getRank() + 1;
        }
        int rank = WinningMatch.valueOfMatch(match).getRank();
        if (rank == WinningMatch.THIRD.getRank() /*&& bonus.matchBonus(numbers)*/) {
            return WinningMatch.SECOND.getRank();
        }
        return rank;
    }
}
