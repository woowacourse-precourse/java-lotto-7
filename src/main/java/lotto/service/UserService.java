package lotto.service;

import lotto.domain.User;
import lotto.domain.UserRepository;
import lotto.util.InputValidator;
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

    public int save(int purchasePrice) {
        User user = new User(purchasePrice);
        userRepository.save(user);

        return user.getId();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public int getPurchasePrice(int accessCount) {
        for(int count = 0; count < accessCount; count++) {
            int purchasePrice = checkPurchasePrice();
            if (purchasePrice != -1) {
                return purchasePrice;
            }
        }
        exit(accessCount);
        return -1;
    }

    private int checkPurchasePrice() {
        String purchasePrice = inputPurchasePrice();
        try {
            isValidPurchasePrice(purchasePrice);
            return Integer.parseInt(purchasePrice);
        } catch (IllegalArgumentException e) {
            ErrorOutputView.printErrorMessage(e.getMessage());
            return -1;
        }
    }

    private String inputPurchasePrice() {
        OutputView.printMessage(ENTER_PURCHASE_PRICE);
        return InputView.readLine();
    }

    private void isValidPurchasePrice(String purchasePrice) {
        InputValidator.run(purchasePrice);
    }

    private void exit(int accessCount) {
        ErrorOutputView.printErrorMessage(accessCount + EXIT_APPLICATION.getMessage());
        throw new IllegalStateException();
    }

}
