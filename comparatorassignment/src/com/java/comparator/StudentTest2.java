package com.java.comparator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


class Student1 implements Comparable<Student1> //isA 
{ 
	String studentname;
	int id;		
	String branch;
	
	public int compareTo(Student1 s) {
		
		System.out.println("compareTo is invoked...comparing "+studentname+" with "+s.studentname);
		return studentname.compareTo(s.studentname);
	}
	public Student1(String studentname,int id, String branch) {
		super();
		this.studentname = studentname;
		this.id = id;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [studentname=" + studentname + ", id=" + id + ", branch=" + branch + "]";
	}
}

public class StudentTest2 {
	public static void main(String[] args) {
		
		TreeSet<Student1> ts = new TreeSet<Student1>();
	
		System.out.println("students list is ready...");;;

		Student1 s1 = new Student1("julie",2,"IS");
		Student1 s2 = new Student1("shree",5,"CS");
		Student1 s3 = new Student1("anita",2,"EI");
		Student1 s4 = new Student1("john",2,"EC");
		
		System.out.println("Adding the students details");
		ts.add(s1); 
		System.out.println("----------");
		
		ts.add(s2); 
		System.out.println("----------");
		
		ts.add(s3); 
		System.out.println("----------");
		
		ts.add(s4); 
		System.out.println("----------");
		
		System.out.println("Student list is ready");
		Iterator<Student1> itr = ts.iterator();
		while(itr.hasNext()) {
			Student1 s = itr.next();
			System.out.println("Student : "+s);
		}	
	}
}