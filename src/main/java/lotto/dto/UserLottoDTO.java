package lotto.dto;

import lotto.domain.UserLotto;

public class UserLottoDTO {
    private final UserLotto userLotto;

    public UserLottoDTO(UserLotto userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }
    
}
