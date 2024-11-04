package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        String lottoValue;
        Integer lottoLen;
        ArrayList<Lotto> LottoList = new ArrayList<>();
        String winNumber;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                lottoValue = Console.readLine();


                lottoLen = Integer.parseInt(lottoValue);
                if ((lottoLen % 1000) != 0) {
                    new IllegalArgumentException("[ERROR] 로또 구입 값은 1000원 단위로만 받을 수 있습니다.");
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoLen = lottoLen / 1000;

        System.out.println(lottoLen+"개를 구매했습니다.");

        for(int i = 0; i < lottoLen; i++){
            List<Integer> newPick = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            newPick.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(newPick);
            LottoList.add(lotto);
        }

        for (Lotto list : LottoList){
            System.out.println(list.getNumbers());
        }

        System.out.println("당첨 번호를 입력해 주세요.");




    }
}
