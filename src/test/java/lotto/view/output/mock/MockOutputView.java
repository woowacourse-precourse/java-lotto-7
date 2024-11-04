package lotto.view.output.mock;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.view.output.OutputView;

public class MockOutputView implements OutputView {

    private final List<Object> output = new ArrayList<>();

    @Override
    public void printPurchaseResults(final List<Lotto> lottos) {
        output.add(lottos);
    }

    @Override
    public void printStatisticsResults(final Statistics statistics) {
        output.add(statistics);
    }

    @Override
    public void printErrorMessage(final String message) {
        output.add(message);
    }

    public List<Object> getOutput() {
        return new ArrayList<>(output);
    }
}
