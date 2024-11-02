package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewControllerImpl implements ViewController {
    private static ViewControllerImpl viewController;
    private static OutputView outputView = OutputView.getInstance();
    private static InputView inputView = InputView.getInstance();

    public static ViewControllerImpl getInstance() {
        if (viewController == null) {
            viewController = new ViewControllerImpl();
        }
        return viewController;
    }


    @Override
    public void validateMoney(int money) {

    }

    @Override
    public void validateNumberSize(List<Integer> winningNumbers) {

    }
    public String getMoney(){
        outputView.printGuide();
        return inputView.readLine();
    }
}
