package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserService {
    private final OutputView outputView;
    private final InputView inputView;

    public UserService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public User setUser() {
        try {
            return createUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setUser();
        }
    }

    public User createUser() {
        User user = new User(new PurchaseAmount(setPurchaseAmount()));
        setUserLottoTickets(user);
        printUserLottoNumbers(user);
        return user;
    }

    public String setPurchaseAmount() {
        outputView.printPurchaseAmount();
        return inputView.inputUserForData();
    }

    public void setUserLottoTickets(User user) {
        outputView.printBuyingQuantity(user);
        user.createLottoTickets();
    }

    public void printUserLottoNumbers(User user) {
        outputView.printUserLottoNumbers(user);
    }

}
