package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoInput {
    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = 0;
        while (true) {
            try{
                price = Integer.parseInt(Console.readLine());
                return price;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자로만 입력해주세요");
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }

    public List<Integer> inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinning = Console.readLine();
        String[] winningNumber = winningSplit(inputWinning);
        List<Integer> winningNumbers = setWinningNumber(winningNumber);
        return winningNumbers;
    }

    public int inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호 1개만 입력해주세요");
                System.out.println("\n보너스 번호를 입력해 주세요.");
            }
        }
    }

    private static List<Integer> setWinningNumber(String[] winningNumber){
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            try {
                for (String number : winningNumber) {
                    winningNumbers.add(Integer.parseInt(number));
                }
                Collections.sort(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자와 쉼표만 입력해주세요.");
                System.out.println("당첨 번호를 입력해 주세요.");
            }
        }
    }

    private static String[] winningSplit(String inputWinning){
        String[] winningNumber = null;
        while (true) {
            try {
                winningNumber = inputWinning.split(",");
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자는 쉼표를 기준으로 입력해야 합니다");
                System.out.println("당첨 번호를 입력해 주세요.");
            }
        }
    }
}
