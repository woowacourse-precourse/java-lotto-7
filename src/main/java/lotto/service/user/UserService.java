package lotto.service.user;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.utils.Calculator.PurchaseCalculator;
import lotto.utils.generator.LottoGenerator;
import lotto.utils.parser.Parser;

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
