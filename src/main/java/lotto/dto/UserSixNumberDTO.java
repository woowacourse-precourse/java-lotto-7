package lotto.dto;

import lotto.domain.Lotto;

public class UserSixNumberDTO {
    private final Lotto userSixNumber;

    private UserSixNumberDTO(Lotto userSixNumber) {
        this.userSixNumber = userSixNumber;
    }

    public static UserSixNumberDTO of(Lotto userSixNumber) {
        return new UserSixNumberDTO(userSixNumber);
    }

    public Lotto getUserSixNumber() {
        return userSixNumber;
    }
}
