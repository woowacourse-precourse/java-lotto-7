package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;


public class InputView {
    public Lotto prizeNum;
    public int bonusNum;
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
    public void inputPrize() {
        System.out.println("당첨 번호를 입력해 주세요.");
        prizeNum = new Lotto(splitNum(Console.readLine()));
    }
    private static ArrayList<Integer> splitNum(String input){
        String[] splitInput = input.split(",");
        ArrayList<Integer> intList = new ArrayList<>();
        for (String i : splitInput){
            int parseI = parseInt(i.trim());
            intList.add(parseI);
        }
        return intList;
    }
    public void inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = parseInt(Console.readLine());
    }
}