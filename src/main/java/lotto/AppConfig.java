package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoSeller;
import lotto.domain.utils.NumbersGenerator;
import lotto.domain.utils.RandomNumbersGenerator;
import lotto.service.LottoService;

public class AppConfig {

    NumbersGenerator numbersGenerator() {
        return new RandomNumbersGenerator();
    }

    LottoMachine lottoMachine() {
        return new LottoMachine(numbersGenerator());
    }

    LottoSeller lottoSeller() {
        return new LottoSeller(lottoMachine());
    }

    LottoService lottoService() {
        return new LottoService(lottoSeller());
    }
}
