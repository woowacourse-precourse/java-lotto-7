package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseLotto;
import lotto.domain.User;
import lotto.util.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserService {
    private final InputView inputView;
    private final OutputView outputView;

    public UserService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 구입할 금액을 입력하는 메서드
     * @return 구입 금액
     */
    public int inputAmount(){
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.inputAmountView());
            return purchaseAmount.getLottoTickets();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    /**
     * 구입한 로또 갯수 만큼의 로또 번호를 저장하고 출력 해주는 메서드
     * @param lottoTickets 구입한 로또 갯수
     * @return 구입한 로또 번호
     */
    public User priceLotto(int lottoTickets){

        User user = new User(lottoTickets);

        for(int i=0; i<lottoTickets; i++) {
            user.AddPurchaseLottos(new PurchaseLotto(LottoNumberGenerator.lottoNumbers()));
        }

        outputView.purchaseLottoView(lottoTickets, user.getPurchaseLottos());

        return user;
    }
}
