package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.util.message.Messages.QUANTITY_OF_LOTTO;

public class LottoService {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public List<Lotto> issueLotto(int price) {
        int numberOfTickets = price / TICKET_PRICE;
        List<Lotto> lottoTickets = issueLottoTickets(numberOfTickets);
        printLottoStatus(lottoTickets);
        return lottoTickets;
    }

    private static void printLottoStatus(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + QUANTITY_OF_LOTTO);
        for(Lotto lotto: lottoTickets){
            System.out.println(lotto);
        }
        System.out.println();
    }

    private List<Lotto> issueLottoTickets(int numberOfTickets) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
        return lottoTickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(numbers);
        return numbers;
    }

    public WinningLotto issueWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        Collections.sort(winningNumber);
        return new WinningLotto(bonusNumber,winningNumber);
    }
}
