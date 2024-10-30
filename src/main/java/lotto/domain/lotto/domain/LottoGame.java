package lotto.domain.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private final List<Lotto> purchasedLottos;
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;
    private final Map<LottoResult, Integer> results;

    public LottoGame(
            List<Lotto> purchasedLottos,
            List<LottoNumber> winningNumbers,
            LottoNumber bonusNumber,
            Map<LottoResult, Integer> results
    ) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.results = results;
    }

    public static LottoGame of(
            final List<Lotto> purchasedLottos,
            final List<LottoNumber> winningNumbers,
            final int bonusNumber,
            final Map<LottoResult, Integer> results
    ) {
        return new LottoGame(
                purchasedLottos,
                winningNumbers,
                LottoNumber.from(bonusNumber),
                results
        );
    }


    public static List<Lotto> from(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }


}
