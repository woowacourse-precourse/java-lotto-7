    package lotto.service;

    import java.util.List;
    import lotto.domain.Lotto;
    import lotto.domain.LottoManager;
    import lotto.domain.Money;

    public class LottoService {

        public List<Lotto> purchaseLotto(Money money){
            LottoManager lottoManager = new LottoManager();
            lottoManager.buyLotto(money);

            return lottoManager.getLottoTickets();
        }


    }
