package view;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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

    public void amountPurchase()
    {
        System.out.println(usedPrice/value + Message.PURCHASED_COUNT.getMessage());
    }

    public List<List<Integer>> randomNumber(List<Lotto> numbers)
    {
        usedPrice=numbers.size()*value;

        List<List<Integer>> resultList = new ArrayList<>();

        for (Lotto list : numbers) {
            List<Integer> numberList = new ArrayList<>(list.getNumbers());
            resultList.add(numberList);
        }

        return resultList;

    }

    public void printNumberLists(List<List<Integer>> numberLists) {
        for (List<Integer> numberList : numberLists) {
            StringBuilder result = new StringBuilder();
            result.append(Message.OPEN_BRACKET.getMessage());

            for (int i = 0; i < numberList.size(); i++) {
                if (i > 0) {
                    result.append(Message.COMMA.getMessage());
                }
                result.append(numberList.get(i));
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

    public void printWinningStatistics() {
        System.out.println(Message.WINNING_STATISTICS);
        System.out.println(Message.SEPARATOR);
        System.out.println(Message.MATCH_3.getMessage() + three + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_4.getMessage() + four + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_5.getMessage() + five + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_5_WITH_BONUS.getMessage() + fiveAndBonus + Message.UNIT.getMessage());
        System.out.println(Message.MATCH_6.getMessage() + six + Message.UNIT.getMessage());

        profit();
        System.out.println(Message.TOTAL_YIELD.getMessage() + totalPrice + Message.ENDING.getMessage());
    }

    public void inputPrice(List<Integer> nums)
    {
        this.three=nums.get(0);
        this.four=nums.get(1);
        this.five=nums.get(2);
        this.fiveAndBonus=nums.get(3);
        this.six=nums.get(4);
    }

    public void inputUsedPrice(int price)
    {
        usedPrice=price;
    }

    public List<Lotto> choose()
    {
        List<Lotto> temp = new ArrayList<>();
        for(int i=0; i<usedPrice/value; i++)
        {
            temp.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return temp;
    }



    private void profit()
    {
        totalPrice = (three*5000 + four*50000 + five* 1500000
        +fiveAndBonus*30000000+six*2000000000)/usedPrice;
    }
}
