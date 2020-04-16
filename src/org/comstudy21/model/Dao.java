package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import org.comstudy21.jdbcUtil.Util;
import org.comstudy21.main.MainCls;

public class Dao {
	
	
	public static Connection conn = Util.getConnection();
	public static Statement stmt = null;
	public static ResultSet rs = null;
	public static PreparedStatement pstmt;
	
	public static void setConn(Connection conn) {
		Dao.conn = conn;
	}
	
	public static Vector<Vector> selectAll() {
		
		Dao.setConn(Util.getConnection());
		
		Vector<Vector> vector = new Vector<>();
		
		
		String sql = "SELECT * FROM CUSTOMERS";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				Vector v = new Vector<>();
				
				v.add(rs.getInt("no"));
				v.add(rs.getString("name"));
				v.add(rs.getString("email"));
				v.add(rs.getString("phone"));
				vector.add(v);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
					try {
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(conn != null) conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
		}
		
		
		return vector;
	}

	public void insert(Customer dto) {
		
		Dao.setConn(Util.getConnection());
//		MainCls.main(null);
		
		
		String sql = "INSERT INTO CUSTOMERS(name, email, phone) VALUES(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("입력 성공!");
			} else {
				System.out.println("입력 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if(pstmt != null ) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		Dao.setConn(Util.getConnection());
//		MainCls.main(null);
		
	}
	
	
	
	
	
	

	public void delete(Customer dto) {
		
		Dao.setConn(Util.getConnection());
		
		String sql = "DELETE FROM CUSTOMERS WHERE NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("삭제 완료!");
			} else {
				System.out.println("삭제 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		Dao.setConn(Util.getConnection());
		
		
		
		
		
	}
	
	
	

	

	public Vector<Vector> select(Customer customer) {
		
		Vector<Vector> vector = new Vector<Vector>();
		
		Dao.setConn(Util.getConnection());
		
		String sql = "SELECT * FROM CUSTOMERS WHERE NAME=? OR EMAIL=? OR PHONE=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getEmail());
			pstmt.setString(3, customer.getPhone());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Vector v = new Vector();
				
				v.add(rs.getInt("no"));
				v.add(rs.getString("name"));
				v.add(rs.getString("email"));
				v.add(rs.getString("phone"));
				vector.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
		
		Dao.setConn(Util.getConnection());
		
		return vector;
	}
	

}
