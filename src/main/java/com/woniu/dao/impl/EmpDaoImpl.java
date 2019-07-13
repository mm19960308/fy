package com.woniu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.dao.IEmpDao;
import com.woniu.domain.Emp;
import com.woniu.utils.JdbcUtils;

public class EmpDaoImpl implements IEmpDao {
	
	@Override
	public void save(Emp e) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into emp values(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDate(2, new java.sql.Date(e.getHiredate().getTime()));
			ps.setDouble(3, e.getSal());
			ps.setInt(4, e.getDid());
			ps.executeUpdate();
		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		} finally {
			JdbcUtils.free(null, ps, null);
		}
	}

	@Override
	public void delete(Integer eid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from emp where eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, null);
		}
		

	}

	@Override
	public void update(Emp e) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update emp set ename = ?,hiredate = ?,sal = ?, did = ? where eid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setDate(2, new java.sql.Date(e.getHiredate().getTime()));
			ps.setDouble(3, e.getSal());
			ps.setInt(4, e.getDid());
			ps.setInt(5, e.getEid());
			ps.executeUpdate();
		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		} finally {
			JdbcUtils.free(null, ps, null);
		}

	}

	@Override
	public List<Emp> find() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Emp> list = new ArrayList<Emp>();
			while(rs.next()) {
				Emp e = new Emp();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setDid(rs.getInt("did"));
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}

	@Override
	public Emp find(Integer eid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from emp where eid =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			Emp emp = null;
			if(rs.next()) {
				emp = new Emp();
				emp.setEid(rs.getInt("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDid(rs.getInt("did"));
			}
			return emp;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}

	@Override
	public int getRowCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Integer count = null;
			if(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
		
	}

	@Override
	public List<Emp> find(int startLine, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from emp limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startLine);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			List<Emp> list = new ArrayList<>();
		    while(rs.next()) {
		    	Emp emp = new Emp();
		    	emp.setEid(rs.getInt("eid"));
		    	emp.setEname(rs.getString("ename"));
		    	emp.setHiredate(rs.getDate("hiredate"));
		    	emp.setSal(rs.getDouble("sal"));
		    	emp.setDid(rs.getInt("did"));
		    	list.add(emp);
		    }
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}

}
