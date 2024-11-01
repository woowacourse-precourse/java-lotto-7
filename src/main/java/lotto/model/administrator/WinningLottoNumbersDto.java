package lotto.model.administrator;

import java.util.List;

public record WinningLottoNumbersDto(List<Integer> lottoNumbers, int bonusNumber) {

    public static WinningLottoNumbersDto from(Lotto lotto, LottoBonusNumber bonusNumber) {
        return new WinningLottoNumbersDto(
                lotto.getNumbers(),
                bonusNumber.getBonusNumber()
        );
    }
}
