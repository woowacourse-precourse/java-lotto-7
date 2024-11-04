package lotto.domain.ticket;

import java.util.List;

public class DefaultLottoFactory implements LottoFactory{
    private final NumbersGenerator lottoNumbersGenerator;

    public DefaultLottoFactory(NumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    @Override
    public Lotto createLotto( ) {
        List<Integer> lottoNumbers = lottoNumbersGenerator.generate();
        return new Lotto(lottoNumbers);
    }
}
