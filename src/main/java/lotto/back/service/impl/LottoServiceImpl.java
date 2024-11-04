package lotto.back.service.impl;

import java.util.List;
import java.util.Map;
import lotto.back.domain.Lotto;
import lotto.back.domain.LottoIssuer;
import lotto.back.domain.LottoNumber;
import lotto.back.domain.DrawnNumbers;
import lotto.back.domain.LottoMatcher;
import lotto.back.repository.DrawnNumberRepository;
import lotto.back.repository.LottoRepository;
import lotto.back.service.LottoService;
import lotto.global.dto.request.LottoMatchRequestDTO;
import lotto.global.dto.request.LottoDrawRequestDTO;
import lotto.global.dto.request.LottoPurchaseRequestDTO;
import lotto.global.dto.response.LottoMatchResponseDTO;
import lotto.global.dto.response.LottoPurchaseResponseDTO;
import lotto.global.enums.LottoConstant;
import lotto.global.enums.WinningLottoRank;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository = new LottoRepository();
    private final DrawnNumberRepository drawnNumberRepository = new DrawnNumberRepository();
    private final LottoIssuer lottoIssuer = new LottoIssuer();

    @Override
    public LottoPurchaseResponseDTO issueLottos(LottoPurchaseRequestDTO lottoPurchaseRequestDTO) {
        Integer lottoPrice = lottoPurchaseRequestDTO.lottoPrice();

        List<Lotto> issuedLottos = lottoIssuer.issueByPrice(lottoPrice);
        saveLottos(issuedLottos);

        return LottoPurchaseResponseDTO.from(issuedLottos);
    }

    @Override
    public void saveDrawnNumbers(LottoDrawRequestDTO lottoDrawRequestDTO) {
        List<Integer> lottoNumbers = lottoDrawRequestDTO.lottoNumbers();
        DrawnNumbers drawnNumbers = new DrawnNumbers(lottoNumbers);
        saveDrawnNumbers(drawnNumbers);
    }

    @Override
    public LottoMatchResponseDTO matchLotto(LottoMatchRequestDTO lottoMatchRequestDTO) {
        LottoNumber bonusNumber = new LottoNumber(lottoMatchRequestDTO.bonusNumber());
        DrawnNumbers drawnNumbers = drawnNumberRepository.find();
        List<Lotto> lottos = lottoRepository.find();

        LottoMatcher lottoMatcher = new LottoMatcher(lottos, drawnNumbers, bonusNumber);
        Map<WinningLottoRank, Integer> winningCount = lottoMatcher.getWinningResult();
        Double rateOfReturn = calculateRateOfReturn(winningCount, lottos.size());

        return new LottoMatchResponseDTO(winningCount, rateOfReturn);
    }

    private Double calculateRateOfReturn(Map<WinningLottoRank, Integer> winningCount, Integer LottoCount) {
        double totalPrizeMoney = winningCount.entrySet().stream()
                .mapToDouble(entry -> Double.valueOf(entry.getKey().getPrizeMoney()) * entry.getValue()).sum();

        double rateOfReturn = totalPrizeMoney / (double) (LottoCount * LottoConstant.LOTTO_PRICE.getNumber());
        return rateOfReturn * 100;
    }

    private void saveLottos(List<Lotto> lottos) {
        lottos.forEach(lottoRepository::save);
    }

    private void saveDrawnNumbers(DrawnNumbers drawnNumbers) {
        drawnNumberRepository.save(drawnNumbers);
    }
}
