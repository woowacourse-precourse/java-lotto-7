package lotto.lottoapp.model;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningResult;
import lotto.lottoapp.model.value.WinningStatistics;
import lotto.lottoapp.model.value.Won;

public class Lottos {

    private final LottoNumbersGenerator lottoNumbersGenerator;

    private List<Lotto> lottos;
    private Won amountOfPaid;

    private Lottos(LottoNumbersGenerator lottoNumbersGenerator) {
        if (lottoNumbersGenerator == null) {
            throw new IllegalArgumentException("로또 구매 방식이 설정되지 않았습니다.");
        }

        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public static Lottos by(LottoNumbersGenerator lottoNumbersGenerator) {
        return new Lottos(lottoNumbersGenerator);
    }

    public void buyFor(Won amountOfPaid) {
        this.amountOfPaid = amountOfPaid;
        int numberOfLotto = Lotto.calculateCanBuyLotto(amountOfPaid);
        this.lottos = Lotto.issueLottosBy(numberOfLotto, lottoNumbersGenerator);
    }

    public List<LottoNumbers> getLottoNumbers() {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("구매한 로또가 없습니다.");
        }

        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .toList();
    }

    public WinningStatistics calculateWinningStatistics(WinningLotto winningLotto) {
        if (amountOfPaid == null || lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("계산할 로또가 없습니다.");
        }
        return new WinningStatistics(getWinningResults(winningLotto), amountOfPaid);
    }

    private Map<WinningResult, Long> getWinningResults(WinningLotto winningLotto) {
        Map<WinningResult, Long> lottosWinningCountMap = getLottosWinningCountMap(winningLotto);
        return WinningResult.orderedStream()
                .collect(toMap(
                        Function.identity(),
                        winningResult -> lottosWinningCountMap.getOrDefault(winningResult, 0L),
                        (a, b) -> a,
                        () -> new EnumMap<>(WinningResult.class)));
    }

    private Map<WinningResult, Long> getLottosWinningCountMap(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::drawLotto)
                .collect(groupingBy(Function.identity(),
                        () -> new EnumMap<>(WinningResult.class),
                        counting()));
    }

}
