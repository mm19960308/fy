package com.woniu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.runners.ParentRunner;

import com.woniu.dao.IDeptDao;
import com.woniu.domain.Dept;
import com.woniu.utils.JdbcUtils;

public class DeptDaoImpl implements IDeptDao {

	@Override
	public void save(Dept d) {
		Connection conn = null;
		PreparedStatement ps = null;
		 try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into dept values(null, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDname());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, null);
		}

	}

	@Override
	public void delete(Integer did) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from dept where did = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, null);
		}

	}

	@Override
	public void update(Dept d) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update dept set dname = ? where did = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDname());
			ps.setInt(2, d.getDid());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, null);
		}

	}

	@Override
	public List<Dept> find() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from dept";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Dept> list = new ArrayList<Dept>();
			while(rs.next()) {
				Dept d = new Dept();
				d.setDid(rs.getInt("did"));
				d.setDname(rs.getString("dname"));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}

	@Override
	public Dept find(Integer did) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from dept where did = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			rs = ps.executeQuery();
			Dept d = null;
			if(rs.next()) {
			    d = new Dept();
				d.setDid(rs.getInt("did"));
				d.setDname(rs.getString("dname"));
			}
			return d;
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
			String sql = "select count(*) from dept";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Integer rowCount = null;
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
			return rowCount;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
		
	}

	@Override
	public List<Dept> find(int startLine, int size) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from dept limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startLine);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			List<Dept> list = new ArrayList<Dept>(); 
			while(rs.next()) {
				Dept d = new Dept();
				d.setDid(rs.getInt("did"));
				d.setDname(rs.getString("dname"));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}

}
