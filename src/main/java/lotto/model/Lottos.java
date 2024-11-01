package lotto.model;


import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Score> calculateResult(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> Score.calculateScore(lotto, winningLotto))
                .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<List<LottoNumber>> getAllLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
