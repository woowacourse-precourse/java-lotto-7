package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.model.strategy.NumberGenerationStrategy;
import lotto.utils.ErrorMessages;

/**
 * 로또 발행기 클래스
 * 사용자 입력 금액에 따라 로또 티켓을 발행하는 역할을 수행한다.
 */
public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final NumberGenerationStrategy numberGenerationStrategy;

    /**
     * LottoMachine 생성자
     * 번호 생성 전략을 초기화
     *
     * @param numberGenerationStrategy 로또 번호 생성 전략 (랜덤 또는 고정)
     */
    public LottoMachine(NumberGenerationStrategy numberGenerationStrategy) {
        this.numberGenerationStrategy = numberGenerationStrategy;
    }

    /**
     * 입력한 금액에 따라 로또 티켓을 발행
     *
     * @param amount 로또 구입 금액
     * @return 발행된 로또 티켓 리스트
     * @throws IllegalArgumentException 구입 금액에 1,000원 단위가 아닐 경우
     */
    public List<Lotto> issueLottoTickets(int amount) {
        validateAmount(amount);
        int ticketCount = amount / LOTTO_PRICE;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(numberGenerationStrategy.generateNumbers()));
        }

        return tickets;
    }

    /**
     * 구입 금액의 유효성을 검증
     * 구입 금액이 1,000원 단위가 아닌 경우 예외를 발생시킴
     *
     * @param amount 구입 금액
     * @throws IllegalArgumentException 구입 금액이 1,000원 단위가 아닐 경우
     */
    public void validateAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
           throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }
}
