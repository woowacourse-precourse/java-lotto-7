package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class PurchasedLotto {

    private final int money;
    private final List<Lotto> purchasedLotto;

    public PurchasedLotto(int money) {
        validate(money);
        this.money = money;
        purchasedLotto = purchaseLotto();
    }

    public List<Lotto> getPurchasedLotto() {
        return Collections.unmodifiableList(purchasedLotto);
    }

    public int getMoney() {
        return money;
    }

    private List<Lotto> purchaseLotto() {
        List<Lotto> purchaseLotto = new ArrayList<>();
        for (int i = 0; i < money / LottoConstant.MONEY_UNIT.getNumber(); i++) {
            purchaseLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_LOWER_BOUND.getNumber(),
                    LottoConstant.LOTTO_NUMBER_UPPER_BOUND.getNumber(),
                    LottoConstant.NUMBER_OF_LOTTO_NUMBERS.getNumber())));
        }

        return purchaseLotto;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NEGATIVE.toString());
        }

        if ((money % LottoConstant.MONEY_UNIT.getNumber()) != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_WRONG.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder("\n" + purchasedLotto.size() + "개를 구매했습니다.\n");
        purchasedLotto.stream().map(Lotto::toString).forEach(message::append);
        return message.toString();
    }
}
