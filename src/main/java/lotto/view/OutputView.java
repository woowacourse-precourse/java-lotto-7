package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoResult;
import lotto.service.LottoStore;
import lotto.view.output.ConsoleWriter;
import lotto.view.output.Writer;

public class OutputView {

    private static final Writer DEFAULT_WRITER = new ConsoleWriter();

    private final Writer writer;

    public OutputView() {
        this(DEFAULT_WRITER);
    }

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printNumberOfLotto(LottoStore store) {
        System.out.println(store.getNumberOfLotto() + "개를 구매했습니다.");
    }

    public void printNumbers(LottoStore store) {
        List<Lotto> purchasedLottoNumbers = store.getPurchasedLotto();
        purchasedLottoNumbers.forEach(System.out::println);
        System.out.println();
    }

    public void printResults(LottoResult lottoResult) {
        String output = lottoResult.formatResults();
        double returnRate = lottoResult.getReturnRate();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(output);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }
}
