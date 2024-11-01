package lotto.domain;

import lotto.controller.Policy;

public interface GameManager {

    //TODO : 매개변수 타입이 비슷해서 입력할 때 실수가 일어날 것 같은데... 예방하는 방법 뭐 없을까..?
    // DTO로 감싼다고 하더라도 입력하는건 똑같잖아.. DTO로 감싸고 Builder 패턴을 넣으면.. 코드가 길어지고 지저분해질 것 같은데...
    // 그냥 정책을 넘기는게 나으려나...?

    Lotteries initLottery(Policy policy,int totalBuyCount);

    int calculateBuyCount(int inputAmount,int lotteryAmount);



}
