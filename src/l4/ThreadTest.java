package l4;

import java.util.Scanner;


public class ThreadTest extends Thread{
    String name;
	long start, end;
	long ans;
	int number;
		
	public ThreadTest(String name, long start, long end, int number) {
	    this.name=name;
	    this.start=start;
	    this.end=end;
	    this.number=number;
	}
		
	public void running() { 
	       for (long i = start; i < end; i++) { 
	           if (contain(i, number)) ans += i; 
	       }
	}
		
	private boolean contain(long number, int X) { 
	    return String.valueOf(number).contains(String.valueOf(X)); 
	}
	
	 public static void main(String[] args) {
		 Scanner enter=new Scanner(System.in);
		 int X=enter.nextInt();
		 ThreadTest thread1=new ThreadTest("thread1", 1, 200000000, X);
		 ThreadTest thread2=new ThreadTest("Thread2", 200000000, 400000000, X);
		 ThreadTest thread3=new ThreadTest("Thread3", 400000000, 600000000, X);
		 ThreadTest thread4=new ThreadTest("Thread4", 600000000, 800000000, X);
		 ThreadTest thread5=new ThreadTest("Thread5", 800000000, 1000000000, X);
		 thread1.start();
		 thread2.start();
		 thread3.start();
		 thread4.start();
		 thread5.start();
		 while(true) {
             if((thread1.isAlive()||thread2.isAlive()||thread3.isAlive()||thread4.isAlive())==false) {
            	 long sum=thread1.ans+thread2.ans+thread3.ans+thread4.ans+thread5.ans;
                 System.out.println(sum); 
                 break; 
             }
	     }	
	 }
}