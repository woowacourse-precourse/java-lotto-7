package domain;

import message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class PlayerBuyLotto {

    private static final int LOTTO_AMOUNT = 1000;

    public int purchasedLottoNums(String purchaseAmount) {

        Validate validate = new Validate();

        validate.validateContainsLetters(purchaseAmount);
        validate.validatePurchaseAmount(purchaseAmount);

        int amount = Integer.parseInt(purchaseAmount);

        return amount / LOTTO_AMOUNT;
    }

    public List<Lotto> buyLotto(int lottoPurchased) {

        ManageNumbers manageNumbers = new ManageNumbers();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoPurchased; i++) {

            Lotto lotto = manageNumbers.generateLotto();
            lottos.add(lotto);
        }

        return lottos;
    }
}
