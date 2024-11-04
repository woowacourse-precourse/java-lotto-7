package lotto;

import java.util.List;

public class LottoController {
    private final Input inputHandler;
    private final LottoPurchase lottoPurchase;
    private final ResultCalculator resultCalculator;
    private final Output outputHandler;

    // 의존관계 생성자주입
    public LottoController(Input inputHandler,
                           LottoPurchase purchase,
                           ResultCalculator resultCalculator,
                           Output outputHandler
                    ) {

        this.inputHandler = inputHandler;
        this.lottoPurchase = purchase;
        this.resultCalculator = resultCalculator;
        this.outputHandler = outputHandler;
    }

    // 게임실행
    public void play() {
        int payment = requestPayment();
        List<Lotto> lottos = purchaseLottos(payment);
        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber();
        displayResults(lottos, winningNumbers, bonusNumber, payment);
    }

    private List<Lotto> purchaseLottos(int payment) {
        List<Lotto> lottos = lottoPurchase.purchase(payment);
        outputHandler.printLottoNumberList(lottos);
        return lottos;
    }

    private void displayResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int payment) {
        int[] results = resultCalculator.calculateResult(lottos, winningNumbers, bonusNumber);
        float profit = resultCalculator.calculateProfit(results, payment);
        outputHandler.printTotalResult(results);
        outputHandler.printProfit(profit);
    }

    private int requestPayment() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return inputHandler.inputPayment();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> requestWinningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                return inputHandler.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                return inputHandler.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
