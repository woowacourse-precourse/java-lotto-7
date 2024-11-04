package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
class LottoSaveServiceTest {
    LottoSaveService lottoSaveService = new LottoSaveService();
    Lottos lottos;

    @Test
    @DisplayName("로또를 구매하는 기능을 테스트한다.")
    void buyLottos() {
        String purchasePrice = "14000";
        int lottoCount = lottoSaveService.buyLottos(purchasePrice);
        assertEquals(14, lottoCount);
    }

    @Test
    @DisplayName("구매 금액을 반환하는 기능을 테스트한다.")
    void getPurchasePrice() {
        String purchasePrice = "14000";
        lottoSaveService.buyLottos(purchasePrice);
        assertEquals(14000, lottoSaveService.getPurchasePrice());
    }

    @Test
    @DisplayName("로또를 저장하는 기능을 테스트한다.")
    void saveLottos() {
        lottoSaveService.saveLottos(2);
        assertEquals(2, lottoSaveService.getLottos().size());
    }

    @Test
    @DisplayName("로또를 반환하는 기능을 테스트한다.")
    void getLottos() {
        lottoSaveService.saveLottos(2);
        List<List<Integer>> lottos = lottoSaveService.getLottos();
        assertEquals(2, lottos.size());
    }

    @Test
    @DisplayName("당첨 번호를 저장하는 기능을 테스트한다.")
    void saveWinningLotto() {
        String winningNumbers="1,2,3,4,5,6";
        lottoSaveService.saveWinningLotto(winningNumbers);
        List<Integer> actualWinningNumbers = lottoSaveService.lottoWinningNumber.getLottoWinningNumbers();
        String actualWinningNumbersAsString = actualWinningNumbers.stream()
                .map(String::valueOf) // Integer를 String으로 변환
                .collect(Collectors.joining(","));
        assertEquals(winningNumbers, actualWinningNumbersAsString);
    }

    @Test
    void saveBonusNumber() {
        lottoSaveService.saveBonusNumber("7");
        assertEquals(7, lottoSaveService.lottoBonusNumber.getBonusNumber());
    }
}