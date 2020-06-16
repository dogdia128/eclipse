package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import exception.DuplicateException;
import model.Board;
import model.CountType;
import model.User;
import util.DBUtill;;

public class DAO {
	private static DAO instance = new DAO();

	private DAO() {
	}

	public static DAO getInstance() {
		return instance;
	}

	public boolean createAccount(String id, String password, String type) throws DuplicateException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			ArrayList<User> userList = getUserList();
			for (User user : userList) {
				if (user.getId() == id) {
					throw new DuplicateException("이미 존재하는 아이디 입니다.");
				}
			}
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement("insert into User values(?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, type);
			int r = pstmt.executeUpdate();
			if (r != 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.close(con, pstmt);
		}
		return false;
	}

	public ArrayList<User> getUserList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<User> all = null;
		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement("select * from user");

			rset = pstmt.executeQuery();

			all = new ArrayList<>();
			while (rset.next()) {
				all.add(new User(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		} catch (SQLException e) {
			throw new SQLException("검색 시 문제가 발생하였습니다.");
		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return all;
	}

	public User UserInfo(String id, String password) throws SQLException {
		try {
			ArrayList<User> userList = getUserList();
			for (User User : userList) {
				if (User.getId() == id && User.getPassword() == password) {
					return getUser(id);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 업종별 유저수
	public ArrayList<CountType> userCount() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<CountType> all = null;
		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement("select type, count(*) as count from user group by type");

			rset = pstmt.executeQuery();

			all = new ArrayList<>();
			while (rset.next()) {
				all.add(new CountType(rset.getString(1), rset.getInt(2)));
			}
		} catch (SQLException e) {
			throw new SQLException("검색 시 문제가 발생하였습니다.");
		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return all;
	}

	public User getUser(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement("select * from user where id=?");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				return new User(rset.getString(1), rset.getString(2), rset.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtill.close(con, pstmt, rset);
		}

		return null;
	}

	public User logIn(String id, String password) throws SQLException {
		User successuser = null;
		ArrayList<User> userList = getUserList();

		for (User user : userList) {
			if (user.getId().equals(id) && user.getPassword().equals(password)) {
				System.out.println(getUser(id));
				successuser = getUser(id);
				return successuser;
			}
		}
		return successuser;
	}

	public Board getContent(int num, boolean flag) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board vo = null;
		String sql1 = "UPDATE board set readnum=readnum+1 WHERE num=?";

		String sql2 = "SELECT title,writer,content,DATE_FORMAT(writeday,'%Y/%m/%d'),readnum from board WHERE num=?";

		try {
			con = DBUtill.getConnection();
			if (flag) {
				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, num);
				int count = pstmt.executeUpdate();
				if (count == 0) {
					return vo;
				}
			}
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();

			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy/MM/dd");

			if (rset.next()) {
				vo = new Board(num, rset.getString(2), rset.getString(1), rset.getString(3), rset.getString(4),
						rset.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return vo;
	}

	public boolean writeContent(Board vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		String sql = "insert into board(writer, title, content, writeday, readnum) values(?, ?, ?, sysdate() ,0)";

		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			int count = pstmt.executeUpdate();
			if (count != 0) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.close(con, pstmt);
		}
		return result;
	}

	public boolean deleteContent(int num, String writer) {
		System.out.println("dao작동" + num + " " + writer);

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		System.out.println("-------1----------");
		String sql = "Delete from board where num=? and writer=?";

		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(sql);
			System.out.println("-------2----------");
			System.out.println(num);
			System.out.println(writer);

			pstmt.setInt(1, num);
			pstmt.setString(2, writer);
			int count = pstmt.executeUpdate();
			System.out.println("if실행전 count"+count);
			if (count != 0) {
				System.out.println("-------3----------");
				result = true;
			}
		}catch(SQLException e) {
		         e.printStackTrace();
		      
		} finally {
			System.out.println("-------4----------");

			DBUtill.close(con, pstmt);
		}
		System.out.println("-------5----------");

		return result;
	}

	public boolean updateContent(Board vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		String sql = "Update board set title=?,content=? where num=? and writer=?";

		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			pstmt.setString(4, vo.getWriter());
			int count = pstmt.executeUpdate();
			if (count != 0) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.close(con, pstmt);
		}
		return result;
	}

	public Board[] getAllContents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board[] list = null;
		ArrayList<Board> alist = new ArrayList();

		String sql = "SELECT * from board order by num desc";

		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				alist.add(new Board(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getInt(6)));
			}
			list = new Board[alist.size()];
			alist.toArray(list);
		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return list;
	}

	public Board[] getTopTenContents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board[] list = null;
		ArrayList<Board> alist = new ArrayList();

		String sql = "select * from board order by readnum desc limit 10";

		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				alist.add(new Board(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getInt(6)));
			}
			list = new Board[alist.size()];
			alist.toArray(list);
		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return list;
	}

	// 업종별 게시글 모아보기
	public ArrayList<Board> getBoard(String type) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> all = null;
		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement(
					"select board.num,board.title,board.writer,board.content,board.writeday, board.readnum from board, user where user.type=? and user.id=board.writer");
			pstmt.setString(1, type);
			rset = pstmt.executeQuery();
			all = new ArrayList<>();
			while (rset.next()) {
				all.add(new Board(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getInt(6)));
			}

		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return all;
	}

	// 내 게시물 보기
	public ArrayList<Board> getMyBoard(String writer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> all = null;
		try {
			con = DBUtill.getConnection();
			pstmt = con.prepareStatement("select * from board where writer=?");
			pstmt.setString(1, writer);
			rset = pstmt.executeQuery();
			all = new ArrayList<>();
			while (rset.next()) {
				all.add(new Board(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getInt(6)));
			}

		} finally {
			DBUtill.close(con, pstmt, rset);
		}
		return all;
	}

}
