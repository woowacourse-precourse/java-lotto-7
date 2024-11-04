package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.validate.BonusNumberValidate;
import lotto.validate.LottoNumberValidate;
import lotto.validate.PriceValidate;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.InputView.*;

public class InputService {

    public User inputUser() {
        User user = new User(priceValidate());
        OutputView.buyLottoQuantity(user);
        OutputView.buyLottoNumber(user);
        return user;
    }

    private int priceValidate() {
        try {
            PriceValidate validate = new PriceValidate(inputLottoMoney());
            return validate.getPrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return priceValidate();
        }
    }

    public Lotto setWinningLotto() {
        Lotto lotto = setLotto();
        setBonusNumber(lotto);
        return lotto;
    }

    private List<Integer> lottoNumberValidate() {
        try {
            LottoNumberValidate validate = new LottoNumberValidate(inputLottoNumber());
            return validate.getLottoNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoNumberValidate();
        }
    }

    private int bonusNumberValidate() {
        try {
            BonusNumberValidate validate = new BonusNumberValidate(inputBonusNumber());
            return validate.getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumberValidate();
        }
    }

    private Lotto setLotto() {
        try {
            return new Lotto(lottoNumberValidate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLotto();
        }
    }

    private void setBonusNumber(Lotto lotto) {
        try {
            lotto.setBonusNumber(bonusNumberValidate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber(lotto);
        }
    }
}
