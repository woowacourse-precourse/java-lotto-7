package lotto.service;

import lotto.model.SystemLotto;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final List<String> purchasedLotto = new ArrayList<>();

    public int calculateLottoCount(String purchaseAmount) {
        try {
            int amount = Integer.parseInt(purchaseAmount);

            if (amount == 0 || amount % Constants.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
            }
            return amount / Constants.LOTTO_PRICE;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public List<String> purchaseLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            SystemLotto newLotto = new SystemLotto();
            purchasedLotto.add(newLotto.getSortedNumbers());
        }

        return purchasedLotto;
    }
}
