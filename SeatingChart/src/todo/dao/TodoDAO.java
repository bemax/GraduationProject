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
	
	public List<TodoValueObject> todoList() throws Exception {
		List<TodoValueObject> returnList = new ArrayList<TodoValueObject>();

		// その部屋に登録されている人の名前や座標など執務室レイアウト表示に必要な情報を取得するsql
		String sql = "SELECT emp.FirstName,emp.LastName,emp.LocalPhoneNumber," +
				"emp.LeftX,emp.LeftY,emp.RightX,emp.RightY,room.Width,room.Height" +
				"bul.Bulletin,sta.Status,sta.Color" +
				"FROM seating.employee emp JOIN seating.Room room" +
				"ON emp.RoomID = room.RoomID JOIN seating.Bulletin bul" +
				"ON emp.RoomID = nul.RoomID JOIN seating.Status sta" +
				"JOIN emp.StatusID = sta.StatusID";

		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {
			TodoValueObject vo = new TodoValueObject();

			vo.setFirstName(rs.getString("FirstName"));
			vo.setLastName(rs.getString("LastName"));
			vo.setLocalPhoneNumber(rs.getInt("localPhoneNumber"));
			vo.setLeftX(rs.getInt("LeftX"));
			vo.setLeftY(rs.getInt("leftY"));
			vo.setRightX(rs.getInt("rightX"));
			vo.setRightY(rs.getInt("rightY"));
			vo.setWidth(rs.getInt("Width"));
			vo.setHeight(rs.getInt("Height"));
			vo.setBulletin(rs.getString("Bulletin"));
			vo.setStatus(rs.getString("Status"));
			vo.setColor(rs.getString("Color"));

			
			returnList.add(vo);
		}
		
		return returnList;
	}


	/**
	 * 新規登録処理を行う。
	 * @param vo 入力されたタスク内容。
	 * @return 追加された件数
	 * @throws Exception
	 */
	public int registerInsert(TodoValueObject vo) throws Exception {

		String sql = "INSERT INTO seating.employee (EmployeeID,FirstName,LastName,IPAddress,ViewIP," +
				"ViewID,LocalPhoneNumber,StatusID,LastUpdate,RoomID,Message,LeftX,LeftY,RightX,RightY,destination," +
				"startTime,endTime,neFLG,nrFLG)"  +
				"VALUES (?,?,?,?,?,?,?,?,now(),?,?,null,null,null,null,null,null,null,false,false)";

		int result = 0;
		// プリペアステートメントを取得し、実行SQLを渡す
		try {
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setInt(1, vo.getEmployeeID());
			statement.setString(2, vo.getFirstName());
			statement.setString(3, vo.getLastName());
			statement.setString(4, vo.getIpAddress());
			statement.setBoolean(5, vo.isViewIP());
			statement.setBoolean(6, vo.isViewID());
			statement.setInt(7, vo.getLocalPhoneNumber());
			statement.setInt(8, vo.getStatusID());
			statement.setInt(9, vo.getRoomID());
			statement.setString(10, vo.getMessage());
			
			/**statement.setInt(11, vo.getLeftX());
			statement.setInt(12, vo.getLeftY());
			statement.setInt(13, vo.getRightX());
			statement.setInt(14, vo.getRightY());
			statement.setString(15, vo.getDestination());
			statement.setTime(16, vo.getStartTime());
			statement.setTime(17, vo.getEndTime());
			statement.setBoolean(18, vo.isNeFLG());
			statement.setBoolean(19, vo.isNrFLG());**/
			
			

			result = statement.executeUpdate();

			// コミットを行う
			super.commit();
		} catch (Exception e) {
			// ロールバックを行い、スローした例外はDAOから脱出する
			super.rollback();
			throw e;
		}

		return result;
	}
	
	/**
	 * ステータスの更新処理を行う。
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int statusUpdate(String statusID , String names) throws Exception {
		int result =0;
		String nameAry[] = names.split(",");
		for(int i = 0;i < nameAry.length;i++){
			String sql = "UPDATE seating.status SET statusID = ? WHERE firstName = ?";
	
			// プリペアステートメントを取得し、実行SQLを渡す
			
			try {
				PreparedStatement statement = getPreparedStatement(sql);
				statement.setString(1, statusID);
				statement.setString(2, nameAry[i]);
				result = statement.executeUpdate();
	
				// コミットを行う
				super.commit();
			} catch (Exception e) {
				super.rollback();
				throw e;
			}
		}

		return result;
	}
	
	/**
	 * 表示する名前を指定して、個人詳細を返す。
	 * @param firstName 表示対象者の名前(将来的にはＩＰアドレスなど一意な項目に変更)
	 * @return
	 * @throws Exception
	 */
	public TodoValueObject getDetail(String firstName) throws Exception {
		TodoValueObject vo = new TodoValueObject();

		//　マウスオーバーされた人の詳細情報を取得する
		String sql = "SELECT FirstName, LastName, IPAdress, ViewIP, ViewID, LocalPhoneNumber, StatusID," +
		"Message, FROM seating.employee WHERE FirstName like ?";
		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setString(1, firstName);
		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {

			vo.setFirstName(rs.getString("firstName"));
			vo.setLastName(rs.getString("lastName"));
			vo.setIpAddress(rs.getString("IPAdress"));
			vo.setViewIP(rs.getBoolean("ViewIP"));
			vo.setViewID(rs.getBoolean("ViewID"));
			vo.setLocalPhoneNumber(rs.getInt("LocalPhoneNumber"));
			vo.setStatusID(rs.getInt("statusID"));
			vo.setMessage(rs.getString("message"));
		}
		return vo;
	}
	
	/**
	 * 表示する掲示板IDを指定して、掲示板の内容を返す。
	 * @param bulletinID
	 * @return
	 * @throws Exception
	 */
	public TodoValueObject getBulletin(int bulletinID) throws Exception {
		TodoValueObject vo = new TodoValueObject();

		String sql = "SELECT Bulletin FROM seating.bulletin WHERE bulletinID like ?";
		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, bulletinID);
		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {

			vo.setBulletin(rs.getString("Bulletin"));
		}
		return vo;
	}
	
	/**
	 * 表示する部屋IDを指定して、部屋詳細を返す。
	 * @param roomID
	 * @return
	 * @throws Exception
	 */
	public TodoValueObject getRoom(int roomID) throws Exception {
		TodoValueObject vo = new TodoValueObject();

		String sql = "SELECT RoomName,Width,Height FROM seating.room WHERE RoomID like ?";
		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, roomID);
		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {

			vo.setRoomName(rs.getString("RoomName"));
			vo.setWidth(rs.getInt("Width"));
			vo.setHeight(rs.getInt("Height"));
		}
		return vo;
	}
	
	/**
	 * 表示する伝言を指定して、伝言詳細を返す。
	 * @param MessageID
	 * @return
	 * @throws Exception
	 */
	public TodoValueObject getMessage(int messageID) throws Exception {
		TodoValueObject vo = new TodoValueObject();

		String sql = "SELECT SendID,ReceiveID,Message,Time,BookMark,既読フラグ FROM seating.message WHERE messageID like ?";
		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, messageID);
		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {

			vo.setSendID(rs.getInt("SendID"));
			vo.ReceiveID(rs.getInt("ReceiveID"));
			vo.setMessage(rs.getString("Message"));
			vo.setTime(rs.getTime("Time"));
			vo.setBookMark(rs.getBoolean("BookMark"));
		}
		return vo;
	}
	
	/**
	 * 表示する連絡先を指定して、連絡先詳細を返す。
	 * @param PhoneID
	 * @return
	 * @throws Exception
	 */
	public TodoValueObject getRentalPhone(int PhoneID) throws Exception {
		TodoValueObject vo = new TodoValueObject();

		String sql = "SELECT EmployeeID,Memo FROM seating.RentalPhone WHERE PhoneID like ?";
		
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement = getPreparedStatement(sql);

		statement.setInt(1, PhoneID);
		// SQLを実行してその結果を取得する。
		ResultSet rs = statement.executeQuery();
		
		// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
		while (rs.next()) {

			vo.setEmployeeID(rs.getInt("EmployeeID"));
			vo.setMemo(rs.getString("Memo"));
		}
		return vo;
	}
}
