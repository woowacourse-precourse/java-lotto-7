package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.dto.LottosDto;

public class LottoPurchaseServiceImpl implements LottoPurchaseService {
    private final DtoMapper<Lottos, LottosDto> lottosDtoMapper;
    private final LottoFactory defaultLottoFactory;
    private Lottos lottos;

    public LottoPurchaseServiceImpl(
            LottoFactory defaultLottoFactory
            ,DtoMapper<Lottos, LottosDto> lottosDtoMapper) {

        this.defaultLottoFactory = defaultLottoFactory;
        this.lottosDtoMapper = lottosDtoMapper;
    }


    @Override
    public void buyLottos(int purchaseAmount) {
        int purchasedLottoCount = getLottoCount(purchaseAmount);
        lottos = Lottos.createLottos(purchasedLottoCount, defaultLottoFactory);
    }

    public LottosDto getLottosDto() {
        return lottosDtoMapper.toDto(lottos);
    }


    private static int getLottoCount( int purchaseAmount ) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }
}
