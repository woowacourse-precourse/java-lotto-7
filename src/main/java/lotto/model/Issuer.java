package lotto.model;

import java.util.List;

public class Issuer {
    private LottoNumberGenerator lottoNumberGenerator;

    public Issuer() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    public Lotties issueLotties(int notIssuedlottiesCount) {
        Lotties lotties = new Lotties();
        while (notIssuedlottiesCount > 0) {
            List<Integer> numbers = lottoNumberGenerator.getNumbers();
            lotties.addLotto(numbers);
            notIssuedlottiesCount--;
        }
        return lotties;
    }
}
