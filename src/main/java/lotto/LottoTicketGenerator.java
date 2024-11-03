package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    public LottoTicket generate() {
        // 랜덤 숫자 6개 발행(채번)
        List<Integer> numbers = generateRandomNumbers();

        return new LottoTicket(numbers);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i += 1) {
            int number = Randoms.pickNumberInRange(AbsoluteValue.MIN_NUMBER, AbsoluteValue.MAX_NUMBER);
            while (list.contains(number)) {
                number = Randoms.pickNumberInRange(AbsoluteValue.MIN_NUMBER, AbsoluteValue.MAX_NUMBER);
            }
            list.add(number);
        }
        list.sort(Integer::compareTo);
        return list;
    }
}
