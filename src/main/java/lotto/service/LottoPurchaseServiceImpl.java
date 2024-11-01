package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.dto.LottosDto;
import lotto.utils.validator.Validator;

public class LottoPurchaseServiceImpl implements LottoPurchaseService {
    private final DtoMapper<Lottos, LottosDto> lottosDtoMapper;
    private final LottoFactory defaultLottoFactory;
    private final Validator<String> purchaseAmountValidator;
    private Lottos lottos;

    public LottoPurchaseServiceImpl(
            LottoFactory defaultLottoFactory
            , DtoMapper<Lottos, LottosDto> lottosDtoMapper
            , Validator<String> purchaseAmountValidator) {

        this.defaultLottoFactory = defaultLottoFactory;
        this.lottosDtoMapper = lottosDtoMapper;
        this.purchaseAmountValidator = purchaseAmountValidator;
    }


    @Override
    public void purchaseLottos(String rawPurchaseAmount) {
        purchaseAmountValidator.validate(rawPurchaseAmount);
        int purchaseAmount = Integer.parseInt(rawPurchaseAmount);

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
