package com.biz.bank.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.bank.vo.BankVO;

public class BankService {

	List<BankVO> bankList;
	String strFile;

	public BankService(String strFile) {

		bankList = new ArrayList();
		this.strFile = strFile;

	}

	public void readfile() {
		FileReader fr;
		BufferedReader br;

		try {
			fr = new FileReader(strFile);
			br = new BufferedReader(fr);

			while (true) {
				String reader = br.readLine();
				if (reader == null)
					break;
				String[] sl = reader.split(":");
				BankVO vo = new BankVO();
				vo.setStrId(sl[0]);
				vo.setIntBalance(Integer.valueOf(sl[1]));
				vo.setStrLastDate(sl[2]);
				bankList.add(vo);
			}
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void BankOutput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호를 입력하세요");
		String scanner = scan.nextLine();

		boolean b = false;
		BankVO bankVO = null;
		for (BankVO v : bankList) {
			if (v.getStrId().equals(scanner)) {
				System.out.println("있다");
				b = true;
				bankVO = v;
				break;
			}
		}
		if (bankVO == null) {
			System.out.println("없다");
			return;
		}
		// 원잔액 추출
		int intBalance2 = bankVO.getIntBalance();
		System.out.print("출금액을 입력 >>");
		String strOutput = scan.nextLine();
		int intOutput = Integer.valueOf(strOutput);
		if (intBalance2 < intOutput) {
			System.out.println("잔액이 부족하여 출금 못함");
			return;
		}
		int intAfterBalance = intBalance2 + Integer.valueOf(strOutput);
		bankVO.setIntBalance(intAfterBalance);
		String strDate =LocalDate.now().toString();
		bankVO.setStrLastDate(strDate);
		System.out.println("==================================");
		System.out.println("출금이 완료되었습니다");
		System.out.println("----------------------------------");
		System.out.println("원잔액 :" + intBalance2);
		System.out.println("출금액 :" + strOutput);
		System.out.println("현잔액 :" + bankVO.getIntBalance());
		System.out.println("==================================");
	}

	public void BankInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호를 입력하세요");
		String scanner = scan.nextLine();

		boolean b = false;
		BankVO bankVO = null;
		for (BankVO v : bankList) {
			if (v.getStrId().equals(scanner)) {
				System.out.println("있다");
				b = true;
				bankVO = v;
				break;
			}
		}
		if (bankVO == null) {
			System.out.println("없다");
			return;
		}
		// 원잔액 추출
		int intBalance2 = bankVO.getIntBalance();
		System.out.print("입금액을 입력 >>");

		String strInput = scan.nextLine();
		int intAfterBalance = intBalance2 + Integer.valueOf(strInput);
		bankVO.setIntBalance(intAfterBalance);
		// 현재 시스템의 날짜를 문자열로 가져오기
		// 1.8 이상에서만 작동
		String strDate =LocalDate.now().toString();
		bankVO.setStrLastDate(strDate);
		System.out.println("==================================");
		System.out.println("입금이 완료되었습니다");
		System.out.println("----------------------------------");
		System.out.println("원잔액 :" + intBalance2);
		System.out.println("입금액 :" + strInput);
		System.out.println("현잔액 :" + bankVO.getIntBalance());
		System.out.println("==================================");
	}

	public void BankWon() {
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("계좌번호\t잔액\t최종거래일");
		for (BankVO vo : bankList) {
			System.out.printf("%5s\t%10d\t%s\n",
			vo.getStrId(),
			vo.getIntBalance(),
			vo.getStrLastDate());
		}
		System.out.println("+++++++++++++++++++++++++++++++");

	}

}