package lotto.core.controller;

import lotto.commons.command.Command;
import lotto.commons.handler.Handler;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.service.CreateBonusLottoNumberService;
import lotto.core.service.CreateWinningLottoService;
import lotto.core.view.InputBonusLottoNumberView;
import lotto.core.view.InputWinningLottoView;

public class StartLottoGameController implements Controller<LottoTicketDto, Void> {

    private InputWinningLottoView inputWinningLottoView;

    private InputBonusLottoNumberView inputBonusLottoNumberView;

    private CreateWinningLottoService createWinningLottoService;

    private CreateBonusLottoNumberService createBonusLottoNumberService;

    public StartLottoGameController(InputWinningLottoView inputWinningLottoView,
                                    InputBonusLottoNumberView inputBonusLottoNumberView,
                                    CreateWinningLottoService createWinningLottoService,
                                    CreateBonusLottoNumberService createBonusLottoNumberService) {
        this.inputWinningLottoView = inputWinningLottoView;
        this.inputBonusLottoNumberView = inputBonusLottoNumberView;
        this.createWinningLottoService = createWinningLottoService;
        this.createBonusLottoNumberService = createBonusLottoNumberService;
    }

    @Override
    public Void request(LottoTicketDto dto) {
        LottoDto winningLotto = processInputWinningLotto();
        LottoNumberDto bonusNumber = processInputBonusLottoNumber(winningLotto);

        return null;
    }

    private LottoDto processInputWinningLotto() {
        LottoDto lotto;
        do {
            lotto = Handler.runCatching(() -> {
                this.inputWinningLottoView.display("당첨 번호를 입력해 주세요.");
                String read = Command.read();
                return this.createWinningLottoService.create(read);
            });
        } while (lotto == null);
        return null;
    }

    private LottoNumberDto processInputBonusLottoNumber(LottoDto winningLotto) {
        LottoNumberDto bonusNumber;
        do {
            bonusNumber = Handler.runCatching(() -> {
                this.inputBonusLottoNumberView.display("보너스 번호를 입력해 주세요.");
                String read = Command.read();
                return this.createBonusLottoNumberService.create(read, winningLotto);
            });
        } while (bonusNumber == null);
        return bonusNumber;
    }
}
