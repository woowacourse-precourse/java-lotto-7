package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessageConstants;
import lotto.constant.LottoConstants;
import lotto.lotto.object.MyLotto;

public class LottoShop {

    LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();

    public List<MyLotto> buyLottos(Long money) {
        if (validateMoney(money) == false) {
            System.out.println(ErrorMessageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000);
            throw new IllegalArgumentException(ErrorMessageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000);
        }

        List<MyLotto> myLottos = new ArrayList<>();
        while (money > 0) {
            money = money - LottoConstants.LOTTO_PRICE;
            MyLotto myLotto = new MyLotto(lottoNumberPicker.createRandomNumbers());
            myLottos.add(myLotto);
        }
        return myLottos;
    }

    public boolean validateMoney(Long money) {
        return money % 1000 == 0;
    }
}
