package lotto;

import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final LottoGenerator generator;
    private final LottoResultCalculator calculator;

    public LottoGame() {
        this.lottoInput = new LottoInput();
        this.lottoOutput = new LottoOutput();
        this.generator = new LottoGenerator();
        this.calculator = new LottoResultCalculator();
    }

    public void start() {
        // 구매 금액 입력
        int amount = lottoInput.inputPurchaseAmount();
        int count = amount / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> lottos = generator.generateLottos(count);
        lottoOutput.printPurchasedLottos(count, lottos);

        // 당첨 번호 입력
        List<Integer> winningNumbers = lottoInput.inputWinningNumbers();
        int bonusNumber = lottoInput.inputBonusNumber(winningNumbers);

        // 당첨 결과 계산 및 출력
        WinningResult result = calculator.calculateResult(lottos, winningNumbers, bonusNumber);
        lottoOutput.printWinningStatistics(result);

        double returnRate = calculator.calculateReturnRate(result, amount);
        lottoOutput.printReturnRate(returnRate);
    }
}