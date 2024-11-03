package lotto.controller;

import java.util.List;
import lotto.util.ExceptionMessage;
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
    public Integer validateMoney(int money) {
        int lottoCount = money % 1000;
        if (lottoCount != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR);
        }
        return money/1000;
    }

    @Override
    public void validateNumberSize(List<Integer> winningNumbers) {

    }
    public Integer getMoney(){
        outputView.printGuide();
        String money =  inputView.readLine();
        return this.validateMoney(Integer.parseInt(money));
    }
}
