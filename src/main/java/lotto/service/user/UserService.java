package lotto.service.user;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.User;

public class UserService {

    private final MoneyService moneyService;
    private final LottoService lottoService;

    public UserService(MoneyService moneyService, LottoService lottoService) {
        this.moneyService = moneyService;
        this.lottoService = lottoService;
    }
    public User userProcess(String purchaseAmount) {
        Money userMoney = moneyService.generateMoney(purchaseAmount);
        Lottos userLottos = lottoService.generateUserLottos(userMoney);
        return new User(userMoney, userLottos);
    }

}
