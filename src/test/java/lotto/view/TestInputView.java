package lotto.view;

public class TestInputView extends InputView {
    private final String[] inputs;
    private int index = 0;

    public TestInputView(String... inputs) {
        this.inputs = inputs;
    }

    @Override
    public String promptPurchaseAmount() {
        if (index >= inputs.length) {
            throw new IllegalStateException("No more inputs available");
        }
        return inputs[index++];
    }
}
