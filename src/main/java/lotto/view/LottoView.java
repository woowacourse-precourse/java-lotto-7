package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.PrizeTier;
import lotto.utils.NumberList;
import lotto.utils.Validator;
import lotto.view.constant.UserInterfaceMessage;

public class LottoView {


    public static final String DELIMITERS = ",";
    public static final int LOTTO_PRICE = 1000;

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

        this.validateMoney(money);

        return money;
    }

    public int readBuyingLottoCount(){
        try {
            String rawMoney = this.readMoney();
            int money = this.parseInt(rawMoney);
            return money/ LottoView.LOTTO_PRICE;
        }catch (IllegalArgumentException exception){
            return readBuyingLottoCount();
        }
    }

    public List<Integer> readWinningNumbers(){
        guideInputWinningNumbers();
        String rawNumbers = Console.readLine();
        try {
            this.validateWinningNumbers(rawNumbers);
            String[] rawNumberList = rawNumbers.split(LottoView.DELIMITERS);
            return transformToIntegerList(rawNumberList);
        }catch (IllegalArgumentException exception){
            return readWinningNumbers();
        }
    }

    public int readBonusNumber(){
        guideInputBonusNumber();
        String rawBonusNumber = Console.readLine();
        try {
            this.validateBonusNumber(rawBonusNumber);
            return this.parseInt(rawBonusNumber);
        }catch (IllegalArgumentException exception){
            return readBonusNumber();
        }

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

    public void validateMoney(String money) throws IllegalArgumentException{
        Validator.validateDivisible(this.parseInt(money),LottoView.LOTTO_PRICE);
    }

    public void validateWinningNumbers(String rawWinningNumbers){
        Validator.validateBlankString(rawWinningNumbers);
        String[] rawWinningNumberList = rawWinningNumbers.split(LottoView.DELIMITERS);
        List<Integer> winningNumberList = transformToIntegerList(rawWinningNumberList);

        int startRange = NumberList.NUMBER_RANGE[NumberList.NUMBER_RANGE_START];
        int endRange = NumberList.NUMBER_RANGE[NumberList.NUMBER_RANGE_END];
        for(int number : winningNumberList){
            Validator.validateSpecificRange(number, startRange,endRange);
        }

        Validator.validateListSize(winningNumberList,NumberList.MAX_SIZE);
    }

    public void validateBonusNumber(String rawBonusNumber){
        int bonusNumber = this.parseInt(rawBonusNumber);
        int startRange = NumberList.NUMBER_RANGE[NumberList.NUMBER_RANGE_START];
        int endRange = NumberList.NUMBER_RANGE[NumberList.NUMBER_RANGE_END];
        Validator.validateSpecificRange(bonusNumber, startRange,endRange);

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

    public void printRateOfReturn(double rateOfReturn){
        int roundPosition = 2;
        String stringReturnRate = this.toStringWithRound(rateOfReturn,roundPosition);
        System.out.printf(UserInterfaceMessage.PRINTF_RETURN_OF_RATE,stringReturnRate);
    }

    public List<Integer> transformToIntegerList(String[] rawNumberList){
        List<Integer> numberList = new ArrayList<>();

        for(String rawNumber : rawNumberList){
            int number = parseInt(rawNumber);
            numberList.add(number);
        }

        return numberList;
    }

    /*TODO
       - 변환 로직을 책임질 클래스 구현 고려하기
     */
    public String toStringWithRound(double decimal, int roundPosition){
        String format = "%.0f";
        int defaultDecimalPosition = 0;
        int decimalPosition = --roundPosition;
        if(decimalPosition != defaultDecimalPosition){
           format = format.replaceFirst(Integer.toString(defaultDecimalPosition),Integer.toString(decimalPosition));
        }
        return String.format(format,decimal);
    }


    public int parseInt(String rawNumber){

        validateIntString(rawNumber);

        return Integer.parseInt(rawNumber);
    }

    public void validateIntString(String rawNumber){
        Validator.validateNumericString(rawNumber);
        Validator.validateIntRange(rawNumber);
        int number = Integer.parseInt(rawNumber);
        Validator.validatePositiveNumber(number);
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


}
