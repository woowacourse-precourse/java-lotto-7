package lotto.model;

import java.util.List;

public class MyLotto {
    private final List<Lotto> lottos;

    public MyLotto(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public List<WinningType> checkWinningLotto(AnswerNumbers answerNumbers, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(answerNumbers, bonusNumber))
                .toList();
    }
}
