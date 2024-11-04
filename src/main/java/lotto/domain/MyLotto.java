package lotto.domain;

public class MyLotto {
    private final Lotto myLotto;
    private final Integer bonusNumber;

    public MyLotto(final Lotto winningNumbers, final Integer bonusNumber) {
        this.myLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer getMatchCount(Lotto generatedLotto) {
        return (int) generatedLotto.getNumbers().stream()
                .filter(num -> myLotto.getNumbers().contains(num))
                .count();
    }

    public boolean hasBonus(Lotto generatedLotto) {
        return generatedLotto.getNumbers().contains(bonusNumber);
    }

}
