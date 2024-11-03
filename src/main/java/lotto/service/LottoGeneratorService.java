package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;
import lotto.domain.lotto.Lotto;
import lotto.domain.purchase.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorService {

    public List<Lotto> generateLottoTickets(PurchaseAmount purchaseAmount) {
        int ticketCount = purchaseAmount.calculateIssuedTicketCount();

        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(randomNumbersGenerate()));
        }

        return lottoTickets;
    }

    private static List<Integer> randomNumbersGenerate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER, LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT);
    }
}