package com.java.staticex;

public class KiteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			System.out.println("Begin main");
			
			System.out.println("How many kites present now ?");//0
			Kite.showKiteCount();
			
			Kite kite1 = new Kite("Kishor","Blue",50);
			Kite kite2 = new Kite("Pavan","Green",30);
			Kite kite3 = new Kite("Aniket","Red",40);
			
			System.out.println("How many kites present now ?");//3
			Kite.showKiteCount();
			
			System.out.println("---------------");
			
			kite1.fly();
			kite2.fly();
			kite3.fly();
			
			System.out.println("---------------");
			
			kite1.kiteFight(kite2);
			// |			  | 
			// invoker		reference passed in
			
			
			System.out.println("---------------");
			
			kite1.fly();
			kite2.fly();
			kite3.fly();
			
			System.out.println("---------------");
			
			System.out.println("How many kites present now ?");//3
			Kite.showKiteCount();
			
			System.out.println("End main");
		}
	}

	class Kite
	{
		private String kiteOwner;
		private String kiteColor;
		private int kiteLength; // in mtrs
		private boolean flying; //false
		
		//this is class's data 
		private static int kiteCount; // this is not the object's data 
		public  static void showKiteCount() {
			System.out.println("Kites in the sky !!! "+kiteCount);
		}
		void kiteFight(Kite ref ) { //kite2 is received here on ref | ref is a proxy to kite2 now 
			System.out.println(kiteOwner +" initiated a kite fight with "+ref.kiteOwner);
			
			double value = Math.random()%10;
			
			if(value>0.90) {
				flying=false;
				kiteCount--;
				System.out.println(kiteOwner+"'s kite is down");
			}
			else if (value < 0.50) {
				ref.flying=false;
				kiteCount--;
				System.out.println(ref.kiteOwner+"'s kite is down");
			}
			else if (value > 0.50 && value<0.75) {
				flying=false;
				ref.flying=false;
				kiteCount=kiteCount-2;
				System.out.println(kiteOwner+"'s kite is down");
				System.out.println(ref.kiteOwner+"'s kite is down");
			}
		}
		public Kite(String kiteOwner, String kiteColor, int kiteLength) {
			super();
			this.kiteOwner = kiteOwner;
			this.kiteColor = kiteColor;
			this.kiteLength = kiteLength;
			this.flying=true;
			++kiteCount; // <---each time the value is increased by one
		}
		
		@Override
		public String toString() {
			return "Kite [kiteOwner=" + kiteOwner + ", kiteColor=" + kiteColor + ", kiteLength=" + kiteLength + "]";
		}
		
		void fly() {
			
			if(flying)
				System.out.println(kiteOwner+"'s Kite is flying...");
			else 
				System.out.println(kiteOwner+"'s kite is Not flying...");
		}
		
	}
