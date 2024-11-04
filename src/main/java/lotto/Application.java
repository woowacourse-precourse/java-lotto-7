package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseMoney;
        while(true){
            System.out.println("구입 금액을 입력해 주세요.");
            try{
                purchaseMoney = strToInt(Console.readLine());
                validateMoney(purchaseMoney);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        List<Lotto> lottoList = buyLotto(purchaseMoney);

        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            try{
                Lotto lotto = inputWinningNumber(Console.readLine().split(",",-1));
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        /*
        Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        Console.readLine();*/
    }

    public static int strToInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 숫자를 입력해주세요.");
        }
    }
    public static void validateMoney(int money){
        if(money < 0 || money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력 가능합니다.");
        }
    }
    public static void validateNumber(int num){
        if(num < 1 || num > 45){
            throw new IllegalArgumentException("[ERROR] 1부터45까지의 숫자만 입력 가능합니다.");
        }
    }
    public static List<Lotto> buyLotto(int money){
        int lottoCount = money/1000;
        List<Lotto> lottoList = new ArrayList<Lotto>();

        System.out.println(lottoCount + "개를 구매했습니다.");
        for(int i=0;i<lottoCount;i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            lottoList.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return lottoList;
    }
    public static Lotto inputWinningNumber(String[] numbers){
        List<Integer> winningNumbers = new ArrayList<Integer>();
        for(String number : numbers){
            int num = strToInt(number);
            validateNumber(num);
            winningNumbers.add(num);
        }
        return new Lotto(winningNumbers);
    }
}