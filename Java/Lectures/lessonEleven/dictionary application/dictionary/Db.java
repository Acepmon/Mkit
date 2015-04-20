package dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Db {
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DATABASE_URL = "jdbc:mysql://localhost/dictionary?useUnicode=yes&characterEncoding=UTF-8";
	public static Connection connect() {
		Connection connection = null; 
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, "root", "");
			
		}catch(Exception e) {
		}
		return connection;
	}
	public static ResultSet runQuery(String query) {
		System.out.println(query);
		Connection con = connect();
		Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			if(query.toLowerCase().startsWith("update")||query.toLowerCase().startsWith("insert")||query.toLowerCase().startsWith("delete")) {
				st.execute(query);
			}else
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static String[] getByArray(String query)
	{
		ResultSet rs = runQuery(query);
		try {
			rs.next();
			int colCount = rs.getMetaData().getColumnCount();
			String result[] = new String[colCount];
			for (int i = 1; i <= colCount; i++) 
			{
				result[i-1] = rs.getString(i);
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String[] getByColumn(String query)
	{
		ResultSet rs = runQuery(query);
		Vector v = new Vector();
		try {
			while(rs.next())
			v.add(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result[] = new String[v.size()];
		for (int i = 0; i < v.size(); i++) {
			result[i] = v.get(i).toString();
		}
		return result;
	}
	public static Object getValue(String query) {
		ResultSet rs = runQuery(query);
		try {
			rs.next();
			return rs.getObject(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static int getInt(String query) {
		Object val = getValue(query);
		return Integer.parseInt(val.toString());
	}
	public static double getDouble(String query) {
		Object val = getValue(query);
		return Double.parseDouble(val.toString());
	}
	public static String getString(String query) {
		Object val = getValue(query);
		return val.toString();
	}
	public static String escape(String data){
		String  tmp = "";
		for (int i = 0; i < data.length(); i++) {
			if(data.charAt(i)=='\'')
				tmp +="\\"+"'";
			else 
				tmp += data.charAt(i);
		}
		return tmp;
	}
	public static PreparedStatement runPreparedStatement(String query) {
		Connection conn = connect();
		  
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
}