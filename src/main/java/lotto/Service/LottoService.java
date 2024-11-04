package lotto.Service;

import lotto.model.*;
import java.util.List;

public class LottoService {
    private UserLottos userLottos;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private Result result;

    public void generateUserNumbers(int purchaseAmount) {
        userLottos = new UserLottos(purchaseAmount);
    }

    public void generateLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void generateBonusNumber(int number) {
        bonusNumber = new BonusNumber(number, lotto);
    }

    public void calculate() {
        result = userLottos.countMatchingNumber(lotto, bonusNumber);
        result.calculateRate(userLottos);
    }

    public List<Integer> getResult(){
        return result.getResult();
    }

    public String getRate() {
        return result.getRate();
    }

    public UserLottos getUserNumbers() {
        return userLottos;
    }
}
