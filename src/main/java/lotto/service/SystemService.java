package lotto.service;

import lotto.domain.User;
import lotto.service.numbers.LottoService;
import lotto.service.result.ResultService;
import lotto.service.user.UserService;

public class SystemService {
    private final LottoService lottoService;
    private final ResultService resultService;
    private final UserService userService;

    public SystemService(LottoService lottoService, ResultService resultService, UserService userService) {
        this.lottoService = lottoService;
        this.resultService = resultService;
        this.userService = userService;
    }

    public User userProcess(String purchaseAmount) {
        return userService.userProcess(purchaseAmount);
    }
}
