package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Constants.LOTTO_PRICE;

public class User {

    private final int buyingPrice; // 수익률 계산할 때 필요함
    private int winningPrice;
    private final List<UserLottoNumber> userLottoNumber;

    public User(int buyingPrice) {
        this.buyingPrice = buyingPrice;
        this.winningPrice = 0;
        this.userLottoNumber = new ArrayList<>();
    }

    public void addLottoNumber(UserLottoNumber lottoNumber) {
        userLottoNumber.add(lottoNumber);
    }

    public List<UserLottoNumber> getUserLottoNumber() {
        return userLottoNumber;
    }

    public int getLottoQuantity() {
        return buyingPrice / LOTTO_PRICE;
    }

}
