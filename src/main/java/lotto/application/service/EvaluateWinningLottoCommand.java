package lotto.application.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.application.dto.request.EvaluateWinningLottoRequest;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.WinningLottoEvaluator;
import lotto.domain.lotto.vo.LottoPrize;

public class EvaluateWinningLottoCommand implements EvaluateWinningLottoUsecase {

    private final WinningLottoEvaluator winningLottoEvaluator;
    private final LottoRepository lottoRepository;

    public EvaluateWinningLottoCommand(WinningLottoEvaluator winningLottoEvaluator,
        LottoRepository lottoRepository) {
        this.winningLottoEvaluator = winningLottoEvaluator;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public EvaluateWinningLottoResponse execute(EvaluateWinningLottoRequest request) {
        List<Lotto> lottos = getLottos();

        List<LottoPrize> prizes = evaluatePrizes(lottos, request.winningNumber());
        Map<LottoPrize, Integer> prizeStatistics = calculatePrizeStatistics(prizes);
        double earningRate = calculateYieldRate(prizes, lottos.size());

        return new EvaluateWinningLottoResponse(prizeStatistics, earningRate);
    }

    private List<Lotto> getLottos() {
        return lottoRepository.findAll();
    }

    private List<LottoPrize> evaluatePrizes(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
            .map(lotto -> winningLottoEvaluator.evaluate(winningNumber, lotto))
            .collect(Collectors.toList());
    }

    private Map<LottoPrize, Integer> calculatePrizeStatistics(List<LottoPrize> prizes) {
        Map<LottoPrize, Integer> statistics = initializePrizeStatistics();
        prizes.forEach(prize -> statistics.put(prize, statistics.get(prize) + 1));
        return statistics;
    }

    private Map<LottoPrize, Integer> initializePrizeStatistics() {
        Map<LottoPrize, Integer> statistics = new EnumMap<>(LottoPrize.class);

        for (LottoPrize prize : LottoPrize.values()) {
            statistics.put(prize, 0);
        }

        return statistics;
    }

    private double calculateYieldRate(List<LottoPrize> prizes, int totalLottos) {
        double totalPrizeAmount = prizes.stream()
            .mapToDouble(LottoPrize::getPrizeAmount)
            .sum();

        return (totalPrizeAmount / (totalLottos * 1000.0)) * 100;
    }
}
