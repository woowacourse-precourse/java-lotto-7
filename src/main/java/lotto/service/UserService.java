package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseLotto;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserService {
    private final InputView inputView;
    private final OutputView outputView;

    public UserService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int inputAmount(){
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.inputAmountView());
            return purchaseAmount.getLottoTickets();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    public User priceLotto(int lottoTickets){

        User user = new User();

        for(int i=0; i<lottoTickets; i++) {
            user.AddPurchaseLottos(new PurchaseLotto());
        }

        outputView.purchaseLottoView(lottoTickets, user.getPurchaseLottos());

        return user;
    }
}
