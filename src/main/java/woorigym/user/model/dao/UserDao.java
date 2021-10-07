package woorigym.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import woorigym.common.*;
import woorigym.user.model.vo.UserTable;

public class UserDao {

	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	public int login(Connection conn, String user_id, String user_pwd) {
		int result = 0; // �α��� ���� : 0
		String sql ="select user_pwd from member where user_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("�α��� dao ����");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				if(rset.getString(1).equals(user_pwd)) {
					System.out.println("����");
					return 1; // �α��� ����
				}
				else {
					System.out.println("��й�ȣ ����ġ");
					return 0; //��й�ȣ ����ġ
				}
			}
			System.out.println("���̵� ����");
			return -1; //���̵� ����
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(rset);
			jdbcTemplate.close(pstmt);
		}
		return -2; //������ ���̽� ����
	}
	
	public int userInsert(Connection conn, UserTable user) {
		int result = 0;
		String sql ="insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		return result;
	}

}
