package lotto.model;

public class LottoMatchingMachine {
    private final Lotto winningLotto;
    private final Bonus bonus;

    public LottoMatchingMachine(Lotto winningLotto, Bonus bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public int match(Lotto lotto){
       long matchCount = lotto.getNumbers().stream()
               .filter(number -> winningLotto.getNumbers().contains(number))
               .count();
       return (int) matchCount;
    }

    public boolean isBonusMatch(Lotto lotto){
        long size =  lotto.getNumbers().stream()
                .filter(bonus::isMatch)
                .count();

        return size == 1; // 흠... 흠...
    }
}
