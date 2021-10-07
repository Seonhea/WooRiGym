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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		UserService userservice = new UserService();
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("id");
		String user_pwd = request.getParameter("pw");
		
		// login?id=gym11&pw=qw1234  �α��� Ȯ��
		int result = new UserService().Login(user_id, user_pwd);
		if(result == 1) {
			request.getSession().setAttribute("LoginInfo", user_id);
			out.print(user_id + "�� �α��� �����ϼ̽��ϴ�.");
//			out.append("<p>aaa<p/>");
//			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
		else if(result == 0) {
			out.print("��й�ȣ ����ġ");
		}
		else {
			out.print("���̵� �����ϴ�.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
