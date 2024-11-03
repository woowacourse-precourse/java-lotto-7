package lotto.util;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class LottoTicketGenerator {

    // 사용자가 선택한 번호 조합을 포함하는 로또 티켓을 생성
    public List<Lotto> createTickets(int purchaseAmount) {
        int ticketCount = calculateTicketCount(purchaseAmount);
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(Lotto.generateRandomNumbers()))
                .toList();
    }

    // 구매 금액에 따른 티켓 개수 계산
    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

}
