package lotto.service.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.value.LottoTicket;

public class LottoTicketFactory { // 로또 수량 만큼 로또 티켓들을 생성하는 객체

    public static List<LottoTicket> generate(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> LottoTicket.ofLottoNumbers(LottoGenerator.generateUniqueNumbersInRange()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}