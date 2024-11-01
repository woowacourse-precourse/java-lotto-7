package lotto.model;

// UserLotto와 Lotto를 이용하여 유저의 복권 정보를 비교하고 통계하는 메서드들 모음
public class LottoModel {
    UserLotto userLotto;

    public void setUserLotto(int numberOfLotto) {
        userLotto = new UserLotto(numberOfLotto);
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }
}
