package lotto.dto.request;

public record WinningLottoBonusNumberDTO(
        Integer bonusNumber
) {
    public static WinningLottoBonusNumberDTO of(Integer bonusNumber) {
        return new WinningLottoBonusNumberDTO(bonusNumber);
    }
}
