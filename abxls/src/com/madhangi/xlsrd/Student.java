package com.madhangi.xlsrd;

public class Student {
	public int iRoll = 0;
	public String strName = null;
	public byte bStd = 0;
	public byte bSec = 0;
	public byte bSchool = 0;
	public String strSchool = null;
	public byte bPremises = 0;
	public byte bResult = 0;
	public String strEmail = null;
	public String strMobile = null;
	public int iSiteCount = 0;
	public int iFunCount = 0;
	
	//	School numbers
	public byte NSN	= 1;
	public byte SCS	= 2;
	
	//	Premises numbers
	public byte bChrompetBranch	= 1;
	public byte bNewColonyBranch	= 2;
	public byte bSchoolPremises	= 3;
	
	//	Results
	public byte bParticipator = 0;
	public byte bTopper = 1;
	public byte bAchiever = 2;
	public byte bPerformer = 3;

	public Student() {
		clearAll();
	}

	private byte getPremisesNo(int iRoll) {
		if(0 >= iRoll) {
			return 0;
		}
		//	Chrompet branch
		if(1 <= iRoll && 100 >= iRoll)
			return bChrompetBranch;
		//	New Colony branch
		if(1001 <= iRoll && 1075 >= iRoll) 
			return bNewColonyBranch;
		//	In their respective schools
		return bSchoolPremises;
	}

	/*private byte getSchoolNo(String strVal) {
		if(null == strVal)
			return 0;
		else if(strVal.equalsIgnoreCase("N.S.N.Mat.Hr.Sec.School"))
			return NSN;
		else if(strVal.equalsIgnoreCase("S.C.S.Mat.Hr.Sec.School"))
			return SCS;

		return 0;
	}*/
	
	public byte getClassNo(String strRomanValue) {
		byte iClass = 0;
		if(null == strRomanValue)
			return 0;
		if(strRomanValue.equalsIgnoreCase("I") || strRomanValue.equalsIgnoreCase("SM1")) {
			iClass = 1;
		} else if(strRomanValue.equalsIgnoreCase("II") || strRomanValue.equalsIgnoreCase("SM2")) {
			iClass = 2;
		} else if(strRomanValue.equalsIgnoreCase("III")) {
			iClass = 3;
		} else if(strRomanValue.equalsIgnoreCase("IV")) {
			iClass = 4;
		} else if(strRomanValue.equalsIgnoreCase("V")) {
			iClass = 5;
		} else if(strRomanValue.equalsIgnoreCase("VI")) {
			iClass = 6;
		} else if(strRomanValue.equalsIgnoreCase("VII")) {
			iClass = 7;
		} else if(strRomanValue.equalsIgnoreCase("VIII")) {
			iClass = 8;
		}
		return iClass;
	}
	
	public byte getSecNo(String strSec) {
		int iSec = 0;
		if(null != strSec) {
			iSec = (byte)strSec.charAt(0);
			if(65 <= iSec && 90 >= iSec)
				iSec = iSec - 65 + 1;
			else
				iSec = 0;
		}
		return (byte)iSec;
	}
	
	public byte getResult(String strResult) {
		byte res = bParticipator;
		if(null == strResult) {
			return bParticipator;
		}
		if(strResult.equalsIgnoreCase("PARTICIPATOR"))
			res = bParticipator;
		else if(strResult.equalsIgnoreCase("topper"))
			res = bTopper;
		else if(strResult.equalsIgnoreCase("achiever"))
			res = bAchiever;
		else if(strResult.equalsIgnoreCase("performer"))
			res = bPerformer;
		
		return res;
	}
	
	public void setValue(int iPos, String strVal) {
		if(null == strVal) {
			return;
		}
		switch(iPos) {
		case 1:
			iRoll = Integer.parseInt(strVal);
			bPremises = getPremisesNo(iRoll);
			break;
		case 2:
			strName = strVal;
			break;
		case 3:
			bStd = getClassNo(strVal);
			break;
		case 4:
			bSec = getSecNo(strVal);
			break;
		case 5:
			if(!strVal.equalsIgnoreCase("0"))
				strSchool = strVal;
			break;
		case 6:
			if(10 <= strVal.length())
				strMobile = strVal;
			break;
		case 7:
			bResult = getResult(strVal);
			break;
		}
	}
	
	public int getIntValue(int iPos) {
		int iRetVal = 0;
		switch(iPos) {
		case 1:
			iRetVal = iRoll;
			break;
		case 2:
			iRetVal = bResult;
			break;
		case 3:
			iRetVal = bStd;
			break;
		case 4:
			iRetVal = bSec;
			break;
		case 5:
			iRetVal = bPremises;
			break;
		}
		return iRetVal;
	}
	
	public String getStringValue(int iPos) {
		String strRetVal = null;
		switch(iPos) {
		case 6:
			strRetVal = strName;
			break;
		case 7:
			strRetVal = strMobile;
			break;
		case 8:
			strRetVal = strSchool;
			break;
		}
		return strRetVal;
	}

	public void clearAll() {
		strSchool = "";
		strName = "";
		bPremises = 0;
		strEmail = "";
		strMobile = "";
		iSiteCount = 0;
		iFunCount = 0;
		bStd = 0;
		bSec = 0;
		bResult = bParticipator;
	}
}
