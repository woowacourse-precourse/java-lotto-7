package controller;

import domain.User;
import view.InputView;
import view.OutputView;

public class Controller {
    User user;

    public void run() {
        buying();
        quantity();
    }

    private void buying() {
        OutputView.outBuyingPriceView(); //구입 금액을 입력해주세요.
        try {
            user = new User(InputView.inputBuyingPriceView());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수만 입력 가능합니다.");
            buying();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000원 단위만 입력 가능합니다.");
            buying();
        }
    }

    private void quantity() {
        OutputView.outBuyingQuantityView(user.getBuyingQuantity());
    }


}
