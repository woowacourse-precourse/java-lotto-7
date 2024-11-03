package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Set;

public class OutputLottoView {
    public void printLottoNumber(Set<Lotto> lottoNumbers) {
        int num = lottoNumbers.size();
        System.out.println(num + "개를 구매했습니다.");
        lottoNumbers.forEach(lotto -> {
                System.out.println(lotto.getNumbers());
    });//확인하기
}

public void printLottoStatic() {
    System.out.println("\n당첨 통계\n---");
    for (LottoRank rank : LottoRank.values()) {
        System.out.println(rank.getMessage() + rank.getCount() + "개");
    }
}

public void printEarningsRate(double earningsRate) {
    System.out.printf("총 수익률은 %.2f%%입니다.", earningsRate);
}
}
