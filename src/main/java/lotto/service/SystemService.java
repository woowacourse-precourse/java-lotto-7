package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.numbers.NumberService;
import lotto.service.result.ResultService;
import lotto.service.user.UserService;

public class SystemService {
    private final NumberService numberService;
    private final ResultService resultService;
    private final UserService userService;

    private User user;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public SystemService(NumberService numberService, ResultService resultService, UserService userService) {
        this.numberService = numberService;
        this.resultService = resultService;
        this.userService = userService;
    }

    public User userProcess(String purchaseAmount) {
        user = userService.userProcess(purchaseAmount);
        return user;
    }

    public void winningLottoProcess(String number) {
        winningLotto = numberService.winningLotto(number);
    }

    public void bonusNumberProcess(String number) {
        bonusNumber = numberService.winningBonusNumber(number, winningLotto);
    }

}
