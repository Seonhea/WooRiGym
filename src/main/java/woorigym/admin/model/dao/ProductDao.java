package woorigym.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import woorigym.common.jdbcTemplate;
import woorigym.product.model.vo.*;

public class ProductDao {

	public ProductDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ProductTable> readProductListAll(Connection conn){
		ArrayList<ProductTable> volist = null;
		String sql = "select * from product";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			volist = new ArrayList<ProductTable>();
			System.out.println("product-1");
			if(rset.next()) {
				do {
					ProductTable vo = new ProductTable();
					vo.setProductNo(rset.getString("productNo"));
					vo.setProductName(rset.getString("productName"));
					vo.setParentCategory(rset.getString("parentCategory"));
					vo.setChildCategory(rset.getString("childCategory"));
					vo.setQuantity(rset.getInt("quantity"));
					vo.setPrice(rset.getInt("price"));
					vo.setProductInfoUrl(rset.getString("productInfoUrl"));
					vo.setProductOption(rset.getString("productOption"));
					volist.add(vo);
					System.out.println("product-3");
				} while(rset.next());
			}
		} catch(Exception e) {
			System.out.println("product-4");
			e.printStackTrace();
		} finally {
				jdbcTemplate.close(rset);
				jdbcTemplate.close(pstmt);
			}
		System.out.println("product 리턴은" + volist);
		return volist;
	}
	
	public int addProduct(Connection conn, ProductTable vo) {
		int result = -1;
		String sqlInsert = "INSERT INTO"
				+ " PRODUCT"
				+ " (PRODUCT_NO, PRODUCT_NAME, PARENT_CATEGORY, CHILD_CATEGORY, QUANTITY, PRICE, PRODUCT_INFO_URL, PRODUCT_OPTION)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, vo.getProductNo());
			pstmt.setString(2, vo.getProductName());
			pstmt.setString(3, vo.getParentCategory());
			pstmt.setString(4, vo.getChildCategory());
			pstmt.setInt(5, vo.getQuantity());
			pstmt.setInt(6, vo.getPrice());
			pstmt.setString(7, vo.getProductInfoUrl());
			pstmt.setString(8, vo.getProductOption());
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateProduct(Connection conn, ProductTable vo) {
		int result = -1;
		String sqlUpdate = "UPDATE PRODUCT SET (PRODUCT_NAME=?, PARENT_CATEGORY=?, CHILD_CATEGORY=?, QUANTITY=?, PRICE=?, PRODUCT_INFO_URL=?, PRODUCT_OPTION=?) WHERE PRODUCT_NO=?"; 
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, vo.getProductName());
			pstmt.setString(2, vo.getParentCategory());
			pstmt.setString(3, vo.getChildCategory());
			pstmt.setInt(4, vo.getQuantity());
			pstmt.setInt(5, vo.getPrice());
			pstmt.setString(6, vo.getProductInfoUrl());
			pstmt.setString(7, vo.getProductOption());
			pstmt.setString(8, vo.getProductNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteProduct(Connection conn, String productNo) {
		int result = -1;
		String sqlDelete = "DELETE FROM PRODUCT WHERE PRODUCT_NO=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setString(1, productNo);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcTemplate.close(pstmt);
		}
		return result;
	}
}