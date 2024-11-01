package lotto.service.user;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.utils.LottoGenerator;
import lotto.utils.Parser;
import lotto.utils.PurchaseCalculator;

public class UserService {

    public User generateUser(String purchaseAmount) {
        Money userMoney = generateUserMoney(purchaseAmount);
        Lottos userLottos = generateUserLottos(userMoney);
        return new User(userMoney, userLottos);
    }

    private Money generateUserMoney(String purchaseAmount) {
        int convertedPurchaseAmount = Parser.parsingPurchaseAmount(purchaseAmount);
        return new Money(convertedPurchaseAmount);
    }

    private Lottos generateUserLottos(Money userMoney) {
        int lottoCount = PurchaseCalculator.calculateLottoCount(userMoney);
        return LottoGenerator.generateLottos(lottoCount);
    }
}
