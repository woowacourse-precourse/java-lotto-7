package lotto.model.shop;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;
import lotto.model.ticket.Lotto;
import lotto.model.ticket.LottoTickets;
import lotto.rule.LottoRule;

public class LottoMachine {

    public LottoTickets issueTicket(int quantity) {
        validateQuantity(quantity);
        return generateLottoTickets(quantity);
    }

    private void validateQuantity(int quantity) {
        Validator.checkPurchaseQuantity(quantity);
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
