package lotto.back.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.global.enums.WinningLottoRank;
import lotto.global.exception.DuplicatedLottoNumberException;

public class LottoMatcher {
    private final List<Lotto> lottos;
    private final DrawnNumbers drawnNumbers;
    private final LottoNumber bonusNumber;

    public LottoMatcher(List<Lotto> lottos, DrawnNumbers drawnNumbers, LottoNumber bonusNumber) {
        validate(drawnNumbers, bonusNumber);
        this.lottos = lottos;
        this.drawnNumbers = drawnNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(DrawnNumbers drawnNumbers, LottoNumber bonusNumber) {
        List<Integer> joinedLottoNumbers = new ArrayList<>(drawnNumbers.getDrawnNumbers());
        joinedLottoNumbers.add(bonusNumber.getLottoNumber());

        if (joinedLottoNumbers.stream().distinct().count() != joinedLottoNumbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }

    //EnumMap을 사용하여 추첨 번호와 보너스 번호에 따라 등수를 count로 기록
    public Map<WinningLottoRank, Integer> getWinningResult() {
        Map<WinningLottoRank, Integer> winningCount = getEmptyWinningCount();

        lottos.forEach(lotto -> {
            // 각 로또에 대해 추첨번호, 보너스 번호와 일치하는 개수를 통해 LottoDrawRank을 가져옴
            Optional<WinningLottoRank> winningLottoRank = matchLotto(lotto);
            // 존재한다면 해당 등수의 카운트를 올림
            winningLottoRank.ifPresent(rank -> winningCount.put(rank, winningCount.get(rank) + 1));
        });

        return winningCount;
    }

    // 하나의 로또에 추첨 번호와 일치하는 개수와 보너스 번호와 일치하는 개수를 통해 Rank를 Optional로 반환
    private Optional<WinningLottoRank> matchLotto(Lotto lotto) {
        Integer drawnNumberMatchCount = lotto.getDrawnNumberMatchCount(drawnNumbers.getDrawnNumbers());
        Integer bonusNumberMatchCount = lotto.getBonusMatchCount(bonusNumber.getLottoNumber());

        return WinningLottoRank.getRankMatchedBy(drawnNumberMatchCount, bonusNumberMatchCount);
    }

    // 로또 당첨 개수를 저장하기 위한 빈 EnumMap을 반환
    private Map<WinningLottoRank, Integer> getEmptyWinningCount() {
        List<WinningLottoRank> winningLottoRanks = Arrays.stream(WinningLottoRank.values()).toList();
        EnumMap<WinningLottoRank, Integer> winningCount = new EnumMap<>(WinningLottoRank.class);
        //초기 count는 0
        winningLottoRanks.forEach(lottoDrawRank -> {
            winningCount.put(lottoDrawRank, 0);
        });

        return winningCount;
    }
}
