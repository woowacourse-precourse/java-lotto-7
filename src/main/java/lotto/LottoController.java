package lotto;

import java.util.List;

/**
 * 로또 게임의 전체적인 흐름을 관리하는 클래스
 * 사용자 입력, 로또 생성, 결과 계산 및 출력을 컨트롤
 */
public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;
    private final LottoGenerator generator;
    private final LottoResultCalculator calculator;

    public LottoController() {
        this.lottoInput = new LottoInput();
        this.lottoOutput = new LottoOutput();
        this.generator = new LottoGenerator();
        this.calculator = new LottoResultCalculator();
    }

    /**
     * 로또 프로그램 실행
     * 1. 구매 금액 입력
     * 2. 로또 티켓 발행
     * 3. 당첨 번호 입력
     * 4. 결과 계산 및 출력
     */
    public void start() {
        // 구매 금액 입력
        int amount = lottoInput.inputPurchaseAmount();
        int count = amount / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> lottos = generator.generateLottos(count);
        lottoOutput.printLottos(count, lottos);

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