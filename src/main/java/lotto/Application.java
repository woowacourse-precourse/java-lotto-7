package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        io.Print.print(io.Print.MONEY_INPUT_MESSAGE);
        int lottoNumber = exception.Handler.getLottoNumber();

        io.Print.print(lottoNumber + io.Print.NUMBER_PRINT_MESSAGE);

        List<Lotto> lottos = lotto.Lotto.getLottos(lottoNumber);
        lotto.Lotto.printLottos(lottos);

        io.Print.print(io.Print.NUMBERS_INPUT_MESSAGE);

        io.Input lottoInput = new io.Input();
        String lottoInputNumbers = lottoInput.getInput();
        List<String> lottoArray = Stream.of(lottoInputNumbers.split(",")).toList();
        List<Integer> lottoArrayNum = lottoArray.stream().map(Integer::parseInt).toList();

        List<Integer> sortedLottoArray = lottoArrayNum.stream().sorted().toList();

        Lotto winningLotto = new Lotto(sortedLottoArray);

        io.Print.print(io.Print.BONUS_NUMBER_INPUT_MESSAGE);
        io.Input bonusNumberInput = new io.Input();
        String bonusNumber = bonusNumberInput.getInput();
        List<Integer> bonusNumberAfterParse = new ArrayList<>();
        bonusNumberAfterParse.add(Integer.parseInt(bonusNumber));
        lotto.Lotto.checkRange(bonusNumberAfterParse);
        lotto.Lotto.checkBonusNumber(winningLotto, Integer.parseInt(bonusNumber));

        List<Integer> rank = lotto.Lotto.countRank(lottos,winningLotto,Integer.parseInt(bonusNumber));
        int gainedMoney = rank.get(0)*2000000000 + rank.get(1)*30000000 + rank.get(2) * 1500000 + rank.get(3) * 50000 + rank.get(4) * 5000;
        float rate = (float) gainedMoney / lottoNumber / 1000 * 100;
        float roundedRate = (float) Math.round(rate*100)/100;

        String string = """
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 %.2f%%입니다.""".formatted(roundedRate);

        io.Print.print(string);
    }
}
