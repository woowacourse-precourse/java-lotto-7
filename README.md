# 로또 프로젝트

---

## 목차
1. 프로젝트 소개
2. 프로젝트 주요 기능 목록

---

## 1. 프로젝트 소개
로또 프로젝트에서는 사용자가 원하는 금액만큼 로또를 구입하고, 랜덤으로 발행되는 로또의 당첨 내역을 확인할 수 있습니다.
온라인으로 즐기는 가벼운 오락이라고 생각해주시면 좋을 것 같습니다.

---

## 2. 프로젝트 주요 기능 목록
- [구매] 구입 금액을 입력 받는 기능
  * [예외 상황] 구입 금액이 숫자가 아닌 경우
  * [예외 상황] 구입 금액이 1,000원 이상이 아닌 경우
  * [예외 상황] 구입 금액이 1,000원 단위가 아닌 경우


- [구매] 구입 금액에 해당하는 만큼 로또를 발행하는 기능


- [구매] 발행한 로또 수량 및 번호를 출력하는 기능


- [추첨] 당첨 번호를 입력 받는 기능
  * [예외 상황] 당첨 번호가 6개가 아닐 경우
  * [예외 상황] 당첨 번호가 1과 45 사이의 숫자가 아닐 경우
  * [예외 상황] 당첨 번호가 중복될 경우
  * [예외 상황] 당첨 번호의 구분자가 콤마(,)가 아닐 경우


- [추첨] 보너스 번호를 입력 받는 기능
  * [예외 상황] 보너스 번호가 1과 45 사이의 숫자가 아닐 경우
  * [예외 상황] 당첨 번호와 중복될 경우
  * [예외 상황] 보너스 번호가 숫자가 아닐 경우


- [당첨] 사용자가 구매한 로또 번호와 당첨 번호를 비교하는 기능
  * 1등: 6개 번호 일치 / 2,000,000,000원 
  * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 
  * 3등: 5개 번호 일치 / 1,500,000원 
  * 4등: 4개 번호 일치 / 50,000원 
  * 5등: 3개 번호 일치 / 5,000원


- [당첨] 당첨 내역을 출력하는 기능


- [당첨] 수익률을 계산하는 기능


- [당첨] 수익률을 출력하는 기능
