package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoProgram {
    public static void run(){
        int price = Input.inputPrice();
        LottoFactory factory = LottoFactory.getInstance();
        List<Lotto> lotto = factory.createLotto(price);
        Output.printLottos(lotto);
        List<Integer> answer = Input.inputWinningNumbers();
        int bonusNumber = Input.inputBonusNumber();
        List<Grade> grades = new ArrayList<>();
        for (Lotto lottoEach : lotto) {
            grades.add(lottoEach.judgeLotto(answer, bonusNumber));
        }
        LottoCalculator calculator = new LottoCalculator(grades);
        LottoStatistics statistics = calculator.calculate(price);
        Output.printStatistics(statistics);
    }
}
