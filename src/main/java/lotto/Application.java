package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lottery;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.NumberGenerator;
import lotto.domain.PurchasePrice;
import lotto.domain.Quantity;
import lotto.support.IntegerConverter;
import lotto.support.Splitter;

public class Application {
    public static void main(String[] args) {
        // 로또 구입 금액
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = readLine();
        PurchasePrice purchasePrice = new PurchasePrice(inputPrice);
        Quantity quantity = purchasePrice.calculateQuantity();
        System.out.println(System.lineSeparator() + quantity.getQuantity() + "개를 구매했습니다.");

        // 로또 발행
        NumberGenerator<?> generator = new LottoNumberGenerator();
        List<Lotto> lottos = Lotto.createAsMuchAs(quantity, generator);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        // 당첨 번호
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = readLine();
        Splitter splitter = new Splitter(",");
        List<String> split = splitter.split(inputWinningNumbers);
        IntegerConverter converter = new IntegerConverter();
        List<Integer> numbers = converter.convertFrom(split);
        Lotto winningLotto = new Lotto(numbers);

        // 보너스 번호
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
        String inputBonusNumber = readLine();
        int convertedBonusNumber = converter.convertFrom(inputBonusNumber);
        LottoNumber bonusNumber = new LottoNumber(convertedBonusNumber);

        // 당첨 통계
        System.out.println(System.lineSeparator() + "당첨 통계");
        Lottery lottery = new Lottery(winningLotto, bonusNumber, lottos);
        LottoResult lottoResult = lottery.getLottoResult();
        Map<LottoRank, BigDecimal> result = lottoResult.getResult();
        for (int i = 0; i < LottoRank.values().length; i++) {
            LottoRank lottoRank = LottoRank.values()[i];
            BigDecimal count = result.get(lottoRank);
            System.out.print(lottoRank.getMatchingCount() + "개 일치");
            if (lottoRank == LottoRank.SECOND) {
                System.out.println(", 보너스 볼 일치 (" + lottoRank.getAward() + "원) - " + count + "개");
                continue;
            }
            System.out.println(" (" + lottoRank.getAward() + "원) - " + count + "개");
        }
        BigDecimal profitRate = lottery.calculateProfitRate();
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
