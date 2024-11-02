package view;

import lotto.Lotto;

import java.util.List;

public class outputView {
    public int three;
    public int four;
    public int five;
    public int fiveAndBonus;
    public int six;

    public final int value=1000;

    public double totalPrice;
    public int usedPrice;

    public outputView()
    {
        three=four=five=fiveAndBonus=six=0;
    }

    public void reqeustPurchase()
    {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void amountPurchase(int number)
    {
        System.out.println(number + Message.PURCHASED_COUNT.getMessage());
    }

    public void randomNumber(List<Lotto> numbers)
    {
        usedPrice=numbers.size()*value;
        StringBuilder result = new StringBuilder();
        for(Lotto list: numbers)
        {
            result.append(Message.OPEN_BRACKET.getMessage());
            for(int number : list.getNumbers())
            {
                if(result.length()>1)
                    result.append(Message.COMMA.getMessage());
                result.append(number);
            }
            result.append(Message.CLOSE_BRACKET.getMessage());
            System.out.println(result);
        }
    }

    public void reqeustWinner()
    {
        System.out.println(Message.INPUT_WINNING_NUMBER.getMessage());
    }

    public void reqeustbonus()
    {
        System.out.println(Message.BONUS.getMessage());
    }
    //랜덤 번호 6자리를 "[ ]" 사이에 ", "로 구분하여 출력 반복횟수는 구입 금액 횟수만큼

    public void printWinningStatistics() {
        System.out.println(Message.WINNING_STATISTICS);
        System.out.println(Message.SEPARATOR);
        System.out.println(Message.MATCH_3.getMessage() + three + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_4.getMessage() + four + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_5.getMessage() + five + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_5_WITH_BONUS.getMessage() + fiveAndBonus + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_6.getMessage() + six + Message.UNIT.getMessage());

        profit();
        System.out.println(Message.TOTAL_YIELD.getMessage() + totalPrice + Message.ENDING);
    }
    //당첨 통계 출력
    //(당첨금 합계)/(구매 금액 중 사용한 금액)을 수익률을 출력함

    public void inputPrice(int three, int four, int five,
                           int fiveAndBonus, int six)
    {
        this.three=three;
        this.four=four;
        this.five=five;
        this.fiveAndBonus=fiveAndBonus;
        this.six=six;
    }


    private void profit()
    {
        totalPrice = (three*5000 + four*50000 + five* 1500000
        +fiveAndBonus*30000000+six*2000000000)/usedPrice;
    }
}
