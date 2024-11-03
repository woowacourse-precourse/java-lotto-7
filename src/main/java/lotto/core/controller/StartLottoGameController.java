package lotto.core.controller;

import java.util.List;
import lotto.commons.util.Command;
import lotto.commons.util.Repeat;
import lotto.core.constants.InputViewHeader;
import lotto.core.controller.request.StartLottoGameRequest;
import lotto.core.controller.request.StartLottoGameRequest.LottoPurchaseAmountRequest;
import lotto.core.controller.response.VoidResponse;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoNumberDto;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.dto.LottoResultDto;
import lotto.core.dto.LottoTicketDto;
import lotto.core.service.CreateBonusLottoNumberService;
import lotto.core.service.CreateWinningLottoService;
import lotto.core.service.MatchWinningLottoService;
import lotto.core.view.InputBonusLottoNumberView;
import lotto.core.view.InputWinningLottoView;
import lotto.core.view.MatchWinningLottoView;

public class StartLottoGameController implements Controller<StartLottoGameRequest, VoidResponse> {

    private final InputWinningLottoView inputWinningLottoView;

    private final InputBonusLottoNumberView inputBonusLottoNumberView;

    private final MatchWinningLottoView matchWinningLottoView;

    private final CreateWinningLottoService createWinningLottoService;

    private final CreateBonusLottoNumberService createBonusLottoNumberService;

    private final MatchWinningLottoService matchWinningLottoService;

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
    public VoidResponse request(StartLottoGameRequest request) {
        LottoTicketDto ticket = dtoAsRequest(request);
        LottoDto winningLotto = processInputWinningLotto();
        LottoNumberDto bonusNumber = processInputBonusLottoNumber(winningLotto);
        LottoResultDto winningResult = this.matchWinningLottoService.match(ticket, winningLotto, bonusNumber);
        this.matchWinningLottoView.display(winningResult);
        return VoidResponse.type();
    }

    private LottoTicketDto dtoAsRequest(StartLottoGameRequest request) {
        LottoPurchaseAmountRequest amountRequest = request.amount();
        LottoPurchaseAmountDto amount = new LottoPurchaseAmountDto(amountRequest.value(), amountRequest.lottoCount());
        List<LottoDto> lottos = request.lottos().stream().map(it -> new LottoDto(it.numbers())).toList();
        return new LottoTicketDto(amount, lottos);
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
