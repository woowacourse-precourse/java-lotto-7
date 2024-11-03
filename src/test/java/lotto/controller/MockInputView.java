package lotto.controller;

import lotto.view.InputView;

public class MockInputView implements InputView {

    private String input;

    public MockInputView() {
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String getInputPrice() {
        return input;
    }

    @Override
    public String getWinningComponent() {
        return input;
    }

    @Override
    public String getBonusComponent() {
        return input;
    }
}
