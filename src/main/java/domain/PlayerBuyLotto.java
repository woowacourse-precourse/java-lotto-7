package domain;

import message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class PlayerBuyLotto {

    private static final int LOTTO_AMOUNT = 1000;

    public int purchasedLottoNums(String purchaseAmount) {

        validatePurchaseAmount(purchaseAmount);

        int amount = Integer.parseInt(purchaseAmount);

        return amount / 1000;
    }

    public List<List<Integer>> buyLotto(int lottoPurchased) {

        LottoNumbers lottoNumbers = new LottoNumbers();

        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < lottoPurchased; i++) {

            Lotto lotto = lottoNumbers.generateLotto();
            lottos.add(lotto.getNumbers());
        }

        return lottos;
    }

    private void validatePurchaseAmount(String purchaseAmount) {

        int amount;

        try {

            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(ErrorMessage.CONTAINS_LETTER.getErrorMessage());
        }

        if(amount % LOTTO_AMOUNT != 0){

            throw new IllegalArgumentException(ErrorMessage.CANNOT_BUY_LOTTO.getErrorMessage());
        }
    }
}
