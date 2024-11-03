package lotto.service;

import java.util.List;
import lotto.domain.LottoDrawer;
import lotto.domain.ResultDtoGenerator;
import lotto.domain.calculator.Calculator;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.dto.Lotto;
import lotto.dto.ResultDto;

public class LottoPurchaseManager {
    private Calculator calculator;
    private LottoDrawer lottoDrawer;
    private LottoGenerator lottoGenerator;
    private ResultDtoGenerator resultDtoGenerator;
    public LottoPurchaseManager(Calculator calculator, LottoDrawer lottoDrawer, LottoGenerator lottoGenerator, ResultDtoGenerator resultDtoGenerator){
        this.calculator = calculator;
        this.lottoDrawer = lottoDrawer;
        this.lottoGenerator = lottoGenerator;
        this.resultDtoGenerator = resultDtoGenerator;
    }

    public int checkNumberOfLotto(int purchaseAmount){
        return (int) calculator.calculate(purchaseAmount);
    }

    public List<Lotto> provideLottos(int numberOfLotto){
        List<List<Integer>> lottoNumbers = lottoDrawer.generateRandomValues(numberOfLotto);
        return (List<Lotto>) lottoGenerator.generateLottos(lottoNumbers);
    }

    public ResultDto provideResultDto(int purchaseAmount, List<Lotto> lottos){
        return resultDtoGenerator.generateResultDto(purchaseAmount, lottos);
    }
}
