package lotto.Config;

import lotto.controller.LottoFactory;
import lotto.model.LottoRateCalculator;
import lotto.model.LottoGenerator;
import lotto.model.LottoWinningChecker;

public class LottoFactoryConfig {
    private static LottoFactoryConfig instance;

    private LottoFactoryConfig(){
    }

    public static LottoFactoryConfig getInstance() {
        if (instance == null) {
            instance = new LottoFactoryConfig();
        }
        return instance;
    }

    private LottoRateCalculator getLottoCalculator(){
        return new LottoRateCalculator();
    }

    private LottoGenerator getLottoGenerator(){
        return new LottoGenerator();
    }

    private LottoWinningChecker getLottoWinningChecker(){
        return new LottoWinningChecker();
    }

    public LottoFactory getLottoFactory() {
        return new LottoFactory(
                getLottoCalculator(),
                getLottoGenerator(),
                getLottoWinningChecker());
    }

}
