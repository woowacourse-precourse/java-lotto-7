package lotto;

public class LottoChecker {

    public static int getMatchCount(Lotto issuedLotto, Lotto winningLotto) {
        return (int) issuedLotto.getNumbers().stream()
                .filter(i -> winningLotto.getNumbers().contains(i))
                .count();
    }

}
