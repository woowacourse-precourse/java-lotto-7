package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMakerTest {
    private LottoMaker lottoMaker;

    @BeforeEach
    void setUp() {
        lottoMaker = new LottoMaker();
    }

    @DisplayName("구입 금액 8000원에 로또 티켓 8개가 생성된다.")
    @Test
    void 구입_금액에_8000원에_로또_티켓_8개_생성() {
        int purchaseAmount = 8000; // 8개의 로또 티켓
        List<Lotto> lotteries = lottoMaker.generateLotteries(purchaseAmount);

        assertEquals(8, lotteries.size()); // 8개의 로또 티켓이 생성되어야 함
    }

    @DisplayName("문자열 구입금액을 정수로 변환한다.")
    @Test
    void 문자열_구입금액을_정수로_변환() {
        String inputAmount = "5000";
        int amount = LottoMaker.transInputToInt(inputAmount);

        assertEquals(5000, amount); // 문자열 "5000"이 정수 5000으로 변환되어야 함
    }

    @DisplayName("문자열이 섞인 금액 입력시 예외가 발생한다.")
    @Test
    void 문자열_금액_입력시_예외_발생() {
        String invalidInput = "1000j";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoMaker.transInputToInt(invalidInput);
        });

        assertEquals("[ERROR] 구입 금액은 숫자로 입력해 주세요.", exception.getMessage());
    }

    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외_발생() {
        int invalidAmount = 5500; // 1000원 단위가 아님

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            lottoMaker.generateLotteries(invalidAmount);
        });

        assertEquals("[ERROR] 1000단위의 금액만 받습니다.", exception.getMessage());
    }

    @DisplayName("로또 번호는 1에서 45사이, 6개의 고유한 숫자로 구성된다.")
    @Test
    void 로또_번호는_1에서_45_사이의_6개의_고유한_숫자로_구성된다() {
        List<Integer> lottoNumbers = lottoMaker.makeLottoNumber();

        assertEquals(6, lottoNumbers.size()); // 로또 번호는 6개여야 함
        assertTrue(lottoNumbers.stream().allMatch(num -> num >= 1 && num <= 45)); // 1~45 범위 확인
        assertEquals(6, lottoNumbers.stream().distinct().count()); // 중복 없는 숫자
    }
}