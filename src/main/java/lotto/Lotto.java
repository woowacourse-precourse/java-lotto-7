package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> setNumbers = new HashSet<>(numbers);

        if(setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 6개여야 합니다.");
        }

        for (int a : numbers) {
            if(a > 45 || a <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
            }
        }

    }

    public void printLottoNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < 5; i++) {
            sb.append(numbers.get(i));
            sb.append(", ");
        }
        sb.append(numbers.get(5));
        sb.append("]");
        System.out.println(sb);
    }
    
    public Rank read(List<Integer> winningNum, int bonus) {
        int matchCount = 0;
        for(int num : numbers) {
            if(winningNum.contains(num)) {
                matchCount++;
            }
        }
        if(matchCount == 6) {
            return Rank.FIRST;
        }
        if(numbers.contains(bonus)) {
            matchCount++;
        }
        if(matchCount == 6) {
            return Rank.SECOND;
        }
        if(matchCount == 5) {
            return Rank.THIRD;
        }
        if(matchCount == 4) {
            return Rank.FORTH;
        }
        if(matchCount == 3) {
            return Rank.FIFTH;
        }
        return null;
    }
}
