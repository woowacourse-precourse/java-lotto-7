package lotto;

import lotto.domain.Attempt;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.input.Input;
import lotto.input.parser.Parser;
import lotto.output.Output;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class LottoRunner {
    private final Input input = new Input();
    private final Parser parser = new Parser();
    private final Output output = new Output();
    private LottoManager lottoManager;

    private void init() {
        output.write(Output.ASK_BUY_AMOUNT);
        Attempt attempt = retry(
                () -> parser.parseInt(input.read()),
                Attempt::new
        );
        List<Lotto> randomLottos = makeRandomLottosAndWrite(attempt);

        output.write(Output.ASK_LOTTO_NUMBER);
        Lotto lotto = retry(
                () -> parser.parseIntList(input.read()),
                Lotto::new
        );

        output.write(Output.ASK_BONUS_NUMBER);
        BonusLotto bonusLotto = retry(
                () -> parser.parseInt(input.read()),
                BonusLotto::new
        );

        lottoManager = new LottoManager(attempt, lotto, bonusLotto, randomLottos);
        input.close();
    }

    public void run() {
        init();
        Map<LottoPrize, Integer> lottoResult = lottoManager.doLotto();
        output.writeLottoPrize(
                lottoResult,
                lottoManager.getROI(lottoResult)
        );
    }


    private <T,R> R retry(Supplier<T> supplier, Function<T,R> function) {
        while (true) {
            try {
                T t = supplier.get();
                return function.apply(t);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<List<Integer>> convertLottosToIntegerList(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    private List<Lotto> makeRandomLottosAndWrite(Attempt attempt) {
        List<Lotto> lottos = Lotto.makeRandomLottoList(attempt.getLottoAmount());
        output.write(Output.CONFIRM_BUY_AMOUNT, attempt.getLottoAmount());
        output.writeLottoList(convertLottosToIntegerList(lottos));
        return lottos;
    }
}
