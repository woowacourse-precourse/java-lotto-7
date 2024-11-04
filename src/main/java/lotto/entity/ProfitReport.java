package lotto.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.configuration.LottoConfiguration;
import lotto.configuration.Prize;
import lotto.dto.PrizeCountEntry;
import lotto.validator.ProfitReportVaildator;

public class ProfitReport {
    private final List<Lotto> purchasedLottos;
    private final WinningNumbers winningNumbers;

    // constructor

    public ProfitReport(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        ProfitReportVaildator.validate(purchasedLottos, winningNumbers);
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
    }

    // public method

    public double calculateProfitRate() {
        long profit = calculateProfit();
        long paymentAmount = getPaymentAmount();

        return (double) profit / paymentAmount * 100;
    }

    public long calculateProfit() {
        return purchasedLottos.stream().mapToLong(this::calculatePrizeMoney).sum();
    }

    public List<PrizeCountEntry> calculateWinningCountsByPrize() {
        HashMap<Prize, Integer> prizeCount = Arrays.stream(Prize.values())
                .collect(Collectors.toMap(prize -> prize, prize -> 0, Integer::sum, HashMap::new));

        purchasedLottos.stream().map(this::calculatePrize)
                .forEach(prize -> prizeCount.put(prize, prizeCount.get(prize) + 1));

        return prizeCount.keySet().stream()
                .map(prize -> new PrizeCountEntry(prize, prizeCount.get(prize)))
                .sorted((o1, o2) -> Long.compare(o1.prize().getPrizeMoney(), o2.prize().getPrizeMoney()))
                .toList();

    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getPaymentAmount() {
        return purchasedLottos.size() * LottoConfiguration.LOTTO_PRICE.getValue();
    }

    // private method

    private long calculatePrizeMoney(Lotto lotto) {
        Prize prize = calculatePrize(lotto);
        return prize.getPrizeMoney();
    }

    private Prize calculatePrize(Lotto lotto) {
        int matchCount = (int) winningNumbers.getMainNumbers().stream().filter(lotto::contains).count();
        boolean matchBonus = lotto.contains(winningNumbers.getBonusNumber());

        return Prize.findPrize(matchCount, matchBonus);
    }


}
