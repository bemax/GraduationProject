package todo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDAO;
import todo.vo.TodoValueObject;

/**
 * タスク詳細画面を表示するサーブレット。
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// DAOの取得
		TodoDAO dao = new TodoDAO();
		
		// リクエストパラメータから選択したnameを取得する
		String paramName = request.getParameter("name");
		
		TodoValueObject vo;
		try {
			// タスク詳細結果を取得
			vo = dao.detail(paramName);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			throw new ServletException(e);
		} finally {
			// DAOの処理が完了したら接続を閉じる
			dao.closeConnection();
		}
		
		// タスク１件のvoをリクエスト属性へバインド
		request.setAttribute("vo", vo);

		// 画面を返す
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
	}
}
