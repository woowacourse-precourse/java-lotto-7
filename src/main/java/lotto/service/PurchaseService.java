package lotto.service;

import lotto.model.SystemLotto;
import lotto.util.Constants;

import java.util.List;
import java.util.ArrayList;

public class PurchaseService {
    private final List<List<Integer>> purchasedLotto = new ArrayList<>();

    public List<List<Integer>> getPurchasedLotto() {
        return purchasedLotto;
    }

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
        List<String> sortedLotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            SystemLotto newLotto = new SystemLotto();
            purchasedLotto.add(newLotto.getNumbers());
            sortedLotto.add(newLotto.getSortedNumbers());
        }

        return sortedLotto;
    }
}
