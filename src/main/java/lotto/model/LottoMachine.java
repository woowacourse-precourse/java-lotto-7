package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<Lotto> purchaseLotto(int price) {
        validatePrice(price);
        int ticketCount = price / Constants.PRICE_UNIT;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static void validatePrice(int price) {
        if (price <= 0 || price % Constants.PRICE_UNIT != 0) {
            throw new IllegalArgumentException(Constants.ERROR_PURCHASE_AMOUNT);
        }
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.LOTTO_NUMBER_MIN, Constants.LOTTO_NUMBER_MAX, Constants.LOTTO_NUMBERS_COUNT);
        return new Lotto(numbers);
    }

    public LottoResult calculateResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(tickets, winningNumbers, bonusNumber);
    }
}
