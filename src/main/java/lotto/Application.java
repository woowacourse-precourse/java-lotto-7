package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static LottoMachine machine = new LottoMachine();

    public static int parseInt(String s){
        try{
            int num = Integer.parseInt(s);
            if(num <= 0 || num > Lotto.MAX_NUM) throw new IllegalArgumentException("로또 숫자 범위를 초과합니다.");
            return num;
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
                return parseInt(Console.readLine());
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

    public static void main(String[] args) {

        List<Lotto> lottos = inputPrice();
        WinningLotto winningLotto = inputWinningLotto();

    }
}
