    package lotto.service;

    import java.util.List;
    import lotto.domain.Lotto;
    import lotto.domain.LottoBuyer;
    import lotto.domain.Money;

    public class LottoService {


        public List<Lotto> purchaseLotto(Money money){
            LottoBuyer lottoBuyer = new LottoBuyer();
            lottoBuyer.buyLotto(money);

            return lottoBuyer.getLottoTickets();
        }

        
    }
