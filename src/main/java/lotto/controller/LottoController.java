package lotto.controller;

import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;
import lotto.model.statistic.LottoStatisticsDto;
import lotto.model.user.LottoResultDto;
import lotto.service.LottoAdministratorService;
import lotto.service.LottoUserService;

public class LottoController {

    private final LottoUserService userService;
    private final LottoAdministratorService administratorService;

    public LottoController(
            LottoUserService userService,
            LottoAdministratorService administratorService
    ) {
        this.userService = userService;
        this.administratorService = administratorService;
    }

    public LottoResultDto buyLotto(final String insertedMoney) {
        return userService.createLottoResult(insertedMoney);
    }

    public Lotto setWinningNumbers(final String winningNumbers) {
        return administratorService.setWinningNumbers(winningNumbers);
    }

    public LottoBonusNumber setBonusNumber(final String bonusNumber) {
        return administratorService.setBonusNumber(bonusNumber);
    }

    public LottoStatisticsDto getStatistics(
            final LottoResultDto lottoResultDto,
            final Lotto winningNumbers,
            final LottoBonusNumber bonusNumber
    ) {
        return userService.fetchStatistics(
                lottoResultDto,
                winningNumbers,
                bonusNumber
        );
    }
}
