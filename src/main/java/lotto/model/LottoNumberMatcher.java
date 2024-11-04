package lotto.model;

import lotto.enums.LottoPrices;

import java.util.HashSet;
import java.util.List;

public class LottoNumberMatcher {
    public LottoPrices match(Lotto givenLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> givenLottoNumbers = givenLotto.getNumbers();
        HashSet<Integer> winningNumberSet = new HashSet<>(winningLotto.getNumbers());

        int count = (int) givenLottoNumbers.stream().filter(winningNumberSet::contains).count();
        return LottoPrices.findPriceByMatchCount(count, givenLottoNumbers.contains(bonusNumber));
    }

    public List<LottoPrices> matchAll(List<Lotto> givenLottos, Lotto winningLotto, int bonusNumber) {
        return givenLottos.stream()
                .map(lotto -> match(lotto, winningLotto, bonusNumber))
                .filter(price -> !price.equals(LottoPrices.NOT_EARN)).toList();
    }
}
