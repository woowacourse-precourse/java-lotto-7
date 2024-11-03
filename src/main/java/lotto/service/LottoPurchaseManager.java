package lotto.service;

import java.util.List;
import lotto.domain.LottoDrawer;
import lotto.domain.calculator.Calculator;
import lotto.domain.lottoGeneratir.LottoGenerator;
import lotto.dto.ReceiptAndLottoDto;
import lotto.dto.entity.Lotto;
import lotto.dto.entity.Receipt;

public class LottoPurchaseManager {
    private Calculator calculator;
    private LottoDrawer lottoDrawer;
    private LottoGenerator lottoGenerator;

    public LottoPurchaseManager(Calculator calculator, LottoDrawer lottoDrawer, LottoGenerator lottoGenerator) {
        this.calculator = calculator;
        this.lottoDrawer = lottoDrawer;
        this.lottoGenerator = lottoGenerator;
    }

    public int checkNumberOfLotto(int purchaseAmount) {
        return (int) calculator.calculate(purchaseAmount);
    }

    public List<Lotto> provideLottos(int numberOfLotto) {
        List<List<Integer>> lottoNumbers = lottoDrawer.generateRandomValues(numberOfLotto);
        return (List<Lotto>) lottoGenerator.generateLottos(lottoNumbers);
    }

    public ReceiptAndLottoDto provideResultDto(int purchaseAmount, List<Lotto> lottos) {
        return new ReceiptAndLottoDto(new Receipt(purchaseAmount), lottos);
    }
}
