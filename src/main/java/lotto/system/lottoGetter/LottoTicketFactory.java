package lotto.system.lottoGetter;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_UPPER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.system.unit.LottoNumber;
import lotto.system.unit.LottoTicket;

public class LottoTicketFactory { // 로또 수량 만큼 로또 티켓들을 생성하는 객체

    public static List<LottoTicket> generate(int quantity) {
        if (quantity == 1) {
            return List.of(generateSingleTicket());
        }
        return generateTickets(quantity);
    }

    private static List<LottoTicket> generateTickets(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> LottoTicket.ofLottoNumbers(generateUniqueNumbersInRange()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static LottoTicket generateSingleTicket() {
        return LottoTicket.ofLottoNumbers(generateUniqueNumbersInRange());
    }


    private static List<LottoNumber> generateUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND, LOTTO_SIZE)
                .stream()
                .map(LottoNumber::of)
                .sorted()
                .collect(Collectors.toList());
    }
}
