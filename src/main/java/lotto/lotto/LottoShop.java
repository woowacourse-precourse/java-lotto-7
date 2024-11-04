package lotto.lotto;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.utils.LottoNumberPicker;
import lotto.validation.InputValidation;

public class LottoShop {
    private final LottoNumberPicker lottoNumberPicker;
    private final InputValidation inputValidation;

    public LottoShop(LottoNumberPicker lottoNumberPicker, InputValidation inputValidation) {
        this.lottoNumberPicker = lottoNumberPicker;
        this.inputValidation = inputValidation;
    }

    public List<MyLotto> buyLottos(long money) {
        List<MyLotto> myLottos = new ArrayList<>();
        while (money > 0) {
            money = money - LOTTO_PRICE;
            MyLotto myLotto = new MyLotto(lottoNumberPicker.createRandomNumbers());
            myLottos.add(myLotto);
        }
        return myLottos;
    }
}
