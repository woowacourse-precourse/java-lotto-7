package lotto.service;

import static lotto.exception.ErrorMessages.BONUS_NUMBER_DUPLICATION;
import static lotto.exception.ErrorMessages.NOT_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import java.util.Set;
import lotto.dto.FinalResultsDto;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.service.result.LottoResultServiceImpl;
import lotto.utils.inputValidator.InputValidator;
import lotto.utils.inputValidator.LottoNumberValidator;
import lotto.utils.inputValidator.PositiveIntValidator;
import lotto.utils.inputValidator.WinningNumbersValidator;
import lotto.utils.inputValidator.comparison.BonusNumberValidator;
import lotto.utils.inputValidator.comparison.ComparisonValidator;
import lotto.utils.parser.Parser;
import lotto.utils.parser.StringToIntListParser;
import lotto.utils.parser.StringToIntParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("[Service] LottoResultServiceImpl ")
public class LottoResultServiceImplTest {

    private LottoResultServiceImpl lottoResultService;
    private InputValidator<String> winningNumbersValidator;
    private ComparisonValidator bonusNumberValidator;
    private Parser<List<Integer>> stringToIntListParser;
    private Parser<Integer> stringToIntParser;

    @BeforeEach
    public void setUp() {
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        PositiveIntValidator positiveIntValidator = new PositiveIntValidator();

        winningNumbersValidator = new WinningNumbersValidator(positiveIntValidator, lottoNumberValidator);

        bonusNumberValidator = new BonusNumberValidator(positiveIntValidator, lottoNumberValidator);

        this.stringToIntListParser = new StringToIntListParser();

        stringToIntParser = new StringToIntParser();

        lottoResultService = new LottoResultServiceImpl(
                winningNumbersValidator,
                bonusNumberValidator,
                stringToIntListParser,
                stringToIntParser
        );
    }

    @Nested
    @DisplayName("[receiveWinningLottoNumbers] 당첨 번호 수신 기능 테스트")
    class ReceiveWinningLottoNumbersTest {

        @Test
        @DisplayName("[Exception] 잘못된 형식의 당첨 번호를 수신하면 예외가 발생한다")
        public void Given_InvalidWinningNumbers_When_ReceivingWinningNumbers_Then_ExceptionIsThrown() {
            // Given
            String rawWinningNumbers = "invalid";

            // When & Then
            assertThatThrownBy(() -> lottoResultService.receiveWinningLottoNumbers(rawWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_NUMBER.getMessage());
        }
    }

    @Nested
    @DisplayName("[receiveBonusNumber] 보너스 번호 수신 기능")
    class ReceiveBonusNumberTest {

        @Test
        @DisplayName("[Exception] 보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
        public void Given_DuplicatedBounusNumber_When_ReceivingBonusNumber_Then_ExceptionIsThrown() {
            // Given
            String rawWinningNumbers = "1,2,3,4,5,6";
            lottoResultService.receiveWinningLottoNumbers(rawWinningNumbers);
            String rawBonusNumber = "6";
            // When & Then
            assertThatThrownBy(() -> lottoResultService.receiveBonusNumber(rawBonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(String.format(BONUS_NUMBER_DUPLICATION.getMessage(), Integer.parseInt(rawBonusNumber)));
        }
    }

    @Nested
    @DisplayName("[getFinalResultsDto] FinalResultsDto 생성 기능 테스트")
    class GetFinalResultsDtoTest {

        @Test
        @DisplayName("[return] 올바른 당첨번호 & 보너스 번호를 받으면  올바른 FinalResultDTO가 반환된다")
        public void Given_ProperInput_When_GettingFinalResultsDto_Then_ReturnsFinalResultsDto() {
            // Given
            String rawWinningNumbers = "1,2,3,4,5,6";
            lottoResultService.receiveWinningLottoNumbers(rawWinningNumbers);
            lottoResultService.receiveBonusNumber("7");

            LottoDto lottoDto01 = new LottoDto(Set.of(1, 2, 3, 4, 5, 6));
            LottoDto lottoDto02 = new LottoDto(Set.of(1, 2, 3, 4, 5, 7));
            LottoDto lottoDto03 = new LottoDto(Set.of(1, 2, 3, 13, 11, 10));
            LottoDto lottoDto04 = new LottoDto(Set.of(11, 7, 3, 40, 14, 26));

            LottosDto lottosDto = new LottosDto(List.of(lottoDto01, lottoDto02, lottoDto03, lottoDto04));

            // When
            FinalResultsDto finalResultsDto = lottoResultService.getFinalResultsDto(lottosDto);

            // Then
            assertThat(finalResultsDto).isNotNull();
            assertThat(finalResultsDto.rankResultsDto().rankResults().get(1)).isEqualTo(1);
            assertThat(finalResultsDto.rankResultsDto().rankResults().get(2)).isEqualTo(1);
            assertThat(finalResultsDto.rankResultsDto().rankResults().get(3)).isNull();
            assertThat(finalResultsDto.rankResultsDto().rankResults().get(4)).isNull();
            assertThat(finalResultsDto.rankResultsDto().rankResults().get(5)).isEqualTo(1);

        }
    }
}
