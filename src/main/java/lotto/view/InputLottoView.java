package lotto.view;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputLottoView {
    public Integer printLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        Integer lottoMoney = 0;
        try{
            lottoMoney=Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        return lottoMoney;
    }


    public List<Integer> printLottoMainNumber(){
        System.out.println("\n당첨 번호를 입력해주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public Integer printBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
