package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Board;
import model.User;
import net.sf.json.JSONArray;
import service.DAO;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	DAO instance = DAO.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");

		String command = request.getParameter("command");
		if (command == null) {
			command = "selectAll";
		}
		if (command.equals("selectAll")) {
			list(request, response);
		} else if (command.equals("read")) {
			read(request, response);
		} else if (command.equals("updateForm")) {
			updateForm(request, response);
		} else if (command.equals("update")) {
			update(request, response);
		} else if (command.equals("delete")) {
			delete(request, response);
		} else if (command.equals("insertContent")) {
			insert(request, response);
		} else if (command.equals("login")) {
			login(request, response);
		} else if (command.equals("signup")) {
			signUp(request, response);
		} else if (command.equals("selectType")) {
			type(request, response);
		} else if (command.equals("selectMine")) {
			mine(request, response);
		} else if (command.equals("loginstatus")) {
			loginstatus(request, response);
		} else if (command.equals("chartview")) {
			toptenChartView(request, response);
		} else if (command.equals("typeCount")) {
			count(request, response);// 지정한타입의 회원숫자출력
		}

	}

	protected void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";
		String type = request.getParameter("type");
		JSONArray jlist = null;
		try {
			jlist = JSONArray.fromObject(instance.userCount());
			request.setAttribute("count", jlist);
			url = "chartview2.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void loginstatus(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("loginsuccess.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("errorMsg", "이용권한이 없습니다.");
			e.printStackTrace();

		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "fail.jsp";
		JSONArray jlist = null;
		try {
			jlist = JSONArray.fromObject(instance.getAllContents());
			request.setAttribute("list", jlist);
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void type(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "fail.jsp";
		String type = request.getParameter("type");
		System.out.println(type);
		JSONArray jlist = null;
		try {
			jlist = JSONArray.fromObject(instance.getBoard(type));
			request.setAttribute("list", jlist);
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void mine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "fail.jsp";
		User user = (User) request.getSession().getAttribute("account");
		String writer = user.getId();
		JSONArray jlist = null;
		try {
			jlist = JSONArray.fromObject(instance.getMyBoard(writer));
			request.setAttribute("list", jlist);
			url = "list.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "fail.jsp";
		String strNum = request.getParameter("num");

		if (strNum == null) {
			url = "index.html";
			response.sendRedirect(url);
			return;
		}
		int num = Integer.parseInt(strNum);

		Board content = instance.getContent(num, true);
		if (content == null) {
			response.sendRedirect(url);
			return;
		} else {
			request.setAttribute("resultContent", content);
			url = "read.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
	}

	protected void updateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";
		String strNum = request.getParameter("num");
		if (strNum == null || strNum.trim().length() == 0) {
			url = "index.html";
			response.sendRedirect(url);
			return;
		}
		int num = Integer.parseInt(strNum);
		if (instance.getContent(num, false) == null) {
			response.sendRedirect(url);
			return;
		} else {
			request.setAttribute("resultContent", instance.getContent(num, false));
			url = "update.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";
		String strNum = request.getParameter("num");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		if (strNum == null || strNum.trim().length() == 0 || title == null || title.trim().length() == 0
				|| writer == null || writer.trim().length() == 0 || content == null || content.trim().length() == 0) {
			url = "index.html";
			response.sendRedirect(url);
			return;
		}
		int num = Integer.parseInt(strNum);
		Board bContent = new Board(num, title, writer, content);
		try {
			boolean result = instance.writeContent(bContent);
			if (result) {
				url = "index.html";
				response.sendRedirect(url);
			} else {
				response.sendRedirect(url);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "fail.jsp";
      //User user = (User)request.getSession().getAttribute("account");
      System.out.println("-------에러메시지------");
      System.out.println(request.getSession().getAttribute("errorMsg"));
      System.out.println("delete작동");
      String strNum=request.getParameter("num");
      System.out.println(strNum);
      String writer = request.getParameter("writer");
      System.out.println("writer id는 "+writer);
      if(strNum == null || strNum.trim().length() == 0 ||
            writer == null || writer.trim().length() == 0){
         url = "index.html";
         response.sendRedirect(url);
      }
      int num = Integer.parseInt(strNum);
    	  try {
    		  System.out.println("dao삭제전"+num+" "+writer);
        	  boolean result= instance.deleteContent(num,writer);
             if(result){
                url = "index.html";
                response.sendRedirect(url);                
             }else {   
                 request.getSession().setAttribute("errorMsg","삭제실패");
                response.sendRedirect(url);         
             }
    	  } catch(Exception e) {
    		  e.printStackTrace();
    	  }
	}


	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";
		User user = (User) request.getAttribute("account");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		System.out.println(title);
		System.out.println("writer��");
		System.out.println(writer);
		System.out.println(content);

		if (title == null || title.trim().length() == 0 || writer == null || writer.trim().length() == 0
				|| content == null || content.trim().length() == 0) {
			url = "write.html";
			response.sendRedirect(url);
			return;
		}
		Board gContent = new Board(writer, title, content);
		boolean result;
		try {
			result = instance.writeContent(gContent);
			if (result) {
				url = "index.html";
				response.sendRedirect(url);
				return;
			} else {
				response.sendRedirect(url);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";

		System.out.println("-------에러메시지(로그인시점)------");
		System.out.println(request.getSession().getAttribute("errorMsg"));
		System.out.println("로그인 작동");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if (id != null && password != null && id.length() > 0 && password.length() > 0) {
			try {
				if (instance.logIn(id, password) != null) {
					url = "index.html";
					request.getSession().setAttribute("account", instance.logIn(id, password));
					response.sendRedirect(url);
				} else {
					System.out.println("��Ʈ�ѷ� 2");

					request.getSession().setAttribute("errorMsg", "아이디와 비밀번호를 다시 확인해주세요.");
					request.getRequestDispatcher(url).forward(request, response);
				}
			} catch (SQLException e) {

				request.getSession().setAttribute("errorMsg", "입력한 아이디와 비밀본호가 무효합니다.(SQLError).");
				request.getRequestDispatcher(url).forward(request, response);
				e.printStackTrace();
			}
		}
	}

	protected void toptenChartView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";
		JSONArray jlist = null;
		try {
			jlist = JSONArray.fromObject(instance.getTopTenContents());
			request.setAttribute("toptenlist", jlist);
			url = "chartview.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void signUp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "fail.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if (id != null && password != null && id.length() > 0 && password.length() > 0) {
			try {
				instance.createAccount(id, password, type);
				url = "index.html";
				response.sendRedirect("index.html");
			} catch (Exception e) {
				request.getSession().setAttribute("errorMsg", "새로 저장하고자 하는 부서의 입력 정보가 무효합니다. 재확인 해 주세요");
				request.getRequestDispatcher(url).forward(request, response);
				e.printStackTrace();
			}
		}
	}

}