package com.java.Abstractexample;

public class AbstractTest {
	public static void main(String[] args) {
		//Cannot instantiate the type MusicalInstrument
		MusicalInstrument mi = new Guitar();
		mi.play();				//mi.tuneStrings();		//mi.pluck();
		System.out.println("--------");
		StringBasedMusicalInstrument sbmi = new Guitar();
		sbmi.play();				sbmi.tuneStrings();		
		//sbmi.pluck();
		System.out.println("--------");
		Guitar myGuitar = new Guitar();
		myGuitar.play();		myGuitar.tuneStrings();				myGuitar.pluck();
	}
}
//INHERITANCE OF IMPLEMENTATION
abstract class MusicalInstrument /*abstract means incomplete  */{
	//method without the body = incomplete = abstract 
	abstract void play(); //play this musical instrument
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument {
	abstract void tuneStrings(); //just the declaration here
}
class Guitar extends StringBasedMusicalInstrument {
	void tuneStrings() { System.out.println("Tuning the Guitar strings...."); }
	void play() {		System.out.println("Playing the Guitar...");          }
	void pluck() { System.out.println("Plucking the Guitar..");  }
}


