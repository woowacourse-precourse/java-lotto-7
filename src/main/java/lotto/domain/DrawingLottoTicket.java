package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DrawingLottoTicket {
    private final List<DrawingLotto> drawingLottos;

    public DrawingLottoTicket(List<DrawingLotto> drawingLottos) {
        this.drawingLottos = drawingLottos;
    }

    public List<DrawingLotto> getDrawingNumbers() {
        return this.drawingLottos;
    }

    // 당첨 번호와 보너스 번호를 발급받은 로또 번호와 대조하여 당첨 여부 확인
    public List<Double> determineLotto(List<Integer> lottoNumber, int bonusNumber) {
        List<Double> matchCounts = new ArrayList<>();

        for (DrawingLotto drawingLotto : drawingLottos) {
            double matchCount = drawingLotto.getDrawingNumbers().stream()
                    .filter(drawingNumber -> lottoNumber.contains(
                            drawingNumber))
                    .collect(Collectors.toList()).size();
            // 일치하는 번호가 5개일 때 보너스 번호의 일치 여부를 판별
            if (matchCount == 5 && drawingLotto.getDrawingNumbers().contains(bonusNumber)) {
                matchCount += 0.5;
            }

            matchCounts.add(matchCount);
        }
        return matchCounts;
    }
}
