package lotto.Service;

import java.util.ArrayList;
import java.util.List;
import lotto.DTO.BonusNumberDTO;
import lotto.DTO.LottoStatisticsDTO;
import lotto.DTO.PaymentPriceDTO;
import lotto.DTO.RandomLottoNumberDTO;
import lotto.DTO.WinningNumberDTO;
import lotto.Domain.Lotto;
import lotto.Domain.LottoTickets;
import lotto.Domain.PrizeMoneyCalculator;
import lotto.Domain.PurchasePriceCalculator;
import lotto.Domain.RandomLottoNumbersGenerator;
import lotto.Factory.LottoDomainFactory;

public class LottoService {
    private final LottoDomainFactory lottoDomainFactory;
    private Integer lottoPurchaseCount;

    public LottoService(LottoDomainFactory lottoDomainFactory) {
        this.lottoDomainFactory = lottoDomainFactory;
    }

    public RandomLottoNumberDTO purchaseLotto(PaymentPriceDTO paymentPriceDTO) {
        PurchasePriceCalculator purchasePriceCalculator = lottoDomainFactory.createPurchasePriceCalculator();
        RandomLottoNumbersGenerator randomLottoNumberGenerator = lottoDomainFactory.createRandomLottoNumbersGenerator();

        lottoPurchaseCount = purchasePriceCalculator.calculateLottoPrice(paymentPriceDTO.getPaymentPrice());

        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++) {
            List<Integer> numbers = randomLottoNumberGenerator.createRandomLotto();
            generatedLottos.add(new Lotto(numbers));
        }
        LottoTickets lottoTickets = new LottoTickets(generatedLottos);

        return new RandomLottoNumberDTO(lottoTickets);
    }

    public LottoStatisticsDTO calculatePrizeMoney(WinningNumberDTO winningNumberDTO, BonusNumberDTO bonusNumberDTO,
                                                  RandomLottoNumberDTO randomLottoNumberDTO) {
        PrizeMoneyCalculator prizeMoneyCalculator = lottoDomainFactory.createPrizeMoneyCalculator(lottoPurchaseCount);

        prizeMoneyCalculator.calculatePrizeStatistics(winningNumberDTO, bonusNumberDTO, randomLottoNumberDTO);
        LottoStatisticsDTO lottoStatisticsDTO = prizeMoneyCalculator.calculateProfitRate();

        return lottoStatisticsDTO;
    }
}
