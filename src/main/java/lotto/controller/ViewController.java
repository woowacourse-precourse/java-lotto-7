package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewController {
    private static ViewController viewController;
    private static OutputView outputView = OutputView.getInstance();
    private static InputView inputView = InputView.getInstance();

    public static ViewController getInstance() {
        if (viewController == null) {
            viewController = new ViewController();
        }
        return viewController;
    }

    public String getMoney(){
        outputView.printGuide();
        return inputView.readLine();
    }
}
