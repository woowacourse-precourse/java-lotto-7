package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    public List<Lotto> purchase(int purchaseAmount) {
        int quantity = calculateLottoQuantity(purchaseAmount);
        return generateLottoTickets(quantity);
    }

    private int calculateLottoQuantity(int purchaseAmount) {
        return purchaseAmount / PURCHASE_AMOUNT_UNIT;
    }

    private List<Lotto> generateLottoTickets(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
        return lottoTickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT);
        return sortLottoNumbers(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}