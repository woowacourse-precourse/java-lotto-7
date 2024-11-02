package lotto.system;

import static lotto.user.LottoNumber.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.user.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory { // 로또를 사면 로또 번호를 생성하는 객체

    private static final int VALID_SIZE = 6;

    public static List<LottoTicket> generate(int quantity) {
        if (quantity == 1) {
            return List.of(generateSingleTicket());
        }
        return generateTickets(quantity);
    }

    static List<LottoTicket> generateTickets(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> LottoTicket.of(generateUniqueNumbersInRange()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static LottoTicket generateSingleTicket() {
        return LottoTicket.of(generateUniqueNumbersInRange());
    }


    static List<Integer> generateUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND, VALID_SIZE);
    }
}
