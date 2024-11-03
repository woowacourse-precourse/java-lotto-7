package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoTicketGenerator {
    public LottoTicket generate() {
        // 랜덤 숫자 6개 발행(채번)
        List<Integer> numbers = generateRandomNumbers();

        return new LottoTicket(numbers);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(AbsoluteValue.MIN_NUMBER, AbsoluteValue.MAX_NUMBER , 6);
        return numbers.stream().sorted().toList();
    }
}
