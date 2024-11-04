package lotto.service.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.command.view.validate.BonusCommand;
import lotto.command.view.validate.LottoCommand;
import lotto.container.DependencyInjectionContainer;
import lotto.dto.BonusUserInput;
import lotto.dto.MatchResult;
import lotto.dto.MatchResults;
import lotto.dto.WinningLottoUserInput;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PurchasedLottos;
import lotto.model.lotto.WinningLotto;
import lotto.service.lotto.constant.LottoConstant;
import lotto.service.lotto.constant.MatchBonusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 3.
 */
class LottoServiceTest {
  private LottoService lottoService;

  @BeforeEach
  void setUp() {
    DependencyInjectionContainer container = new DependencyInjectionContainer();
    lottoService = container.get(LottoService.class);
  }


  @Test
  @DisplayName("[success]getPrice : 로또 가격 확인")
  void getPrice_shouldReturnCorrectPrice() {
    assertThat(lottoService.getPrice())
        .isEqualTo(LottoConstant.PRICE);
  }

  @ParameterizedTest
  @ValueSource(longs = {1, 5, 10})
  @DisplayName("[success]publishPurchaseLottos : 구매한 로또 수량만큼 발행")
  void publishPurchaseLottos_shouldReturnCorrectNumberOfLottos(long count) {
    PurchasedLottos purchasedLottos = lottoService.publishPurchaseLottos(count);
    assertThat(purchasedLottos.getLottos()
        .size())
        .isEqualTo(count);
  }

  @Test
  @DisplayName("[success]getLottoCommand : 객체 반환 확인")
  void getLottoCommand_shouldReturnCorrectCommand() {
    assertThat(lottoService.getLottoCommand())
        .isNotNull()
        .isInstanceOf(LottoCommand.class);
  }

  @Test
  @DisplayName("[success]createLotto : 유효한 번호로 로또 생성")
  void createLotto_shouldReturnCorrectLotto() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    Lotto lotto = lottoService.createLotto(numbers);

    assertThat(lotto.getNumbers())
        .isNotNull()
        .isEqualTo(numbers);
  }

  @Test
  @DisplayName("[success]createWinningLotto : 로또 당첨 번호 생성")
  void createWinningLotto_shouldReturnCorrectWinningLotto() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    WinningLottoUserInput userInput = WinningLottoUserInput.from(numbers);

    WinningLotto winningLotto = lottoService.createWinningLotto(userInput);

    assertThat(winningLotto.getNumbers())
        .isNotNull()
        .isEqualTo(numbers);
  }

  @Test
  @DisplayName("[success]addBonus : 보너스 번호 추가")
  void addBonusNumber_shouldAddBonusNumberToWinningLotto() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    WinningLottoUserInput userInput = WinningLottoUserInput.from(numbers);
    BonusUserInput bonusUserInput = BonusUserInput.from(7);
    WinningLotto winningLotto = lottoService.createWinningLotto(userInput);

    WinningLotto updatedWinningLotto = lottoService.addBonusNumber(winningLotto, bonusUserInput);

    assertThat(updatedWinningLotto.getBonusNumber())
        .isEqualTo(bonusUserInput.getNumber());
  }

  @Test
  @DisplayName("[success]getBonusCommand : 객체 반환 확인")
  void getBonusCommand_shouldReturnCorrectCommand() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    WinningLottoUserInput userInput = WinningLottoUserInput.from(numbers);
    WinningLotto winningLotto = lottoService.createWinningLotto(userInput);
    assertThat(lottoService.getBonusCommand(winningLotto))
        .isNotNull()
        .isInstanceOf(BonusCommand.class);
  }

  @Test
  @DisplayName("[success]matchWinningLotto : 로또 매칭")
  void matchWinningLotto() {
    List<Integer> winningLottoNumbers = List.of(1,2,3,4,5,6);
    int bonusNumber = 7;

    WinningLotto winningLotto = lottoService.createWinningLotto(
        WinningLottoUserInput.from(winningLottoNumbers));
    winningLotto = lottoService.addBonusNumber(winningLotto,
        BonusUserInput.from(bonusNumber));

    PurchasedLottos purchasedLottos = PurchasedLottos.from(List.of(
        lottoService.createLotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등, 6개 번호 일치
        lottoService.createLotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등, 5개 번호 & 보너스 번호 일치
        lottoService.createLotto(List.of(1, 2, 3, 4, 5, 8))   // 3등, 5개 번호 일치
    ));

    MatchResults results = lottoService.matchWinningLotto(winningLotto, purchasedLottos);

    assertThat(results.getDashboard()
        .get(MatchResults.SORTED_MATCH_RESULTS[4]))
        .isEqualTo(1); // 1등

    assertThat(results.getDashboard()
        .get(MatchResults.SORTED_MATCH_RESULTS[3]))
        .isEqualTo(1); // 2등

    assertThat(results.getDashboard()
        .get(MatchResults.SORTED_MATCH_RESULTS[2]))
        .isEqualTo(1);// 3등

    assertThat(results.getDashboard()
        .get(MatchResults.SORTED_MATCH_RESULTS[1]))
        .isEqualTo(0);// 4등

    assertThat(results.getDashboard()
        .get(MatchResults.SORTED_MATCH_RESULTS[0]))
        .isEqualTo(0);// 5등
  }
}