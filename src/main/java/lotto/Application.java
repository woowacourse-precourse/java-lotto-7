package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("구입금액을 입력해주세요");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");

            }
            LottoGame lottoGame = new LottoGame(purchaseAmount, InputWinningNum(), InputBonusNum());
            lottoGame.printLottos();
            lottoGame.printResult();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> InputWinningNum(){
        System.out.println("당첨 번호를 입력해주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winningNums = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if(winningNums.size() != 6 || winningNums.stream().anyMatch(n-> n < 1 || n > 45)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
        }
        return winningNums;
    }

    public static int InputBonusNum(){
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());
        if(bonusNum < 1 || bonusNum > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNum;
    }
}
