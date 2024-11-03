package lotto.view.input.mock;

import java.util.LinkedList;
import java.util.List;
import lotto.view.input.InputView;

public class MockInputView extends InputView {

    private final LinkedList<String> inputs;

    public MockInputView(List<String> inputs) {
        this.inputs = new LinkedList<>(inputs);
    }

    @Override
    protected String inputPurchaseAmount() {
        return inputs.poll();
    }

    @Override
    protected List<String> inputWinningNumber() {
        String input = inputs.poll();
        return List.of(input.split(","));
    }

    @Override
    protected String inputBonusNumber() {
        return inputs.poll();
    }
}
