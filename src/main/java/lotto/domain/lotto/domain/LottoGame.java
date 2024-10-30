package lotto.domain.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private final List<Lotto> purchasedLottos;
    private final List<LottoNumber> winningLottos;
    private final LottoNumber bonusNumber;
    private final Map<LottoResult, Integer> results;

    public LottoGame(
            List<Lotto> purchasedLottos,
            List<LottoNumber> winningLottos,
            LottoNumber bonusNumber,
            Map<LottoResult, Integer> results
    ) {
        this.purchasedLottos = purchasedLottos;
        this.winningLottos = winningLottos;
        this.bonusNumber = bonusNumber;
        this.results = results;
    }

    public static LottoGame of(
            final List<List<Integer>> purchasedNumbers,
            final List<Integer> winningNumbers,
            final int bonusNumber,
            final Map<LottoResult, Integer> results
    ) {
        return new LottoGame(
                convertToLottos(purchasedNumbers),
                convertToLottoNumbers(winningNumbers),
                LottoNumber.from(bonusNumber),
                results
        );
    }



    private static List<Lotto> convertToLottos(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(Lotto::from)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }




}
