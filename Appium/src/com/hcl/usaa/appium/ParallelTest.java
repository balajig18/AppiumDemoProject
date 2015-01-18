package com.hcl.usaa.appium;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;


public class ParallelTest {
	@Test  
	   public void test() {      
	      Class[] cls={AppiumDemoTest1.class,AppiumDemoTest2.class };  

	      //Parallel among classes  
	      JUnitCore.runClasses(ParallelComputer.classes(), cls);  

	      //Parallel among methods in a class  
	      JUnitCore.runClasses(ParallelComputer.methods(), cls);  

	      //Parallel all methods in all classes  
	      JUnitCore.runClasses(new ParallelComputer(true, true), cls);     
	   } 

}
