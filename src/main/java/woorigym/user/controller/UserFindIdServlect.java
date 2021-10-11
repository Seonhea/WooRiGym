package woorigym.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import woorigym.user.model.service.UserService;

/**
 * Servlet implementation class UserFindIdServlect
 */
@WebServlet("/UserFindIdServlect")
public class UserFindIdServlect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindIdServlect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		UserService findID = new UserService();
		String user_name = request.getParameter("user_name");
		String phone = request.getParameter("phone");
		String result = findID.findId(user_name, phone);
		if(result != null) {
			// ?user_name=�����1&phone=010-1111-2222       -->   ���̵�ã�� Ȯ�ι�� (�ӽ�)
			out.println("���̵� ã�� ����");
			System.out.println(user_name + "���� ���̵��" + result + "�Դϴ�.");
		}
		else {
			System.out.println("������ �ùٸ��� �ʽ��ϴ�.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
