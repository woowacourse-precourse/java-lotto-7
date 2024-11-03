package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.service.LottoStatisticsService;
import lotto.service.UserService;

public class LottoController {
    private final UserService userService;
    private final LottoService lottoService;
    private final LottoStatisticsService lottoStatisticsService;

    public LottoController() {
        this.userService = new UserService();
        this.lottoService = new LottoService();
        this.lottoStatisticsService = new LottoStatisticsService();
    }

    public void run() {
        User user = setUser();
        Lotto lotto = setLotto();
        statisticsLotto(user, lotto);
    }

    public User setUser() {
        return userService.setUser();
    }

    public Lotto setLotto() {
        return lottoService.setLotto();
    }

    public void statisticsLotto(User user, Lotto lotto) {
        lottoStatisticsService.winningStatistics(user, lotto);
    }
}
