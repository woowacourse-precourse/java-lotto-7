package lotto.core.controller;

import lotto.commons.util.Command;
import lotto.commons.util.Repeat;
import lotto.core.constants.InputViewHeader;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.dto.LottoResultDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.service.CreateBonusLottoNumberService;
import lotto.core.service.CreateWinningLottoService;
import lotto.core.service.MatchWinningLottoService;
import lotto.core.view.InputBonusLottoNumberView;
import lotto.core.view.InputWinningLottoView;
import lotto.core.view.MatchWinningLottoView;

public class StartLottoGameController implements Controller<LottoTicketDto, Class<Void>> {

    private InputWinningLottoView inputWinningLottoView;

    private InputBonusLottoNumberView inputBonusLottoNumberView;

    private MatchWinningLottoView matchWinningLottoView;

    private CreateWinningLottoService createWinningLottoService;

    private CreateBonusLottoNumberService createBonusLottoNumberService;

    private MatchWinningLottoService matchWinningLottoService;

    public StartLottoGameController(InputWinningLottoView inputWinningLottoView,
                                    InputBonusLottoNumberView inputBonusLottoNumberView,
                                    MatchWinningLottoView matchWinningLottoView,
                                    CreateWinningLottoService createWinningLottoService,
                                    CreateBonusLottoNumberService createBonusLottoNumberService,
                                    MatchWinningLottoService matchWinningLottoService) {
        this.inputWinningLottoView = inputWinningLottoView;
        this.inputBonusLottoNumberView = inputBonusLottoNumberView;
        this.matchWinningLottoView = matchWinningLottoView;
        this.createWinningLottoService = createWinningLottoService;
        this.createBonusLottoNumberService = createBonusLottoNumberService;
        this.matchWinningLottoService = matchWinningLottoService;
    }

    @Override
    public Class<Void> request(LottoTicketDto ticket) {
        LottoDto winningLotto = processInputWinningLotto();
        LottoNumberDto bonusNumber = processInputBonusLottoNumber(winningLotto);
        LottoResultDto winningResult = this.matchWinningLottoService.match(ticket, winningLotto, bonusNumber);
        this.matchWinningLottoView.display(winningResult);
        return Void.class;
    }

    private LottoDto processInputWinningLotto() {
        this.inputWinningLottoView.display(InputViewHeader.IN_WINNING_LOTTO_VIEW);
        return Repeat.doWhile(5, () -> {
            String read = Command.read();
            return this.createWinningLottoService.create(read);
        });
    }

    private LottoNumberDto processInputBonusLottoNumber(LottoDto winningLotto) {
        this.inputBonusLottoNumberView.display(InputViewHeader.IN_BONUS_LOTTO_NUMBER_VIEW);
        return Repeat.doWhile(5, () -> {
            String read = Command.read();
            return this.createBonusLottoNumberService.create(read, winningLotto);
        });
    }
}
