package lotto.function.winning.checker;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.function.winning.checker.processor.LottoWinningPlaceCalculateProcessor;
import lotto.function.winning.checker.processor.LottoWinningStatisticsPrintProcessor;
import lotto.function.winning.checker.processor.LottoWinningTotalReturnPrintProcessor;
import lotto.repository.LottoRepository;
import lotto.repository.WinningLottoRepository;
import lotto.value.LottoValue;
import lotto.value.Rank;

public class LottoWinningDetailsChecker {

    private final WinningLottoRepository winningLottoRepository;
    private final LottoRepository lottoRepository;
    private final LottoWinningPlaceCalculateProcessor lottoWinningPlaceCalculateProcessor;
    private final LottoWinningStatisticsPrintProcessor lottoWinningStatisticsPrintProcessor;
    private final LottoWinningTotalReturnPrintProcessor lottoWinningTotalReturnPrintProcessor;

    public LottoWinningDetailsChecker(
            WinningLottoRepository winningLottoRepository,
            LottoRepository lottoRepository,
            LottoWinningPlaceCalculateProcessor lottoWinningPlaceCalculateProcessor,
            LottoWinningStatisticsPrintProcessor lottoWinningStatisticsPrintProcessor,
            LottoWinningTotalReturnPrintProcessor lottoWinningTotalReturnPrintProcessor
    ) {
        this.winningLottoRepository = winningLottoRepository;
        this.lottoRepository = lottoRepository;
        this.lottoWinningPlaceCalculateProcessor = lottoWinningPlaceCalculateProcessor;
        this.lottoWinningStatisticsPrintProcessor = lottoWinningStatisticsPrintProcessor;
        this.lottoWinningTotalReturnPrintProcessor = lottoWinningTotalReturnPrintProcessor;
    }

    public void run() {
        WinningLotto winningLotto = winningLottoRepository.findLast();
        List<Lotto> purchaseLottoList = lottoRepository.findAll();
        Map<Rank, Integer> winningPlaces =
                lottoWinningPlaceCalculateProcessor.calculateAll(winningLotto, purchaseLottoList);
        lottoWinningStatisticsPrintProcessor.printStatistics(winningPlaces);
        lottoWinningTotalReturnPrintProcessor.printTotalReturn(
                purchaseLottoList.size() * LottoValue.PRICE.value(),
                winningPlaces);
    }

}
