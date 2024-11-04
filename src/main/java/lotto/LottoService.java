package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.util.LottoPrizeRankType;
import lotto.util.WinningLottoStore;

public class LottoService {

    private final LottoManager lottoManager;

    protected LottoService(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public final List<Lotto> purchaseLottoTickets(final String purchaseAmount) {
        int convertedPurchaseAmount = convertToInt(purchaseAmount);
        int totalPurchaseCount = calculatePurchaseCount(convertedPurchaseAmount);
        return IntStream.range(0, totalPurchaseCount)
                .mapToObj(lotto -> lottoManager.drawLottoTicket()).toList();
    }

    private int convertToInt(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    private int calculatePurchaseCount(int purchaseAmount) {
        validateDivisibility(purchaseAmount);
        return purchaseAmount / WinningLottoStore.getLottoPrice();
    }

    private void validateDivisibility(int purchaseAmount) {
        final int remain = purchaseAmount % WinningLottoStore.getLottoPrice();
        if (remain != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 판매 금액(" + WinningLottoStore.getLottoPrice() + "원)에 맞게 입력해주세요.");
        }
    }

    public final void setWinningLottoStore(
            String inputWinningNumbers, String inputBonusNumber) {
        final List<String> splitWinningNumbers = splitWinningLottoNumbers(inputWinningNumbers);
        List<Integer> winningNumbers = splitWinningNumbers.stream()
                .map(lottoManager::convertToLottoNumber).toList();
        int bonusNumber = lottoManager.convertToLottoNumber(inputBonusNumber);
        validateDuplicate(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(winningNumbers);
        WinningLottoStore.setUpLottoStore(lotto, bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    private List<String> splitWinningLottoNumbers(final String lottoTicket) {
        return List.of(lottoTicket.split(","));
    }

    public LottoResultDto getLottoResults(List<Lotto> userLottoTickets) {
        Map<LottoPrizeRankType, Long> rankLotto = calculateRankCount(userLottoTickets);
        Long totalPrizeMoney = calculateTotalPrizeMoney(rankLotto);
        float rateOfReturn = calculateRateOfReturn(totalPrizeMoney, userLottoTickets.size());
        return new LottoResultDto(rankLotto, rateOfReturn);
    }

    private float calculateRateOfReturn(Long totalPrizeMoney, int totalTicketCount) {
        long totalCost = (long) totalTicketCount * WinningLottoStore.getLottoPrice();
        return (float) totalPrizeMoney / totalCost * 100;
    }

    private Long calculateTotalPrizeMoney(Map<LottoPrizeRankType, Long> rankLotto) {
        return rankLotto.entrySet().stream()
                .mapToLong(rankEntry ->
                        rankEntry.getKey().getPrizeMoney() * rankEntry.getValue())
                .sum();
    }

    private Map<LottoPrizeRankType, Long> calculateRankCount(List<Lotto> userLottoTickets) {
        final Map<LottoPrizeRankType, Long> rankCount = LottoPrizeRankType.getRankCountMap();
        userLottoTickets.stream().map(lottoManager::getLottoResults)
                .filter(ticket -> ticket != LottoPrizeRankType.ZERO)
                .forEach(result -> rankCount.merge(result, 1L, Long::sum));
        return rankCount;
    }
}
