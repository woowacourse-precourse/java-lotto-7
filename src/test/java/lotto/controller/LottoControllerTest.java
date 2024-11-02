package lotto.controller;

import lotto.constant.Prize;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.PurchaseQuantity;
import lotto.util.ParserNums;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    private LottoController lottoController;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ParserNums parser = new ParserNums();
    private LottoManager lottoManager = new LottoManager();

    @BeforeEach
    void beforeEach() {
        lottoManager.setPurchaseQuantity(new PurchaseQuantity("8000"));
        lottoManager.setWinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoManager.setBonusNumber(new BonusNumber("7"));
        lottoManager.setLottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 42, 45)),
                new Lotto(List.of(1, 2, 3, 17, 32, 43)),
                new Lotto(List.of(1, 2, 3, 4, 21, 37)),
                new Lotto(List.of(1, 2, 7, 9, 18, 26)),
                new Lotto(List.of(1, 2, 14, 29, 38, 40))));

        lottoController = new LottoController(inputView, outputView, parser, lottoManager);
    }

    @Test
    @DisplayName("당첨 번호와 맞춰보기")
    void matchingLotto(){
        //when
        HashMap<Prize, Integer> result = lottoController.matchingLotto();
        result.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        //then
        assertThat(result.get(Prize.THREE)).isEqualTo(1);
        assertThat(result.get(Prize.FOUR)).isEqualTo(2);
        assertThat(result.get(Prize.FIVE)).isEqualTo(1);
        assertThat(result.get(Prize.FIVE_AND_BONUS)).isEqualTo(1);
        assertThat(result.get(Prize.SIX)).isEqualTo(1);
    }
}