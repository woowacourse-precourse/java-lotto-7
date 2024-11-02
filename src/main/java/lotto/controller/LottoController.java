package lotto.controller;

import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoGameDto;
import lotto.service.LottoGameService;
import lotto.viewHandler.ViewHandler;
import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.input.InputDto;
import lotto.viewHandler.api.dto.input.MoneyDto;

import java.util.List;

public class LottoController {
    private final LottoGameService lottoGameService;
    private final ViewHandler viewHandler;

    public LottoController(LottoGameService lottoGameService, ViewHandler viewHandler) {
        this.lottoGameService = lottoGameService;
        this.viewHandler = viewHandler;
    }

    public void lottoStart() {
        Api<InputDto> inputDtoApi = viewHandler.inputHandler();
        InputDto inputDto = inputDtoApi.getData();
        PurchaseLottos purchaseLottos = purchaseLotto(inputDto);
        WinningLotto winningLotto = createWinningLottoDto(inputDto);

        lottoGameService.game(createGameDto(purchaseLottos, winningLotto));
    }

    private PurchaseLottos purchaseLotto(InputDto inputDto) {
        MoneyDto moneyDto = inputDto.getMoneyDto();
        return PurchaseLottos.of(moneyDto.getMoney());
    }

    private WinningLotto createWinningLottoDto(InputDto inputDto) {
        List<Integer> winningLotto = inputDto.getWinningLottoNumbersDto().getNumbers();
        Integer bonusNumber = inputDto.getBonusNumberDto().getNumber();
        return WinningLotto.of(winningLotto, bonusNumber);
    }

    private LottoGameDto createGameDto(PurchaseLottos purchaseLottos, WinningLotto winningLotto) {
        return new LottoGameDto(purchaseLottos, winningLotto);
    }
}
