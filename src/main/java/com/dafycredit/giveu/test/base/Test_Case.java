package com.dafycredit.giveu.test.base;

import java.util.List;

public class Test_Case extends Test_Base{
	
	private List<Test_Step> steps;

	public List<Test_Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Test_Step> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "TestCase "+super.getName()+" [steps=" + steps + "]";
	}

}
