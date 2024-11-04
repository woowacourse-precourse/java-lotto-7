package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessageConstants;
import lotto.constant.LottoConstants;

public class LottoShop {

    LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();

    public List<Lotto> buyLottos(Long money) {
        if (validateMoney(money) == false) {
            System.out.println(ErrorMessageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000);
            throw new IllegalArgumentException(ErrorMessageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000);
        }

        List<Lotto> lottos = new ArrayList<>();
        while (money > 0) {
            money = money - LottoConstants.LOTTO_PRICE;
            Lotto lotto = new Lotto(lottoNumberPicker.createRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public boolean validateMoney(Long money) {
        return money % 1000 == 0;
    }
}
