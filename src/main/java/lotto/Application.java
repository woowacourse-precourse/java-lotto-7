package lotto;





/*
1)구입 금액 입력 기능
-> Exception : 자연수가 아닌 값 입력 시 오류
-> Exception : 1000원으로 나누어 떨어지지 않을 시 예외 처리
2)금액에 맞게 랜덤 번호 추출해주는 기능
3)랜덤 번호 출력 기능
4)당첨 번호 입력 기능
-> 1부터 45사이의 숫자가 아닐 시 입력 오류
5)보너스 번호 입력 기능
6)당첨 통계 계산 기능
7)당첨 통계 출력 기능
8)총 수익률 계산 기능
-> 소수점 둘째자리에서 반올림
9)총 수익률 출력 기능

*/


import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
