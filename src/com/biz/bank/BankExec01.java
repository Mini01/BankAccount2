package com.biz.bank;

import java.util.Scanner;

import com.biz.bank.service.BankService;

public class BankExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String namefile = "src/com/biz/bank/bankBalance.txt";
		BankService bs = new BankService(namefile);

		bs.readfile();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("=================================");
			System.out.println("광한루 은행 차세대 시스템 1.0");
			System.out.println("---------------------------------");
			System.out.println("1.입금 2.출금 3.계좌조회 -9.종료");
			System.out.println("---------------------------------");
			System.out.print("업무를 선택하세요 >>");
			String strSelect = scan.nextLine();
			int intSelect = Integer.valueOf(strSelect);
			if (intSelect == -9) {
				System.out.println("업무를 종료합니다");
				break;
			}
			
			if (intSelect == 3)  {
				bs.BankWon();
			}else {
				bs.BankWon();
				if (intSelect == 1)bs.BankInput();
				if (intSelect == 2)bs.BankOutput();
			}
				
		}

	}

}
