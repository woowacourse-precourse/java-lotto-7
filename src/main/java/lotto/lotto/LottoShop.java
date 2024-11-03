package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMassageConstants;
import lotto.constant.LottoConstants;

public class LottoShop {

    LottoNumberService lottoNumberService = new LottoNumberService();

    public List<Lotto> buyLottos(Long money) {
        if (validateMoney(money) == false) {
            System.out.println(ErrorMassageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000);
            throw new IllegalArgumentException(ErrorMassageConstants.VALUE_IS_NOT_DIVISIBLE_BY_1000);
        }

        List<Lotto> lottos = new ArrayList<>();
        while (money > 0) {
            money = money - LottoConstants.LOTTO_PRICE;
            Lotto lotto = new Lotto(lottoNumberService.createRandomNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    public boolean validateMoney(Long money) {
        return money % 1000 == 0;
    }
}
