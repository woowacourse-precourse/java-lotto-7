package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        InputHandler inputHandler = new InputHandler();
        int num = inputHandler.getAmountPaid();

        System.out.println("\n"+num/1000+"개를 구매했습니다.");


        List<Lotto> lottos = inputHandler.initializeLotto(num/1000);


        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }



        System.out.println("\n당첨 번호를 입력해 주세요.");

        List<Integer> v = inputHandler.getLottoNumber();

        Lotto winnigLotto = new Lotto(v);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonus = inputHandler.getBonusNumber();



        int arr[] = new int[8];

        for(int i=0;i<num/1000;i++){
            int a = lottos.get(i).countMatchingNumbers(winnigLotto.getNumbers());
            arr[a]++;
            if(a==5 && lottos.get(i).getNumbers().contains(bonus)){
                arr[7]++;
            }

        }
        OutputHandler outputHandler = new OutputHandler(arr,num);
        outputHandler.Print();



    }
}
