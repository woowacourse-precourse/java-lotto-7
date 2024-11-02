package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Constants.LOTTO_PRICE;
import static lotto.util.CreateLottoNumber.createLotto;

public class User {

    private final int buyingPrice;
    private int winningPrice = 0;
    private final List<UserLotto> userLotto = new ArrayList<>();

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;

        addLottoNumber();
    }

    private void addLottoNumber() {
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

    public void addWinningPrice(int price) {
        winningPrice += price;
    }

    public String getProfit() {
        return String.format("%,.1f", Math.round((double) winningPrice / buyingPrice * 1000) / 10.0);
    }
}
