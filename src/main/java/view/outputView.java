package view;

import lotto.Lotto;

import java.util.List;

public class outputView {
    public int three;
    public int four;
    public int five;
    public int fiveAndBonus;
    public int six;

    public outputView()
    {
        three=four=five=fiveAndBonus=six=0;
        System.out.println(Message.INPUT_PURCHASE_AMOUNT);

    }

    private void randomNumber(List<Lotto> numbers)
    {
        for(Lotto list: numbers)
        {
            list
        }
    }
    //랜덤 번호 6자리를 "[ ]" 사이에 ", "로 구분하여 출력 반복횟수는 구입 금액 횟수만큼
    //당첨 통계 출력
    //(당첨금 합계)/(구매 금액 중 사용한 금액)을 수익률을 출력함
}
