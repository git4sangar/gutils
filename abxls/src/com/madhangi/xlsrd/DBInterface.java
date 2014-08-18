package com.madhangi.xlsrd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBInterface {
	public String strDBUrl	= "jdbc:mysql://localhost:3306/";
	public String strDBName	= "hwcontest";
	public String strUser	= "root";
	public String strPswd	= "";
	public String strTable = "master01";
	
	private Connection conn = null;
	private PreparedStatement prpdStmnt = null;
	
	public DBInterface() throws Exception {
		conn = DriverManager.getConnection(strDBUrl+strDBName, strUser, strPswd);
	}

	public void closeDB() throws Exception {
		conn.close();
	}
	
	public DBInterface(String strUrl, String strName, String user, String pswd) throws Exception {
		strDBUrl	= strUrl;
		strDBName	= strName;
		strUser		= user;
		strPswd		= pswd;
		conn = DriverManager.getConnection(strDBUrl+strDBName, strUser, strPswd);
	}

	public boolean isEntryPresent(int iRoll) throws Exception {
		if(null == strTable || 0 >= iRoll) {
			return true;
		}
		String strSql = "select * from " + strTable + " where roll=" + iRoll + ";";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(strSql);
		rs.last();
		boolean bRet = (rs.getRow() > 0);
		stmt.close();
		return bRet;
	}
	
	public void prepareForWrite() throws Exception {
		String sql	= "insert into " + strTable + " (roll, result, std, sec, premises, name, mobile, school) values (?, ?, ?, ?, ?, ?, ?, ?)";
		prpdStmnt	= conn.prepareStatement(sql);
	}

	public void writeToDB(Student student) throws Exception {
		int iLoop = 0;
		if(null == prpdStmnt) {
			return;
		}

		for(iLoop = 1; iLoop <= 5; iLoop++) {
			prpdStmnt.setInt(iLoop, student.getIntValue(iLoop));
		}

		for(iLoop = 6; iLoop <= 8; iLoop++) {
			prpdStmnt.setString(iLoop, student.getStringValue(iLoop));
		}
		prpdStmnt.executeUpdate();
	}

	public void closeWriting() throws Exception {
		if(null != prpdStmnt) {
			prpdStmnt.close();
		}
	}
}
