package com.java.liscence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Applicant implements Comparable<Applicant>  {
    
	 private String name;
	 private int age;
	 boolean govtid;
	 static boolean testresult;
	 static int applicationformsno=100;
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGovtid() {
		return govtid;
	}

	public void setGovtid(boolean govtid) {
		this.govtid = govtid;
	}

	public static void showFormsCount() {
		 System.out.println("the total number of application forms available per day is "+ applicationformsno);
	 }
	 
	 void formsubmission() {
		 System.out.println("form submited");
	 }
	 
	 void varify() throws UnderAgeException, IdNotFoundException{
		 System.out.println("varifying the documents of " +name);
		 
		 if(age>=18 && govtid==true) {
			 System.out.println("you are eligible to take the driving liscence");
			 System.out.println("driving test is scheduled ");
			 TakingDrivingTest dt = new TakingDrivingTest();
			 dt.driving();
		 }
		 
		 else if(age<18) {
			UnderAgeException ua = new UnderAgeException();
			throw ua;
		 }
		 
		 else if(govtid==false) {
			 IdNotFoundException ide = new IdNotFoundException();
			 throw ide;
		 }
	 }
	 
	 public Applicant(String name,int age,boolean govtid) {
		 this.name=name;
		 this.age=age;
		 this.govtid=govtid;
	 }

	
	@Override
	public int compareTo(Applicant o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

interface DrivingTest{
	abstract void driving(); 
}

final class TakingDrivingTest implements DrivingTest{
	public void driving() {
		boolean testresult=false;
		if(testresult) {
			System.out.println("you passed the driving test");
			System.out.println("you will recieve your driving liscence within 30 days through speed post");
		}
		
		else {
			System.out.println("you failed the test better luck next time");
		}
	}
}

public class LiscenceTest{
	public static void main(String[] args)  {
		
		ArrayList<Applicant> applicantlist = new ArrayList<Applicant>();

		String choice="n";
		
//		Applicant a1= new Applicant("julie",20,true);
//		Applicant a2= new Applicant("dinesh",16,true);
//		Applicant a3= new Applicant("ron",22,false);
//		Applicant a4= new Applicant("asha",23,true);
//		Applicant a5= new Applicant("usha",24,true);
//		
		
		
		try {
			do {
			Scanner scan = new Scanner(System.in);
			System.out.println("enter your name");
			String name=scan.next();
			
			System.out.println("enter your age");
			int age=scan.nextInt();
			
			System.out.println("do you have government id");
			boolean govtid=scan.nextBoolean();
			
            Applicant temp = new Applicant(name,age,govtid);
			
			applicantlist.add(temp);

			Scanner scan5 = new Scanner(System.in);
			System.out.println("Do you wish to add more songs ? (y/n) ");
			choice = scan5.nextLine();
			
			System.out.println("--------------------");
			
//			Applicant person = new Applicant(name,age,govtid);
//			
//			temp.showFormsCount();
		temp.formsubmission();
		temp.varify();
		}while(choice.equalsIgnoreCase("y"));
			
			Applicant a1= new Applicant("julie",20,true);
			Applicant a2= new Applicant("dinesh",20,true);
			Applicant a3= new Applicant("ron",22,false);
			Applicant a4= new Applicant("asha",23,true);
			Applicant a5= new Applicant("usha",24,true);
			
			applicantlist.add(a1);
			applicantlist.add(a2);
			applicantlist.add(a3);
			applicantlist.add(a4);
			applicantlist.add(a5);
			
			a1.formsubmission();
			a1.varify();
			
			a2.formsubmission();
			a2.varify();
			
			a2.formsubmission();
			a2.varify();
			
			a3.formsubmission();
			a3.varify();
			
			a4.formsubmission();
			a4.varify();
			
			a5.formsubmission();
			a5.varify();
			
			System.out.println("--now lets sort it based on other columns too--");
			
			int sortChoice=0;
			
			Comparator<Applicant> cmp = null;

			do {
				System.out.println("Sort by ");
				System.out.println("-----------");
				System.out.println("1. name");
				System.out.println("2. age");
				System.out.println("3. id");
				System.out.println("4. Exit");
				System.out.println("-----------");
				System.out.println("Sort Choice :  ");
				Scanner scan6 = new Scanner(System.in);
				sortChoice = scan6.nextInt();
				switch(sortChoice) {
					case 1: cmp = new NameComparator(); break;
					case 2: cmp = new AgeComparator(); break;
					//case 3: cmp = new IdComparator(); break;
					case 3: System.out.println("Exiting...");
				
				}
				Collections.sort(applicantlist, cmp ); //going with Comparator 
				for(Applicant theApplicant : applicantlist) { // no iterator required
					System.out.println("Applicant : "+theApplicant);
				}
				System.out.println("====================");
			} while(sortChoice!=3);
			
		}
		
		catch (UnderAgeException e) {
			System.out.println(e.getMessage());
		}
		catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
	finally {
		System.out.println("Thank you");
	}
	}
}
			

	class NameComparator implements Comparator<Applicant> {
		public int compare(Applicant x, Applicant y) {
			System.out.println("NameComparator : comparing "+x.getName()+" with "+y.getName());
			return x.getName().compareTo (y.getName());
		}
	}

	class AgeComparator  implements Comparator<Applicant> {
		public int compare(Applicant x, Applicant y) {
			System.out.println("AristComparator : comparing "+x.getAge()+" with "+y.getAge());
			return Integer.compare(x.getAge()  ,    y.getAge()     );

		}
	}
