package lotto.model;

import java.util.List;

public class Issuer {
    private LottoNumbersGenerator lottoNumbersGenerator;

    public Issuer() {
        lottoNumbersGenerator = new LottoNumbersGenerator();
    }

    public Lottos issueLottos(int notIssuedlottosCount) {
        Lottos lottos = new Lottos();
        while (notIssuedlottosCount > 0) {
            List<Integer> numbers = lottoNumbersGenerator.getLottoNumbers();
            lottos.addLotto(numbers);
            notIssuedlottosCount--;
        }
        return lottos;
    }
}
