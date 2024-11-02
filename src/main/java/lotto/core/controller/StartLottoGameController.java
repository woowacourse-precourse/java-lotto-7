package lotto.core.controller;

import lotto.commons.command.Command;
import lotto.commons.handler.Repeat;
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

public class StartLottoGameController implements Controller<LottoTicketDto, Void> {

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
    public Void request(LottoTicketDto ticket) {
        LottoDto winningLotto = processInputWinningLotto();
        LottoNumberDto bonusNumber = processInputBonusLottoNumber(winningLotto);
        LottoResultDto winningResult = processMatchLotto(ticket, winningLotto, bonusNumber);
        displayLottoResult(winningResult);
        return null;
    }

    private LottoDto processInputWinningLotto() {
        this.inputWinningLottoView.display("당첨 번호를 입력해 주세요.");
        return Repeat.doWhile(5, () -> {
            String read = Command.read();
            return this.createWinningLottoService.create(read);
        });
    }

    private LottoNumberDto processInputBonusLottoNumber(LottoDto winningLotto) {
        this.inputBonusLottoNumberView.display("보너스 번호를 입력해 주세요.");
        return Repeat.doWhile(5, () -> {
            String read = Command.read();
            return this.createBonusLottoNumberService.create(read, winningLotto);
        });
    }

    private LottoResultDto processMatchLotto(LottoTicketDto ticket,
                                             LottoDto winningLotto,
                                             LottoNumberDto bonusNumber) {
        return this.matchWinningLottoService.match(ticket, winningLotto, bonusNumber);
    }

    private void displayLottoResult(LottoResultDto result) {
        this.matchWinningLottoView.display(result);
    }
}
