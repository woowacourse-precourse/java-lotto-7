package lotto.domain;

import java.util.List;

public class DefaultLottoFactory implements LottoFactory{
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public DefaultLottoFactory(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    @Override
    public Lotto createLotto( ) {
        List<Integer> lottoNumbers = lottoNumbersGenerator.generateNumbers();
        return new Lotto(lottoNumbers);
    }
}
