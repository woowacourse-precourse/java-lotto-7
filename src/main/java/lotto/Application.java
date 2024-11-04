package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import lotto.Constants.LottoRule;

public class Application {
    public static List<Integer> selectRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange( LottoRule.MIN_NUMBER.getNumber(), LottoRule.MAX_NUMBER.getNumber(), LottoRule.NUM_AMOUNT.getNumber() );
    }
    public static Lotto publishLotto(){
        return new Lotto( selectRandomNumbers() );
    }

    public static int checkAmount( int price ){
        if( price < 1000 || price % 1000 != 0 ) throw new IllegalArgumentException();
        return price / 1000;
    }

    public static List<Integer> setWinNumber( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "," );
        List<Integer> winNumbers = new ArrayList<Integer>();
        while( tokenizer.hasMoreTokens() )  winNumbers.add( Integer.parseInt( tokenizer.nextToken() ) );
        if( winNumbers.size() != 6 ) throw new IllegalArgumentException();
        return winNumbers;
    }

    public static int setBonusNumber( String input ){
        try{
            int bounusNumber = Integer.parseInt( input );
            return bounusNumber;
        } catch( Exception e ){
            e.printStackTrace();
            return -1;
        }
    }

    public static List<Constants.LottoGrade> getLottoResults( List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber ){
        List<Constants.LottoGrade> results = new ArrayList<Constants.LottoGrade>();
        for( Lotto lotto : lottos ) results.add( lotto.getGrade( winNumbers, bonusNumber ) );
        return results;
    }

    public static int[] getGradesCount( List<Constants.LottoGrade> results ){
        int[] gradeResult = { 0, 0, 0, 0, 0, 0 };
        for( Constants.LottoGrade result : results ){
            gradeResult[ result.getGrade() - 1 ]++;
        }
        return gradeResult;
    }

    public static long getEarnRate(List<Constants.LottoGrade> results ){
        int startPrice = results.size() * 1000;
        int getPrice = 0;
        for( Constants.LottoGrade result : results ) getPrice += result.getPrize();
        long earnRate = ( getPrice / startPrice ) * 100;
        return earnRate;
    }

    public static void main(String[] args) {
        System.out.println( Constants.TUINotice.NOTICE_INPUT_PAYMENT.getOutput()  );
        int price = Integer.parseInt( Console.readLine() );
        int lottoCount = checkAmount( price );
        System.out.println( lottoCount + Constants.TUINotice.NOTICE_INPUT_BUY_COUNT.getOutput() );
        List<Lotto> lottos = new ArrayList<Lotto>();
        for( int i = 0; i < lottoCount; i++ ) lottos.add( publishLotto() );
        for( Lotto lotto : lottos ) System.out.println( lotto.getNumbers() );
        System.out.println(Constants.TUINotice.NOTICE_INPUT_WINNING_NUMBER.getOutput() );
        List<Integer> winNumbers = setWinNumber( Console.readLine() );
        System.out.println( Constants.TUINotice.NOTICE_INPUT_BONUS_NUMBER.getOutput() );
        int bonusNumber = setBonusNumber( Console.readLine() );
        List<Constants.LottoGrade> results = getLottoResults( lottos, winNumbers, bonusNumber );
        int[] gradeResult = getGradesCount( results );
        System.out.println( Constants.TUINotice.NOTICE_OUTPUT_WIN_RESULT.getOutput() );
        System.out.println( Constants.TUINotice.NOTICE_OUTPUT_WIN_RESULT.getHelper() );
        System.out.println( Constants.LottoGrade.FIFTH_PRIZE.getCondition() + " (" + Constants.LottoGrade.FIFTH_PRIZE.getPrice() + ") - " + gradeResult[4] + "개" );
        System.out.println( Constants.LottoGrade.FOURTH_PRIZE.getCondition() + " (" + Constants.LottoGrade.FOURTH_PRIZE.getPrice() + ") - " + gradeResult[3] + "개" );
        System.out.println( Constants.LottoGrade.THIRD_PRIZE.getCondition() + " (" + Constants.LottoGrade.THIRD_PRIZE.getPrice() + ") - " + gradeResult[2] + "개" );
        System.out.println( Constants.LottoGrade.SECOND_PRIZE.getCondition() + " (" + Constants.LottoGrade.SECOND_PRIZE.getPrice() + ") - " + gradeResult[1] + "개" );
        System.out.println( Constants.LottoGrade.FIRST_PRIZE.getCondition() + " (" + Constants.LottoGrade.FIRST_PRIZE.getPrice() + ") - " + gradeResult[0] + "개" );
        long earnRate = getEarnRate( results );
        System.out.println( Constants.TUINotice.NOTICE_OUTPUT_EARN_RATE.getOutput() + " " + earnRate + "%입니다." );
    }
}
