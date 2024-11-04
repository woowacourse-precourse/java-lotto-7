package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Genarator {

    public List<Lotto> autoGen() {
        List<Lotto> lottos = new ArrayList<>();
        System.out.println("몇장?");
        int no = Integer.parseInt(Console.readLine());
        System.out.println(no);


        for (int i = 0; i < no; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        System.out.println(lottos);

        return lottos;
    }


}
