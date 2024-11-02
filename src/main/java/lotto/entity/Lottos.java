package lotto.entity;

import lotto.enums.Prize;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    /**
     * 당첨 번호와 보너스 번호를 사용하여 각 로또의 당첨 결과를 계산합니다.
     *
     * @param winningNumbers 당첨 번호와 보너스 번호를 포함하는 객체
     * @return 각 로또의 당첨 결과 리스트
     */
    public List<Prize> calculateResults(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> {
                    int matchCount = lotto.countMatchingNumbers(winningNumbers.getNumbers());
                    boolean bonusMatch = lotto.hasBonusNumber(winningNumbers.getBonusNumber());
                    return Prize.valueOf(matchCount, bonusMatch);
                })
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
