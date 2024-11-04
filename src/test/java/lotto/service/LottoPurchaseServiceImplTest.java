package lotto.service;

import static lotto.constants.LottoTicket.LOTTO_PRICE;
import static lotto.exception.ErrorMessages.NOT_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.ticket.DefaultLottoFactory;
import lotto.domain.ticket.LottoFactory;
import lotto.domain.ticket.LottoNumbersGenerator;
import lotto.domain.ticket.Lottos;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.service.mapper.DtoMapper;
import lotto.service.mapper.LottoDtoMapper;
import lotto.service.mapper.LottosDtoMapper;
import lotto.service.puchase.LottoPurchaseServiceImpl;
import lotto.utils.inputValidator.InputValidator;
import lotto.utils.inputValidator.PositiveIntValidator;
import lotto.utils.inputValidator.PurchaseAmountValidator;
import lotto.utils.parser.Parser;
import lotto.utils.parser.StringToIntParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("[Service] LottoPurchaseServiceImpl")
public class LottoPurchaseServiceImplTest {
    private LottoPurchaseServiceImpl lottoPurchaseService;
    private LottoFactory lottoFactory;
    private DtoMapper<Lottos, LottosDto> lottosDtoMapper;
    private InputValidator<String> purchaseAmountValidator;
    private Parser<Integer> stringToIntParser;

    @BeforeEach
    public void setUp() {
        this.lottoFactory = new DefaultLottoFactory(new LottoNumbersGenerator());
        this.lottosDtoMapper = new LottosDtoMapper(new LottoDtoMapper());
        this.purchaseAmountValidator = new PurchaseAmountValidator(new PositiveIntValidator());
        this.stringToIntParser = new StringToIntParser();
        this.lottoPurchaseService = new LottoPurchaseServiceImpl(
                lottoFactory
                , lottosDtoMapper
                , purchaseAmountValidator
                , stringToIntParser);

    }

    @Nested
    @DisplayName("[purchaseLottos] 로또 구매 기능을 테스트한다")
    class PurchaseLottosTest {

        @Test
        @DisplayName("[purchase] 유효한 금액이 주어졌을 때, 구매 금액에 알맞은 갯수의 로또가 생성된다")
        public void Given_ValidAmount_When_PurchasingLottos_Then_LottosAreCreated() {
            //given
            String rawPurchaseAmount = "10000";
            int purchaseAmount = Integer.parseInt(rawPurchaseAmount);
            int purchasedLottoCount = purchaseAmount / LOTTO_PRICE.getValue();

            //when
            lottoPurchaseService.purchaseLottos(rawPurchaseAmount);

            //then
            List<LottoDto> lottos = lottoPurchaseService.getLottosDto().lottoDtos();
            assertThat(lottos).isNotNull();
            assertThat(lottos.size()).isEqualTo(purchasedLottoCount);
        }

        @Test
        @DisplayName("[Exception] 잘못된 금액이 입력되면 예외를 던진다")
        public void Given_InvalidAmount_When_PurchasingLottos_Then_ExceptionIsThrown() {
            //given
            String rawPurchaseAmount = "invalid";

            //when & then
            assertThatThrownBy(() -> lottoPurchaseService.purchaseLottos(rawPurchaseAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_NUMBER.getMessage());
        }
    }

    @Nested
    @DisplayName("[getLottosDto] LottosDto 반환 기능 테스트")
    class DtoConversionTest {

        @Test
        @DisplayName("[return] 로또가 성공적으로 반환되면 메서드 호출 시 로또 정보가 담긴 LottosDTO가 반환된다")
        public void Given_LottosAreCreated_When_ConvertingToDto_Then_CorrectDtoIsReturned() {
            //given
            String rawPurchaseAmount = "10000";
            int purchaseAmount = Integer.parseInt(rawPurchaseAmount);
            lottoPurchaseService.purchaseLottos(rawPurchaseAmount);

            //when
            LottosDto actualDto = lottoPurchaseService.getLottosDto();

            //then
            assertThat(actualDto).isNotNull();
            assertThat(actualDto.lottoDtos().size()).isEqualTo(purchaseAmount / LOTTO_PRICE.getValue());
        }
    }
}
