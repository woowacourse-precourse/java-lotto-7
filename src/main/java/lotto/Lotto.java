package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.model.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    // TODO: 추가 기능 구현
    public LottoRank winningCheck(List<Integer> winningNumbers,int bonusNumber) {
        //교집합의 개수 -> 당첨 개수
        Set<Integer> userNumbers = new HashSet<>(this.numbers);
        userNumbers.retainAll(winningNumbers);
        int mainWinningCount = userNumbers.size();
        return LottoRank.valueOf(mainWinningCount,bonusWinningCheck(bonusNumber));// 등수를 반환
    }
    private boolean bonusWinningCheck(int bonusNumbers) {
        Set<Integer> userNumbers = new HashSet<>(this.numbers);
        return userNumbers.contains(bonusNumbers);
    }
}
