package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.dto.LottoResponseDTO;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResults;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();

    public List<Lotto> generateLottos(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount / 1000)
                .mapToObj(idx -> new Lotto(lottoMachine.genearteLottos()))
                .collect(Collectors.toList());
    }

    // 결과 계산 시 LottoResultDTO를 반환
    public LottoResponseDTO calculateResult(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        LottoResults results = new LottoResults(userLottos, winningLotto, bonusNumber);
        results.calculateResult();

        // 여기서 결과를 DTO로 변환
        return new LottoResponseDTO(userLottos, results);
    }
}
