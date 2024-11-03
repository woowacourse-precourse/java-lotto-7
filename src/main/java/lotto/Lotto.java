package lotto;

import java.util.List;

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

    // TODO: 추가 기능 구현
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
