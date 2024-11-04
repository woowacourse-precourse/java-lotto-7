package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoResult;
import lotto.enums.Prize;

/**
 * class: Person.
 *
 * 로또 구매자를 의미하는 클래스
 * 구매자는 금액을 지불하고 로또를 구매하며 당첨 여부를 확인할 수 있다.
 * @author JBumLee
 * @version 2024/11/04
 */
public class Person {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final List<Lotto> purchasedLottos;

    /**
     * 구매 금액을 입력받아 로또 구매자를 생성한다.
     *
     * @param purchaseAmount 구매 금액
     * @throws IllegalArgumentException 구매 금액이 유효하지 않은 경우
     */
    public Person(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.purchasedLottos = purchaseLottos();
        printPurchaseResult();
    }

    /**
     * 구매 금액이 유효한지 검증한다.
     * 금액은 1000원 단위여야 한다.
     *
     * @param amount 검증할 구매 금액
     * @throws IllegalArgumentException 구매 금액이 1000원 단위가 아닌 경우
     */
    private void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    /**
     * 구매 금액에 해당하는 만큼 로또를 구매한다.
     *
     * @return 구매한 로또 리스트
     */
    private List<Lotto> purchaseLottos() {
        int count = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoMachine.generateLotto());
        }

        return lottos;
    }

    /**
     * 구매한 로또들의 수량과 번호를 출력한다.
     */
    private void printPurchaseResult() {
        System.out.println("\n" + purchasedLottos.size() + "개를 구매했습니다.");
        purchasedLottos.forEach(System.out::println);
        System.out.println();
    }

    /**
     * 당첨 번호와 비교하여 당첨 결과를 반환한다.
     *
     * @param winningLotto 당첨 번호
     * @return 당첨 통계가 담긴 LottoResult
     */
    public LottoResult checkWinning(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();

        for (Lotto lotto : purchasedLottos) {
            Prize prize = winningLotto.match(lotto);
            result.addPrize(prize);
        }

        result.calculateProfitRate(purchaseAmount);
        return result;
    }
}