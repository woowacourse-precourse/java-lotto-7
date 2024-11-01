package lotto.service.domain.statistics;

import lotto.service.domain.money.Money;

public class StatisticsReport { // 책임: 통계를 넘겨 준다. 이걸로 출력에 관한 클래스가 출력한다.
    private Money budget;
    //private LottoResult lottoResult;
    // 당첨 여부에 관한 자료. 1등 몇개, 2등 몇개, ... & 수익률 계산 메서드. 그렇다면 예산은 이 객체에 필요 없다.
}
