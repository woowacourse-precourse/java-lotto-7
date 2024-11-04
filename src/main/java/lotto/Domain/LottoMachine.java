package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Messages.ErrorMessages;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> issue(int amount) {
        validatePurchaseAmount(amount);
        int count = amount / LOTTO_PRICE;
        return generateLottos(count);
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_NEGATIVE.message);
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNIT.message);
        }
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(new LottoNumber().getNumbers()));
        }
        return lottos;
    }
}