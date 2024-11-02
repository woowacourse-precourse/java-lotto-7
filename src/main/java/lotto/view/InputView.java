package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;


public class InputView {

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(Console.readLine());
    }
    private static int parseInt(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
    public static Lotto inputPrize() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return splitNum(Console.readLine());

    }
    private static Lotto splitNum(String input){
        String[] splitInput = input.split(",");
        ArrayList<Integer> intList = new ArrayList<>();
        for (String i : splitInput){
            int parseI = parseInt(i);
            intList.add(parseI);
        }
        return new Lotto(intList);
    }

}