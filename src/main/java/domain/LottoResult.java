package domain;

import java.util.List;

public class LottoResult {
    private int purchaseAmount;        // 구매금액
    private int totalLottos;           // 구매한 로또의 총 개수
    private int winningLottoCount;     // 당첨 로또의 개수
    private int[] winningNumbers;      // 당첨 번호
    private int bonusNumber;           // 보너스 번호
    private List<int[]> purchasedLottos; // 구매한 로또 번호 리스트
}
