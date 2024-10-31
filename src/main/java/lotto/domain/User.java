package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Constants.LOTTO_PRICE;
import static lotto.util.CreateLottoNumber.createLotto;

public class User {

    private final int buyingPrice; // 수익률 계산할 때 필요함
    private int winningPrice;
    private final List<UserLotto> userLotto;

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;
        this.winningPrice = 0;
        this.userLotto = new ArrayList<>();
    }

    public void addLottoNumber() {
        for (int i = 0; i < getLottoQuantity(); i++) {
            userLotto.add(createLotto());
        }
    }

    public List<UserLotto> getUserLotto() {
        return userLotto;
    }

    public int getLottoQuantity() {
        return buyingPrice / LOTTO_PRICE;
    }

}
