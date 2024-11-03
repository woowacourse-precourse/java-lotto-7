package lotto.model;

public record WinningNumbers(Lotto mainNumbers, BonusNumber bonusNumber) {
    public Prize checkPrize(final Lotto lotto) {
        int matchedCount = countMatchedCount(lotto);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber.value());
        return Prize.getPrize(matchedCount, hasBonus);
    }

    private int countMatchedCount(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(mainNumbers.getNumbers()::contains)
                .count();
    }
}
