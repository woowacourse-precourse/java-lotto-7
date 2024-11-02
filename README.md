# java-lotto-precourse


숫자입력 받기
-> valid check
숫자가 맞는가?
금액 % 1000 이 0이 맞는가?
-> 0개 구매 안내

로또 번호 입력 받기
-> valid check
1,2,3,4,5,6 형식인가(정규식)
각각 1-45 이내
중복 확인

보너스 번호 1-45 이내의 숫자인가
기본 번호와 중복 확인

로또 번호 발행
출력

당첨 내역 확인

당첨 내역 계산
set, contain 으로 할 것인가..? -> 시간 복잡도 1, 최악 n -> 개수 파악
보너스 번호와 일치하는가 -> 개수 파악 -> 로또번호도 set으로 구성

결과 출력
enum클래스에 맞춘 개수에 따른 상금 입력 ex > (5,1,30000000)

각 등수 별로 
개수 파악 후 출력 calculateLottoPrize(int matchCount, int bonusMatchCount)
-> LottoResult Enum


수익률 계산
상금 /  투자금 * 100 
투자금 출력





