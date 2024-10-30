package lotto.service;

import lotto.domain.User;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.OutputView.ENTER_PURCHASE_PRICE;

public class UserService {
    // 싱글톤 패턴
    private static final UserService instance = new UserService();

    private UserService() {

    }

    public static UserService getInstance() {
        return instance;
    }

    public int inputPurchasePrice() {
        OutputView.printMessage(ENTER_PURCHASE_PRICE);
        String purchasePrice = InputView.readLine();
        isValidPurchasePrice(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    public void save(int purchasePrice) {
        User user = new User(purchasePrice);
    }

    private void isValidPurchasePrice(String purchasePrice) {
        InputValidator.run(purchasePrice);
    }

}
