package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.rule.LottoRule;

public class LottoMachine {

    public LottoTickets purchase(int purchaseAmount) {
        int quantity = calculateLottoQuantity(purchaseAmount);
        return generateLottoTickets(quantity);
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / LottoRule.PURCHASE_AMOUNT_UNIT;
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
        return sortLottoNumbers(uniqueNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
