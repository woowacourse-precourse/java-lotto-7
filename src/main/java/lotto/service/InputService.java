package lotto.service;

import lotto.domain.User;
import lotto.validate.BonusNumberValidate;
import lotto.validate.LottoNumberValidate;
import lotto.validate.PriceValidate;

import java.util.List;

import static lotto.view.InputView.*;

public class InputService {

    private int priceValidate() {
        PriceValidate validate = new PriceValidate(inputLottoMoney());
        return validate.getPrice();
    }

    public User getUser() {
        return new User(priceValidate());
    }

    private List<Integer> lottoNumberValidate() {
        LottoNumberValidate validate = new LottoNumberValidate(inputLottoNumber());
        return validate.getLottoNumber();
    }

    private int bonusNumberValidate() {
        BonusNumberValidate validate = new BonusNumberValidate(inputBonusNumber());
        return validate.getBonusNumber();
    }
}
