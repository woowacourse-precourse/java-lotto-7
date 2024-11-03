package lotto.service.puchase;

import static lotto.constants.LottoTicket.LOTTO_PRICE;

import lotto.domain.ticket.LottoFactory;
import lotto.domain.ticket.Lottos;
import lotto.dto.LottosDto;
import lotto.service.mapper.DtoMapper;
import lotto.utils.parser.Parser;
import lotto.utils.inputValidator.InputValidator;

public class LottoPurchaseServiceImpl implements LottoPurchaseService {
    private final DtoMapper<Lottos, LottosDto> lottosDtoMapper;
    private final LottoFactory defaultLottoFactory;
    private final InputValidator<String> purchaseAmountValidator;
    private final Parser<Integer> stringToIntParser;
    private Lottos lottos;

    public LottoPurchaseServiceImpl(
            LottoFactory defaultLottoFactory
            , DtoMapper<Lottos, LottosDto> lottosDtoMapper
            , InputValidator<String> purchaseAmountValidator
            , Parser<Integer> stringToIntParser) {

        this.defaultLottoFactory = defaultLottoFactory;
        this.lottosDtoMapper = lottosDtoMapper;
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.stringToIntParser = stringToIntParser;
    }


    @Override
    public void purchaseLottos(String rawPurchaseAmount) {
        purchaseAmountValidator.validate(rawPurchaseAmount);
        int purchaseAmount = stringToIntParser.parse(rawPurchaseAmount);

        int purchasedLottoCount = getLottoCount(purchaseAmount);
        lottos = Lottos.createLottos(purchasedLottoCount, defaultLottoFactory);
    }

    @Override
    public LottosDto getLottosDto() {
        return lottosDtoMapper.toDto(lottos);
    }


    private static int getLottoCount( int purchaseAmount ) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }
}
