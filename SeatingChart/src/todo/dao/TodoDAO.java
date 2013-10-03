/**
 *
 */
package todo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.vo.TodoValueObject;

public class TodoDAO extends CommonMySQLDAO {
	
	String title;
	String task;
	
	public List<TodoValueObject> todoList(String title , String task) throws Exception {
		this.title = title;
		this.task = task;
		List<TodoValueObject> returnList = new ArrayList<TodoValueObject>();

		String sql = "SELECT title , task FROM seating.status";

		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {
			TodoValueObject vo = new TodoValueObject();

			vo.setTitle(rs.getString("title"));
			vo.setTask(rs.getString("task"));
			
			returnList.add(vo);
		}
		
		return returnList;
	}

	/**
	 * 更新処理を行う。
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int registerUpdate(String task , String title) throws Exception {
		
		String sql = "UPDATE seating.status SET task = ? WHERE title = ?";

		// プリペアステートメントを取得し、実行SQLを渡す
		int result =0;
		try {
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setString(1, task);
			statement.setString(2, title);
			result = statement.executeUpdate();

			// コミットを行う
			super.commit();
		} catch (Exception e) {
			super.rollback();
			throw e;
		}

		return result;
	}

	/**
	 * 表示するタスクの番号を指定して、タスク詳細を返す。
	 * @param id 表示対象のタスクID
	 * @return
	 * @throws Exception
	 */
	public TodoValueObject detail(String title) throws Exception {
		TodoValueObject vo = new TodoValueObject();

		String sql = "SELECT title , task FROM seating.status WHERE title like ?";
		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setString(1, title);
		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {

			vo.setTitle(rs.getString("title"));
			vo.setTask(rs.getString("task"));
		}
		return vo;
	}
}
