package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.WinningCategory.*;

public class WinningStatistics {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<WinningCategory, Integer> statistics = new HashMap<>();

    public WinningStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private boolean hasBonus(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .anyMatch(number -> number == bonusNumber);
    }

    private int getMatchCount(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .filter(number -> winningLotto.getLottoNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .toList()
                .size();
    }

    private WinningCategory determineCategory(Lotto lotto, int matchCount, boolean hasBonus) {
        for (WinningCategory category : WinningCategory.values()) {
            if (category.getMatchCount() == matchCount && category.hasBonus() == hasBonus) {
                return category;
            }
        }
        return NO_WIN;
    }

    private WinningCategory getWinningCategory(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean hasBonus = hasBonus(lotto);
        return determineCategory(lotto, matchCount, hasBonus);
    }

}
