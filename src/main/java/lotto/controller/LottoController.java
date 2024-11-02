package lotto.controller;

import lotto.domain.Lottoes;
import lotto.dto.request.LottoCalculateRequest;
import lotto.dto.request.LottoGenerateRequest;
import lotto.dto.response.LottoCalculateResponse;
import lotto.dto.response.LottoGenerateResponse;
import lotto.service.LottoService;
import lotto.util.SingletonObjectProvider;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = SingletonObjectProvider.getSingletonObject(LottoService.class);
    }

    public LottoGenerateResponse createLottoes(LottoGenerateRequest request) {
        Lottoes lottoes = lottoService.createLottoes(request.money());
        return LottoGenerateResponse.from(lottoes);
    }

    public LottoCalculateResponse calculateLotto(LottoCalculateRequest request) {
        return lottoService.calculateLotto(request.lottoes(), request.lotto(), request.bonusNumber(), request.money());
    }
}
