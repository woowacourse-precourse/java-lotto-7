package lotto.service;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.view.InputController;

public class LottoService {

    public static void getLottoNums() {
        for (int i = 1; i <= InputService.lottoAmount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }

    public static void parseWinningNums() {
        String[] splitNums = InputController.winningNumsInput().trim().split(",");
        for (String item : splitNums) {
            int num = Integer.parseInt(item.trim());
            LottoRepository.winningNums.add(num);
        }
    }

    public static void getBonusNum() {
        LottoRepository.bonus = Integer.parseInt(readLine());
    }

}
