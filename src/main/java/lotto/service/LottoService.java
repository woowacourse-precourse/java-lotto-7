package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.dto.*;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningNumber;
import lotto.domain.value.Standard;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;
import lotto.utils.LottoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final LottoPurchaseRepository lottoPurchaseRepository;
    private final WinningNumberRepository winningNumberRepository;

    public LottoService(LottoRepository lottoRepository, LottoPurchaseRepository lottoPurchaseRepository, WinningNumberRepository winningNumberRepository) {
        this.lottoRepository = lottoRepository;
        this.lottoPurchaseRepository = lottoPurchaseRepository;
        this.winningNumberRepository = winningNumberRepository;
    }

    public int saveLottoPurchase(int request) {
        LottoPurchase lottoPurchase = new LottoPurchase(request);
        lottoPurchaseRepository.save(lottoPurchase);
        return lottoPurchaseRepository.findIndexByLottoPurchase(lottoPurchase);
    }

    public LottoPurchaseResponse createLottoNumbers() {
        LottoPurchase lottoPurchase = lottoPurchaseRepository.findOne();

        List<Lotto> lottoList = createLottoList(lottoPurchase.getAmount());
        lottoRepository.save(lottoList);

        return LottoPurchaseResponse.of(lottoPurchase, lottoList);
    }

    public WinningNumberSaveResponse saveWinningNumber(String input) {
        List<String> divideBySeparator = LottoUtils.divideBySeparator(",", input);
        List<Integer> result = LottoUtils.convertToIntegerList(divideBySeparator);

        WinningNumber winningNumber = WinningNumber.to(result);
        winningNumberRepository.save(winningNumber);

        int index = winningNumberRepository.findIndexByWinningNumber(winningNumber);

        return new WinningNumberSaveResponse(index, winningNumber);
    }

    public void saveBonusNumber(BonusNumberSaveRequest request) {
        WinningNumber winningNumber = winningNumberRepository.findByIndex(request.index());
        winningNumber.setBonusNumber(request.bonusNumber());
    }

    public List<PrizeResultDto> calculatePrizeResult(int index) {
        WinningNumber winningNumber = winningNumberRepository.findByIndex(index);
        List<Lotto> lottoList = lottoRepository.findAll();

        return Arrays.stream(Standard.values())
            .map(standard -> calculateCount(standard, winningNumber, lottoList))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public double calculateRate(List<PrizeResultDto> prizeResultDtos, int purchaseIndex) {
        LottoPurchase purchase = lottoPurchaseRepository.findByIndex(purchaseIndex);
        int total = getPrizeTotalAmount(prizeResultDtos);

        return (double) total / purchase.getPurchase() * 100;
    }

    private int getPrizeTotalAmount(List<PrizeResultDto> prizeResultDtos) {
        return prizeResultDtos.stream()
            .filter(PrizeResultDto::hasPrize)
            .mapToInt(PrizeResultDto::getTotalPrize)
            .sum();
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Lotto> createLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(getRandomNumbers()));
        }

        return lottoList;
    }

    private PrizeResultDto calculateCount(Standard standard, WinningNumber winningNumber, List<Lotto> lottoList) {
        if (standard.equals(Standard.EMPTY_PLACE)) {
            return null;
        }

        int count = (int) lottoList.stream()
            .filter(lotto -> doCountMatch(lotto, winningNumber, standard))
            .count();

        return new PrizeResultDto(standard, count);
    }

    private boolean doCountMatch(Lotto lotto, WinningNumber winningNumber, Standard standard) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> numbers = winningNumber.getWinningNumber().getNumbers();

        int count = (int) lottoNumbers.stream().filter(numbers::contains).count();
        boolean hasBonusNumber = lottoNumbers.contains(winningNumber.getBonusNumber());

        return standard.checkCountMatches(count, hasBonusNumber);
    }

}
