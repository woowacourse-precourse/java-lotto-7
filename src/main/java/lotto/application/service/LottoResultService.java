package lotto.application.service;

import java.util.List;
import lotto.application.LottoResultUseCase;
import lotto.application.service.vo.MatchingInfo;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinLotto;
import lotto.domain.WinResult;
import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.WinLottoRepository;
import lotto.domain.repository.WinResultHistory;

public class LottoResultService implements LottoResultUseCase {

    private final WinLottoRepository winLottoRepository;
    private final WinResultHistory winResultHistory;
    private final LottoRepository lottoRepository;
    private final LottoMatcher lottoMatcher;

    public LottoResultService(
            WinLottoRepository winLottoRepository,
            WinResultHistory winResultHistory,
            LottoRepository lottoRepository,
            LottoMatcher lottoMatcher
    ) {
        this.winLottoRepository = winLottoRepository;
        this.winResultHistory = winResultHistory;
        this.lottoRepository = lottoRepository;
        this.lottoMatcher = lottoMatcher;
    }

    @Override
    public void createWinLotto(List<Integer> numbers, int bonusNumber) {
        WinLotto winLotto = WinLotto.of(Lotto.create(numbers), bonusNumber);
        winLottoRepository.save(winLotto);
    }

    @Override
    public void checkWinning() {
        WinLotto winLotto = winLottoRepository.getRecent();
        List<Lotto> lottos = lottoRepository.getAll();
        WinResult winResult = WinResult.create();
        lottos.forEach(lotto -> {
            MatchingInfo matchingInfo = lottoMatcher.checkMatchCount(winLotto, lotto);
            LottoRank lottoRank = LottoRank.findByMatchingInfo(matchingInfo);
            if (lottoRank != null) {
                winResult.plusCount(lottoRank.name());
            }
        });
        winResultHistory.add(winResult);
    }

    @Override
    public WinResult getWinResult() {
        return winResultHistory.getRecent();
    }
}
