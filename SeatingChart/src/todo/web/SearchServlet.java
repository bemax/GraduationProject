package todo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDAO;
import todo.vo.TodoValueObject;

/**
 * 検索機能。タスク一覧を取得し、一覧結果へフォワードする。
 */
@WebServlet( urlPatterns={"/search"})
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// voの作成
		TodoValueObject vo = new TodoValueObject();

		// タスク１件のvoをリクエスト属性へバインド
		request.setAttribute("vo", vo);

		// DAOの取得
		TodoDAO dao = new TodoDAO();
		try {
			// 社員一覧の配列を取得
			String[][] list = dao.employeeList();
			request.setAttribute("empList", list);
			
			// 部屋情報の取得
			//TodoValueObject room = dao.roomInfo(roomID);
			//request.setAttribute("roomInfo", room);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			// DAOの処理が完了したら接続を閉じる
			dao.closeConnection();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}
}
