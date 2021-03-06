package woorigym.user.model.dao;

import static woorigym.common.jdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import woorigym.user.model.vo.OrderList;
import woorigym.user.model.vo.OrderTable;

public class OrderListDao {

	public OrderListDao() {
	}
//	  <!-- 주문번호 -->
//  <!-- 날짜 시간 yyyy.mm-dd hh:mm-->
//  상품이미지, 상품명, 수량, 가격, 배송비
	
	public ArrayList<OrderList> readOrderListPeriod(Connection conn, String uid, String startDate ,String endDate){
		System.out.println("uid : "+uid);
		System.out.println("startDate: "+startDate);
		System.out.println("endDate: "+endDate);
		ArrayList<OrderList> volist = null; //null로 초기화하면 에러나기 쉬움.
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT oinfo.order_no,order_total,order_cost, to_char(order_date, 'yyyy-mm-dd hh:mm') order_date,pay_state,order_state, ";
		query += " odetail.product_no, buy_quantity, ";
		query += " product.product_name, product.PRODUCT_INFO_URL";
		query += " FROM ORDERINFO oinfo ";
		query += " join order_detail odetail on oinfo.order_no = odetail.order_no";
		query += " join product product on odetail.PRODUCT_NO = product.PRODUCT_NO";
		query += " WHERE ";
		query += " USER_ID = ?";
		query += " and to_char(order_date,'yyyy-mm-dd')  between ? and ? ";
//		private String order_no;
//		private int order_total;
//		private int order_cost;
//		private String order_date;
//		private String pay_state;
//		private String order_state;
//		private String product_no;
//		private int buy_quantity;
//		private String product_name;
//		private String product_info_url;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, startDate);
			pstmt.setString(3, endDate);
			rset = pstmt.executeQuery();
			volist = new ArrayList<OrderList>();
			if(rset.next()) {
				do {
					OrderList vo = new OrderList();
					vo.setOrder_no(rset.getString("order_no")); //주문번호
					vo.setOrder_total(rset.getInt("order_total")); //가격(할인전)
					vo.setOrder_cost(rset.getInt("order_cost")); //배송비
					vo.setOrder_date(rset.getString("order_date")); //주문일자
					vo.setPay_state(rset.getString("pay_state")); //결제상태
					vo.setOrder_state(rset.getString("order_state")); //배송상태
					vo.setProduct_no(rset.getString("product_no")); //상품번호
					vo.setBuy_quantity(rset.getInt("buy_quantity")); //구매수량
					vo.setProduct_name(rset.getString("product_name")); //상품명
					vo.setProduct_info_url(rset.getString("product_info_url")); //상품이미지url
					volist.add(vo);
				} while(rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rset);
				close(pstmt);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("volist 리턴: "+ volist);
		return volist;
	}
	public int getOrderCount(Connection conn, String uid) { //페이징
		int result = 0;
		//TODO: 쿼리문 수정
		String sql = "select count(order_no) from orderinfo where user_id=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid); //보낼 값
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				result = rset.getInt(1);//1=인덱스 (별칭 필요X)
				System.out.println("2: "+result);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("1: "+result);
		return result;
	}
	public ArrayList<OrderList> selectOrderList(Connection conn, String uid, int start, int end) {
		String sql = "select *	from(select ROWNUM r, t1.*" + 
				" FROM (select * from (" + 
				" SELECT oinfo.order_no,order_total,order_cost,to_char(order_date, 'yyyy-mm-dd hh:mm') order_date,order_state," + 
				"    odetail.product_no, buy_quantity, " + 
				"    product.product_name, product.PRODUCT_INFO_URL" + 
				" FROM ORDERINFO oinfo " + 
				"    join order_detail odetail on oinfo.order_no = odetail.order_no" + 
				"    join product product on odetail.PRODUCT_NO = product.PRODUCT_NO" + 
				" WHERE " + 
				"    USER_ID = ? )" + 
				" order by order_date desc) t1) t2 " + 
				" where r between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		////ArrayList<OrderList> volist = null;
System.out.println(start);
System.out.println(end);
ArrayList<OrderList> volist = new ArrayList<OrderList>();
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				do {
					OrderList vo = new OrderList();
					vo.setOrder_no(rset.getString("order_no")); //주문번호
					vo.setOrder_total(rset.getInt("order_total")); //가격(할인전)
					vo.setOrder_cost(rset.getInt("order_cost")); //배송비
					vo.setOrder_date(rset.getString("order_date")); //주문일자
					vo.setOrder_state(rset.getString("order_state")); //배송상태
					vo.setProduct_no(rset.getString("product_no")); //상품번호
					vo.setBuy_quantity(rset.getInt("buy_quantity")); //구매수량
					vo.setProduct_name(rset.getString("product_name")); //상품명
					vo.setProduct_info_url(rset.getString("product_info_url")); //상품이미지url
					volist.add(vo);
				} while(rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rset);
				close(pstmt);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("페이징 volist 리턴: "+ volist);
		return volist;
	}
	
//	public ArrayList<OrderList> updateOrderCancel(Connection conn, String uid, String order_no){
	public int updateOrderCancel(Connection conn, String uid, String order_no){
//		ArrayList<OrderList> volist = new ArrayList<OrderList>();
		int result = -1;
		PreparedStatement pstmt = null;
//		ResultSet rset = null;
		 String sql = "update orderinfo set order_state='주문취소', pay_state='주문취소'"+ 
				 " where user_id=? and order_no=?";
		 try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, uid);
			 pstmt.setString(2, order_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
//			try {
//				close(rset);
				close(pstmt);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
	}	//return volist;
		 return result;
	}
	
}

		
