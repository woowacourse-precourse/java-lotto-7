package lotto.service.user;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.utils.Parser;

public class UserService {

    private final MoneyService moneyService;
    private final LottoGeneratorService lottoGeneratorService;

    public UserService(MoneyService moneyService, LottoGeneratorService lottoGeneratorService) {
        this.moneyService = moneyService;
        this.lottoGeneratorService = lottoGeneratorService;
    }

    public User userProcess(String purchaseAmount) {
        Money userMoney = userMoney(purchaseAmount);
        Lottos userLottos = userLottos(userMoney);
        return new User(userMoney, userLottos);
    }

    private Money userMoney(String purchaseAmount) {
        return moneyService.generateMoney(purchaseAmount);
    }

    private Lottos userLottos(Money userMoney) {
        return lottoGeneratorService.generateLottos(userMoney);
    }

}
