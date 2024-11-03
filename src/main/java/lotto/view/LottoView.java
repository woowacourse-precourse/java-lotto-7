package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.ExceptionMessage;
import lotto.constant.PrizeTier;
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
        /*TODO
            - 숫자로 변환후 반환하기
            - 1000원으로 나눈 몫을 반환하는 로직을 추가
        */
        validateIntString(money);

        return money;
    }

    public List<Integer> readWinningNumbers(){
        guideInputWinningNumbers();

        String rawNumbers = Console.readLine();
        validateString(rawNumbers);
        String[] rawNumberList = rawNumbers.split(LottoView.DELIMITERS);

        return transformToIntegerList(rawNumberList);
    }

    public void printBoughtLottoInfo(List<Lotto> lottos){
        System.out.printf(UserInterfaceMessage.PRINTF_BOUGHT_LOTTO_INFO+"\n",lottos.size());

        for(Lotto lotto : lottos){
            this.printLottoNumbers(lotto);
        }

        System.out.println();
    }

    public void printWinningInfo(Map<PrizeTier,Integer> winningInfo){
        PrizeTier[] keys = PrizeTier.getWinningPrizeTierValues();

        System.out.println(UserInterfaceMessage.PRINT_WINNING_INFO_HEAD);

        for(PrizeTier key : keys){
            int winningCount = winningInfo.get(key);
            printPrizeInfo(key,winningCount);
        }

    }

    /*TODO
       - 해당 메세지 출력 책임을 UserInterfaceMessage 맡길지 고려하기
     */
    public void printPrizeInfo(PrizeTier prizeTier, int winningCount){
        int prizeMoney = prizeTier.getPrizeMoney();
        int matchCount = prizeTier.getMatchCount();
        String message = UserInterfaceMessage.PRINTF_MATCH_COUNT;
        if(prizeTier == PrizeTier.SECOND){
            message = message.concat(UserInterfaceMessage.PRINT_BONUS_NUMBER_MATCH);
        }

        message = message.concat(UserInterfaceMessage.PRINTF_WINNING_INFO);
        System.out.printf(message+"\n",matchCount,prizeMoney,winningCount);
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

    public void printLottoNumbers(Lotto lotto){
       String result = UserInterfaceMessage.PRINT_LOTTO_LIST_START_DELIMITER;
       String joinedNumbers = joinToString(lotto.getNumbers(),UserInterfaceMessage.PRINT_LOTTO_LIST_MIDDLE_DELIMITER);
       result = result.concat(joinedNumbers).concat(UserInterfaceMessage.PRINT_LOTTO_LIST_END_DELIMITER);
       System.out.println(result);
    }

    static public String joinToString(List<Integer> numberList, String delimiter){


        List<String> stringNumbers = new ArrayList<>();

        for(int number : numberList){
            stringNumbers.add(Integer.toString(number));
        }

       return String.join(delimiter,stringNumbers);
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

    public static void validateString(String string){
        if(string.isBlank()){
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_STRING.getMessage());
        }

    }

}
