package lotto;

import java.util.List;

public class PurchaseLottoService implements PurchaseLottoUseCase {

    private static final int UNIT_OF_MONEY = 1000;

    private final LottoFactory lottoFactory;
    private final LottoUserRepository lottoUserRepository;

    public PurchaseLottoService(LottoFactory lottoFactory, LottoUserRepository lottoUserRepository) {
        this.lottoFactory = lottoFactory;
        this.lottoUserRepository = lottoUserRepository;
    }

    @Override
    public void purchase(int money) {
        int purchaseCount = money / UNIT_OF_MONEY;
        List<Lotto> purchasedLottos = lottoFactory.createByCount(purchaseCount);
        lottoUserRepository.save(LottoUser.create(money, purchasedLottos));
    }
}
