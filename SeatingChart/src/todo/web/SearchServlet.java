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
		
		// 入力内容を引数として渡す
		String title = request.getParameter("title");
		String task = request.getParameter("task");
		String names = request.getParameter("names");

		// voの作成
		TodoValueObject vo = new TodoValueObject();

		// タスク１件のvoをリクエスト属性へバインド
		request.setAttribute("vo", vo);
		
		// DAOの取得
		TodoDAO dao = new TodoDAO();
		if(task != null){
			try {
				dao.statusUpdate(task,names);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		try {
			// タスクのリストを一覧で取得し、リクエスト属性へ格納する
			List<TodoValueObject> list = dao.todoList();
			request.setAttribute("todoList", list);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		// DAOの処理が完了したら接続を閉じる
		dao.closeConnection();
		
		RequestDispatcher rd = request.getRequestDispatcher("/seating.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doGet(request, response);
	}
}
