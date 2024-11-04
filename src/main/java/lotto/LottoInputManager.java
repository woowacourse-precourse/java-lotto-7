package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoInputManager {
    static LottoMachine machine = new LottoMachine();

    public static int parseInt(String s){
        try{
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static List<Integer> parseInts(String s){
        List<Integer> integers = new ArrayList<>();
        for(String num : s.split(",")){
            integers.add(parseInt(num));
        }
        return integers;
    }

    public static List<Lotto> inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        while(true){
            try{
                return machine.buyLottos(Integer.parseInt(Console.readLine()));
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }

    public static Lotto inputWinningLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true){
            try{
                return new Lotto(parseInts(Console.readLine()));
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }

    public static Integer inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        while(true){
            try{
                int bonusNumber = parseInt(Console.readLine());
                Lotto.isValidateNumber(bonusNumber);
                return bonusNumber;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }

    public static WinningLotto inputWinningLotto(){
        while(true){
            try{
                return new WinningLotto(inputWinningLottoNumber(), inputBonusNumber());
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
    }
}
