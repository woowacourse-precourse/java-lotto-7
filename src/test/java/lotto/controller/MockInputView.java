package lotto.controller;

import lotto.view.InputView;

public class MockInputView<T> implements InputView {

    private T input;

    public MockInputView() {
    }

    public void setInput(T input) {
        this.input = input;
    }

    @Override
    public String getInputPrice() {
        return input.toString();
    }

    @Override
    public String getWinningComponent() {
        return input.toString();
    }

    @Override
    public String getBonusComponent() {
        return input.toString();
    }
}
