package lotto.model.shop;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.Validator;
import lotto.model.ticket.Lotto;
import lotto.model.ticket.LottoTickets;
import lotto.rule.LottoRule;

public class LottoMachine {

    public LottoTickets issueTicket(int quantity) {
        validateQuantity(quantity);
        return createLottoTickets(quantity);
    }

    private void validateQuantity(int quantity) {
        Validator.checkPurchaseQuantity(quantity);
    }

    private LottoTickets createLottoTickets(int quantity) {
        List<Lotto> lottoTickets = generateLottoByQuantity(quantity);
        return new LottoTickets(lottoTickets);
    }

    private List<Lotto> generateLottoByQuantity(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> createLotto())
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> uniqueNumbers = getUniqueNumbers();
        return sortByAsc(uniqueNumbers);
    }

    private List<Integer> getUniqueNumbers() {
        int startInclusive = LottoRule.MIN_LOTTO_NUMBER.get();
        int endInclusive = LottoRule.MAX_LOTTO_NUMBER.get();
        int count = LottoRule.LOTTO_NUMBERS_COUNT.get();
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

    private List<Integer> sortByAsc(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
