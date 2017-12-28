package com.dafycredit.giveu.test.base;

import java.util.LinkedHashMap;

/**
 * <br>对应于XML文件中的unit元素</br>
 *
 * @version 1.0
 * @since   1.0
 */
public class Test_Unit extends Test_Base{
	
	private LinkedHashMap<String,Test_Case> caseMap;

    public LinkedHashMap<String,Test_Case> getCaseMap() {
        return caseMap;
    }

    public void setCaseMap(LinkedHashMap<String,Test_Case> caseMap) {
        this.caseMap = caseMap;
    }

	@Override
	public String toString() {
		return "TestUnit [caseMap=" + caseMap + "]";
	}
}
