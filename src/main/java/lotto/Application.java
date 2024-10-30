package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        InputHandler inputHandler = new InputHandler();
        int num = inputHandler.getAmountPaid();

        System.out.println(num/1000+"개를 구매했습니다.");


        List<Lotto> lottos = inputHandler.initializeLotto(num/1000);


        for(int i=0;i<num/1000;i++){
            for(int j=0;j<6;j++){
                System.out.print(lottos.get(i).getNumbers().get(j)+",");
            }
            System.out.println(" ");
        }


        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> v = inputHandler.getLottoNumber();

        Lotto winnigLotto = new Lotto(v);

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = inputHandler.getBonusNumber();








    }
}
