package lotto.model.ticket;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.rule.LottoRule;

public class LottoMachine {

    public LottoTickets issueTicket(int quantity) {
        return generateLottoTickets(quantity);
    }

    private LottoTickets generateLottoTickets(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
        return new LottoTickets(lottoTickets);
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_LOTTO_NUMBER, LottoRule.MAX_LOTTO_NUMBER, LottoRule.LOTTO_NUMBERS_COUNT
        );
        return sortByAsc(uniqueNumbers);
    }

    private List<Integer> sortByAsc(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
