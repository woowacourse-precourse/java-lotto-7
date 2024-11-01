package lotto.model;


import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Score> calculateScore(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> Score.calculateScore(lotto, winningLotto))
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> getAllLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
