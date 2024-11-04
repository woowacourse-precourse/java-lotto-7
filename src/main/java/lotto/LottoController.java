package lotto;

import lotto.error.SystemError;
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

        Payment payment = inputView.getPayment();
        long lottoCount = printLottoCount(payment);

        List<Lotto> lottos = publishLotto(lottoCount);

        DrawNumbers drawNumbers = inputView.getDrawNumbers();
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
        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private void setLottoPublisher() {
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        lottoPublisher = new LottoPublisher(lottoNumberGenerator);
    }
}
