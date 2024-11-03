package domain.lotto;

import domain.statistics.WinningRank;
import domain.winning.WinningLotto;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public int size() {
        return lottoGroup.size();
    }

    public void compare(WinningLotto winningLotto) {
        lottoGroup.forEach(lotto -> WinningRank.match(
                calculateWinnings(lotto, winningLotto), hasBonus(lotto, winningLotto)
        ));
    }

    public int calculateWinnings(Lotto lotto, WinningLotto winningLotto) {
        return lotto.matchNumbers(winningLotto);
    }

    public boolean hasBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.matchBonus(winningLotto);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Lottos lottos)) {
            return false;
        }
        return Objects.equals(lottoGroup, lottos.lottoGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoGroup);
    }

    @Override
    public String toString() {
        return lottoGroup.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
