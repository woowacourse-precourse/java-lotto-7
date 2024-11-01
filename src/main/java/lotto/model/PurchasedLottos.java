package lotto.model;

import lotto.dto.WinningLottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottos {
    private List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public List<WinningLottoDto> calculateLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        return purchasedLottos.stream()
                .map(lotto -> {
                    long matchedNumbersCount = lotto.getMatchedNumbersCount(winningNumbers);
                    boolean isBonusMatched = lotto.checkBonusNumberMathced(bonusNumber);
                    return new WinningLottoDto(matchedNumbersCount, isBonusMatched);
                })
                .collect(Collectors.toList());
    }
}
