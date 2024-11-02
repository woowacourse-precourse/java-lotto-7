package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningNumber;
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
        return userService.generateUser(purchaseAmount);
    }

    public Lotto generateLotto(String number) {
        return lottoNumberService.generateWinningLotto(number);
    }

    public WinningNumber generateBonusNumber(String number, Lotto winningLotto) {
        return lottoNumberService.generateWinningNumberSet(number, winningLotto);
    }

    public List<String> generateResult(User user, WinningNumber winningNumber) {
        return resultService.resultProcess(user, winningNumber);
    }
}

