package lotto.domain;

import lotto.Lotto;
import lotto.constant.OutputMessage;
import lotto.constant.Ranking;

import java.util.Collection;
import java.util.EnumMap;

public class Lottos {

    private final Collection<Lotto> elements;

    public Lottos(Collection<Lotto> elements) {
        this.elements = elements;
    }

    public String getLottoNumbersScreen() {
        StringBuilder sb = new StringBuilder();
        elements.forEach(value -> sb.append(value.getScreen()).append(OutputMessage.NEW_LINE.getMessage()));
        return sb.toString();
    }

    public int size() {
        return elements.size();
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult(new EnumMap<>(Ranking.class));
        elements.forEach(value -> result.increaseCount(value.getRanking(winningLotto)));
        return result;
    }
}
