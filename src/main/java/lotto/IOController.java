package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOController {


    public Integer inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String s = Console.readLine();
        return Integer.parseInt(s);
    }

    public void printLottoList(List<Lotto> lottoList){
        System.out.println(lottoList.size() +"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(s.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return winningNumbers;
    }

    public Integer inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String s = Console.readLine();
        return Integer.parseInt(s);
    }

    public void printWinningStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");

    }
}
