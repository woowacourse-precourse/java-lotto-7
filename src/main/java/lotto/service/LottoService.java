package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public List<Lotto> issueLotto(int price) {
        int numberOfTickets = price / TICKET_PRICE;
        List<Lotto> lottoTickets = issueLottoTickets(numberOfTickets);
        return lottoTickets;
    }

    private List<Lotto> issueLottoTickets(int numberOfTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
        return lottoTickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}
