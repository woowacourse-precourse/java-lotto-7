package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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
    
    public List<List<Integer>> generateLotteryTickets(int numberOfTickets) {
        List<List<Integer>> lotteryTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            validate(ticket);
            Collections.sort(ticket);
            lotteryTickets.add(ticket);
        }

        return lotteryTickets;
    }
}
