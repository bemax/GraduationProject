package todo.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDAO;
//import todo.util.SimpleMailSender;
import todo.vo.TodoValueObject;

/**
 * 登録処理を行う。
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを受け取り、更新VOに格納する準備をする
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Boolean viewIP = Boolean.valueOf(request.getParameter("ViewIP"));
		Boolean viewID = Boolean.valueOf(request.getParameter("ViewID"));
		String ipAddress = request.getParameter("ipAddress");
		int localPhoneNumber = Integer.parseInt(request.getParameter("localPhoneNumber"));
		int statusID = Integer.parseInt(request.getParameter("statusID"));
		//java.util.Date lastUpdate = (new SimpleDateFormat(DATE_PATTERN)).parse(request.getParameter("lastUpdate"));
		int roomID = Integer.parseInt(request.getParameter("roomID"));
		String message = request.getParameter("message");
		

		// VOへ格納する。登録されるValueObjectの期限(limit)はvoではinputLimitになる。
		TodoValueObject vo = new TodoValueObject();
		vo.setEmployeeID(employeeID);
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setIpAddress(ipAddress);
		vo.setViewIP(viewIP);
		vo.setViewID(viewID);
		vo.setLocalPhoneNumber(localPhoneNumber);
		vo.setStatusID(statusID);
		//vo.setLasuUpdate(lasuUpdate);
		vo.setRoomID(roomID);
		vo.setMessage(message);

		// 入力チェックを行う。
		//boolean checkResult = vo.valueCheck();

		// もし入力チェックエラーがあった場合は、エラーメッセージを表示し、再入力させるため元の詳細画面へ戻る
		/**if (! checkResult ) {
			request.setAttribute("errorMessages", vo.getErrorMessages());
			// タスク１件のvoをリクエスト属性へバインド
			request.setAttribute("vo", vo);

			// 詳細画面を表示する
			RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
			rd.forward(request, response);
			return;
		}**/

		// DAOの取得
		TodoDAO dao = new TodoDAO();
		//String message = "";
		try {
			// 更新または登録処理を行う
			// 最終更新日時がnullのときは新規登録、それ以外は更新
			if (vo.getLasuUpdate() == null) {
				dao.registerInsert(vo);
				//message = "タスクの新規登録処理が完了しました。";
				//setMessage(request, message);
			} else {
				//dao.registerUpdate(vo);
				//message = "タスク[ " + id + " ]の更新処理が完了しました。";
				//setMessage(request, message);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			// DAOの処理が完了したら接続を閉じる
			dao.closeConnection();
		}

		/*
		String toAddr = "toaddr@example.com";
		String fromAddr = "fromaddr@example.com";
		String personName = "Mail Test User";
		String subject = "TODO管理アプリケーションからの報告です";
		// 完了時にメールを送信する
		SimpleMailSender mail = new SimpleMailSender();
		try {
			mail.sendMessage(toAddr, fromAddr, personName, subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// 登録完了→一覧画面を表示する
		RequestDispatcher rd = request.getRequestDispatcher("/search");
		rd.forward(request, response);
	}


	/**
	 * JSPで表示するメッセージを設定する。
	 *
	 * @param request
	 *            サーブレットリクエスト
	 * @param message
	 *            メッセージ文字列
	 */
	protected void setMessage(HttpServletRequest request, String message) {
		request.setAttribute("message", message);
	}

}
