package lotto.service;

import lotto.domain.User;
import lotto.domain.UserRepository;
import lotto.view.ErrorOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.OutputView.ENTER_PURCHASE_PRICE;
import static lotto.view.OutputView.EXIT_APPLICATION;

public class UserService {
    // 싱글톤 패턴
    private static final UserService instance = new UserService();
    private final UserRepository userRepository = UserRepository.getInstance();

    private UserService() {

    }

    public static UserService getInstance() {
        return instance;
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public int inputPurchasePriceForUser(int accessCount) {
        for(int count = 0; count < accessCount; count++) {
            String purchasePrice = inputPurchasePrice();
            try {
                User user = new User(purchasePrice);
                return userRepository.save(user).getId();
            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        exit(accessCount);
        return -1;
    }

    private String inputPurchasePrice() {
        OutputView.printMessage(ENTER_PURCHASE_PRICE);
        return InputView.readLine();
    }

    private void exit(int accessCount) {
        ErrorOutputView.printErrorMessage(accessCount + EXIT_APPLICATION.getMessage());
        throw new IllegalStateException();
    }

}
