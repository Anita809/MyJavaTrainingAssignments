package com.java.bank;

 class AssociationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SavingsAccount source=new SavingsAccount();
        SavingsAccount target=new SavingsAccount();
        FundTransfer fundTransfer=new FundTransfer();
		fundTransfer.fundsTransferService(source,target);	
       
	}
}



