package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Display {
    private static String input;
    final static String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    final static String TELL_AMOUNT = "개를 구매했습니다.";
    final static String REQUEST_NUMBER = "당첨 번호를 입력해 주세요.";
    final static String REQUEST_BONUS = "\n보너스 번호를 입력해 주세요.";
    final static String RESULT = "당첨 통계\n---";

    public static void setInput(){
        input = Console.readLine();
    }
    public static String get(){
        return input;
    }


    public static void requestMoney(){
        System.out.println(REQUEST_MONEY);
    }
    public static void tellAmount(){
        int amount = Amount.get();
        System.out.println();
        System.out.println(amount+TELL_AMOUNT);
    }

    public static void requestNumber(){
        System.out.println(REQUEST_NUMBER);
    }

    public static void requestBonus(){
        System.out.println(REQUEST_BONUS);
    }

    public static void showResult(){
        System.out.println(RESULT);
    }

    public static List<Integer> toLotto(){
        List<Integer> numbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        return numbers;
    }

    private static boolean hasComma(){
        return input.contains(",");
    }

    private static boolean isNotNulllOrEmpty(){
        return input != null && !input.isEmpty();
    }

    private static boolean isValidCount(){
        List<String> strList = Arrays.asList(input.split(","));
        return strList.size() == 6;
    }
    private static boolean isWithinRange(List<Integer> numbers){
        return numbers.stream().allMatch(number -> number>=1 && number<=45);
    }
}
