package lotto.service;

import java.util.List;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.dto.WinningResultDto;

public class LottoWinningCheckService {

    public List<WinningResultDto> check(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .filter(LottoRank::isWinning)
                .map(WinningResultDto::from)
                .toList();
    }

//    public WinningStatisticsDto createStatistics(List<WinningResultDto> WinningResultDtos) {
//
//    }
}
