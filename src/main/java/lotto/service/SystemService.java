package lotto.service;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.numbers.LottoNumberService;
import lotto.service.result.ResultService;
import lotto.service.user.UserService;

public class SystemService {
    private final LottoNumberService lottoNumberService;
    private final ResultService resultService;
    private final UserService userService;

    public SystemService(LottoNumberService lottoNumberService, ResultService resultService, UserService userService) {
        this.lottoNumberService = lottoNumberService;
        this.resultService = resultService;
        this.userService = userService;
    }

    public User generateUser(String purchaseAmount) {
        return userService.userProcess(purchaseAmount);
    }

    public Lotto generateLotto(String number) {
        return lottoNumberService.generateWinningLotto(number);
    }

    public BonusNumber generateBonusNumber(String number, Lotto winningLotto) {
        return lottoNumberService.generateBonusNumber(number, winningLotto);
    }

    public List<String> generateResult(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        return resultService.resultProcess(user, winningLotto, bonusNumber);
    }
}

