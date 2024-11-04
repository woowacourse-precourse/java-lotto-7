package lotto.model.lotto;

import lotto.model.generator.NumberGenerator;
import lotto.model.match.Match;
import lotto.model.match.Matches;
import lotto.model.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(Money money, NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money.getCount();
        for (int index = 0; index < lottoCount; index++) {
            Lotto radomLotto = Lotto.from(numberGenerator);
            lottos.add(radomLotto);
        }
        return new Lottos(lottos);
    }

    public Matches matchingLotto(Lotto lotto, Bonus bonus) {
        List<Match> matches = lottos.stream().map(lottoNumbers -> lottoNumbers.compareTo(lotto, bonus)).toList();
        return new Matches(matches);
    }

    private boolean isAllMatch(Lotto comparedLotto) {
        return lottos.stream().allMatch(lotto -> lotto.isAllMatch(comparedLotto));
    }

    public int getSize() {
        return lottos.size();
    }

    @Override
    public int hashCode() {
        return lottos.stream().mapToInt(Lotto::hashCode).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) obj;
        boolean isEqualSize = getSize() == lottos.getSize();
        return isEqualSize && this.lottos.stream().allMatch(lottos::isAllMatch);
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
