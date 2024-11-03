package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DrawingLottoTicket {
    private final List<DrawingLotto> winningLottos;

    public DrawingLottoTicket(List<DrawingLotto> winningLottos) {
        this.winningLottos = winningLottos;
    }

    public List<DrawingLotto> getWinningNumbers() {
        return this.winningLottos;
    }

    // 당첨 번호와 보너스 번호를 발급받은 로또 번호와 대조하여 당첨 여부 확인
    public List<Double> determineWin(List<Integer> lottoNumber, int bonusNumber) {
        List<Double> matchCounts = new ArrayList<>();

        for (DrawingLotto winningLotto : winningLottos) {
            double matchCount = winningLotto.getWinningNumbers().stream()
                    .filter(winningNumber -> lottoNumber.contains(
                            winningNumber))
                    .collect(Collectors.toList()).size();
            // 일치하는 번호가 5개일 때 보너스 번호의 일치 여부를 판별
            if (matchCount == 5 && winningLotto.getWinningNumbers().contains(bonusNumber)) {
                matchCount += 0.5;
            }

            matchCounts.add(matchCount);
        }
        return matchCounts;
    }
}
