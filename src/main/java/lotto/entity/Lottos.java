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
                    int matchCount = lotto.countMatchingNumbers(winningNumbers.getMainNumbers());
                    boolean bonusMatch = lotto.hasBonusNumber(winningNumbers.getBonusNumber());
                    return Prize.valueOf(matchCount, bonusMatch);
                })
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    /**
     * 로또 번호 리스트를 출력 가능한 문자열 형식으로 반환합니다.
     *
     * @return 로또 번호 리스트의 문자열 표현
     */
    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}