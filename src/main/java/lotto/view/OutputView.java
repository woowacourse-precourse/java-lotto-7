package lotto.view;

import dto.LottosDTO;

public class OutputView {

    public void printLottos(LottosDTO lottosDTO) {
        System.out.println(lottosDTO.lottos().size() + "개를 구매했습니다.");
        lottosDTO.lottos().forEach(lottoDto ->
                System.out.println(lottoDto.numbers())
        );
    }
}
