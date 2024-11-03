package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.view.constant.UserInterfaceMessage;

public class LottoView {

    public static final String DELIMITERS = ",";

    public void guideInputMoney(){
        System.out.println(UserInterfaceMessage.GUIDE_INPUT_MONEY);
    }

    public void guideInputWinningNumbers(){
        System.out.println(UserInterfaceMessage.GUIDE_INPUT_WINNING_NUMBERS);
    }

    public void guideInputBonusNumber(){
        System.out.println(UserInterfaceMessage.GUIDE_INPUT_BONUS_NUMBER);
    }

    public String readMoney(){
        this.guideInputMoney();
        String money = Console.readLine();
        return money;
    }

    public List<Integer> readWinningNumbers(){
        guideInputWinningNumbers();

        String rawNumbers = Console.readLine();
        String[] rawNumberList = rawNumbers.split(LottoView.DELIMITERS);

        return transformToIntegerList(rawNumberList);
    }

    public List<Integer> transformToIntegerList(String[] rawNumberList){
        List<Integer> numberList = new ArrayList<>();

        for(String rawNumber : rawNumberList){
            int number = parseInt(rawNumber);
            numberList.add(number);
        }

        return numberList;
    }

    public int parseInt(String rawNumber){

        validateIntString(rawNumber);

        return Integer.parseInt(rawNumber);
    }

    public void validateIntString(String rawNumber){
        validateNumericString(rawNumber);
        validateIntRange(rawNumber);
        int number = Integer.parseInt(rawNumber);
        validatePositiveNumber(number);
    }

    /*TODO
       - 검증 로직을 따로 책임지는 클래스를 구현하기
     */
    public static void validateNumericString(String numericString){

        try{
            Integer.parseInt(numericString);
        }catch (Exception e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC_STRING.getMessage());
        }
    }

    public static void validateIntRange(String numericString){

        BigInteger bigIntStage = new BigInteger(numericString);
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger minInt = BigInteger.valueOf(Integer.MIN_VALUE);
        if(bigIntStage.compareTo(maxInt)>0
                || bigIntStage.compareTo(minInt) < 0){
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_INT.getMessage());
        }
    }

    public static void validatePositiveNumber(int number){
        if(number <= 0){
            throw new IllegalArgumentException(ExceptionMessage.NON_POSITIVE_NUMBER.getMessage());
        }
    }

}
