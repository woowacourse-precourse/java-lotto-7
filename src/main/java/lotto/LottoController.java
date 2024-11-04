package lotto;

import lotto.model.payment.Payment;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoChecker;
import lotto.model.lotto.LottoPublisher;
import lotto.model.draw_numbers.DrawNumbers;
import lotto.model.draw_numbers.builder.DrawNumbersBuilder;
import lotto.model.number_generator.LottoNumberGenerator;
import lotto.model.number_generator.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoChecker lottoChecker;
    private LottoPublisher lottoPublisher;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buyLotto() {
        setLottoPublisher();

        Payment payment = getPayment();
        long lottoCount = printLottoCount(payment);
        List<Lotto> lottos = publishLotto(lottoCount);

        DrawNumbers drawNumbers = getDrawNumbers();
        lottoChecker = new LottoChecker(drawNumbers);
        printResult(lottos, lottoCount);
    }

    private List<Lotto> publishLotto(long lottoCount) {
        List<Lotto> lottos = lottoPublisher.publishLotto(lottoCount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private void printResult(List<Lotto> lottos, long lottoCount) {
        double revenueRate = lottoChecker.calcRevenueRate(lottos, lottoCount);
        System.out.println(outputView.resultToString(revenueRate));
    }

    private long printLottoCount(Payment payment) {
        long lottoCount = payment.calcLottoCount();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private void setLottoPublisher() {
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        lottoPublisher = new LottoPublisher(lottoNumberGenerator);
    }

    private Payment getPayment() {
        Payment payment = null;
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            try {
                payment = inputView.getPayment();
                isInvalidInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return payment;
    }

    private DrawNumbers getDrawNumbers() {
        DrawNumbersBuilder builder = new DrawNumbersBuilder();

        builder = buildWinningNumber(builder);
        builder = buildBonusNumber(builder);

        return builder.build();
    }

    private DrawNumbersBuilder buildWinningNumber(DrawNumbersBuilder builder) {
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            try {
                builder = inputView.getWinningNumbers(builder);
                isInvalidInput = false;
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return builder;
    }

    private DrawNumbersBuilder buildBonusNumber(DrawNumbersBuilder builder) {
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            try {
                builder = inputView.getBonusNumber(builder);
                isInvalidInput = false;
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return builder;
    }
}
