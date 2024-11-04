package lotto.application.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.application.dto.request.EvaluateWinningLottoRequest;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.WinningLottoEvaluator;

public class EvaluateWinningLottoCommand implements EvaluateWinningLottoUsecase {

    private final WinningLottoEvaluator winningLottoEvaluator;
    private final LottoRepository lottoRepository;

    public EvaluateWinningLottoCommand(WinningLottoEvaluator winningLottoEvaluator,
        LottoRepository lottoRepository) {
        this.winningLottoEvaluator = winningLottoEvaluator;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public EvaluateWinningLottoResponse execute(
        EvaluateWinningLottoRequest evaluateWinningLottoRequest) {
        List<Lotto> lottos = lottoRepository.findAllByBuyerId(
            evaluateWinningLottoRequest.buyerId());

        return new EvaluateWinningLottoResponse(
            lottos.stream()
            .map(lotto -> winningLottoEvaluator.evaluate(evaluateWinningLottoRequest.winningNumber(), lotto))
            .collect(Collectors.toList())
        );
    }

}
