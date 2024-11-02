package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Result;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int n : numbers) {
            if (!(n >= 1 && n <= 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 인 정수를 입력 해야 합니다.");
            }
        }

        List<Integer> distinctList = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 되는 로또 번호가 없어야 합니다.");
        }
    }

    // 당첨 결과 계산 기능
    public void matcheNumber(List<List<Integer>> lotteryTickets, int bonusNumber) {
        for (List<Integer> lotteryTicket : lotteryTickets) {
            int matches = matchCount(lotteryTicket);

            if (matches == 5 && lotteryTicket.contains(bonusNumber)) {
                Result.SECOND.incrementCount();
                continue;
            }

            incrementCount(matches, bonusNumber, lotteryTicket);
        }
    }

    private int matchCount(List<Integer> lotteryTicket) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.retainAll(lotteryTicket);
        return copyNumbers.size();
    }

    private void incrementCount(int matches, int bonusNumber, List<Integer> lotteryTicket) {
        for (Result result : Result.values()) {
            if (result.getMatches() == matches && !result.getBonus()) {
                result.incrementCount();
            }
        }
    }

}
