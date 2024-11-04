package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.utils.LottoNumberPicker;
import lotto.validation.MoneyValidation;

public class LottoShop {
    private final LottoNumberPicker lottoNumberPicker;
    private final MoneyValidation moneyValidation;

    public LottoShop(LottoNumberPicker lottoNumberPicker, MoneyValidation moneyValidation) {
        this.lottoNumberPicker = lottoNumberPicker;
        this.moneyValidation = moneyValidation;
    }

    public List<MyLotto> buyLottos(long money) {
        moneyValidation.validation(money);
        List<MyLotto> myLottos = new ArrayList<>();
        while (money > 0) {
            money = money - LottoConstants.LOTTO_PRICE;
            MyLotto myLotto = new MyLotto(lottoNumberPicker.createRandomNumbers());
            myLottos.add(myLotto);
        }
        return myLottos;
    }
}
