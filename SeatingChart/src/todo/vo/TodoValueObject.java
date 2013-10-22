package todo.vo;

import java.sql.Date;
import java.sql.Time;

/**
 * TODO検索結果１行単位のValueObject
 *
 */
public class TodoValueObject {

	/** 社員No */
    private int employeeID;
	
	/** 苗字 */
    private String firstName;

    /** 名前 */
    private String lastName;

    /** IPAddress */
    private String ipAddress;

    /** IPAddressの表示フラグ */
    private boolean viewIP;

    /** 社員No表示フラグ */
    private boolean viewID;

    /** 内線番号 */
    private int localPhoneNumber;
    
    /** ステータスID */
    private int statusID;
    
    /** 更新時間 */
    private Date lasuUpdate;
    
    /** 所属部屋 */
    private int roomID;
    
    /** 備考欄 */
    private String message;
    
    /** 左上のX座標 */
    private int leftX;
    
    /** 左上のY座標 */
    private int leftY;
    
    /** 右上のX座標 */
    private int rightX;
    
    /** 右上のY座標 */
    private int rightY;
    
    /** 行先名 */
    private String destination;
    
    /** 開始時間 */
    private Time startTime;
    
    /** 終了時間 */
    private Time endTime;
    
    /** 直行フラグ */
    private boolean neFLG;
        
	/** 直帰フラグ */
    private boolean nrFLG;

    /** メールアドレスor携帯番号 */
    private String post;
    
    /** 連絡先の種類 */
    private String detail;
    
    /** 電話番号 */
    private String phoneID;
    
    /** 持ち出し先等のメモ */
    private String memo;
    
    /** ステータス名 */
    private String status;
    
    /** RGB12桁の色コード */
    private String color;
    
    /** 部屋名 */
    private String roomName;
    
    /** 部屋の横幅 */
    private int width;
    
    /** 部屋の縦幅 */
    private int height;
    
    /** メッセージのID */
    private int bulletinID;
    
    /** メッセージの内容 */
    private String bulletin;
    
    /** メッセージID */
    private int messageID;

    
    

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isViewIP() {
		return viewIP;
	}

	public void setViewIP(boolean viewIP) {
		this.viewIP = viewIP;
	}

	public boolean isViewID() {
		return viewID;
	}

	public void setViewID(boolean viewID) {
		this.viewID = viewID;
	}

	public int getLocalPhoneNumber() {
		return localPhoneNumber;
	}

	public void setLocalPhoneNumber(int localPhoneNumber) {
		this.localPhoneNumber = localPhoneNumber;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public Date getLasuUpdate() {
		return lasuUpdate;
	}

	public void setLasuUpdate(Date lasuUpdate) {
		this.lasuUpdate = lasuUpdate;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getLeftX() {
		return leftX;
	}

	public void setLeftX(int leftX) {
		this.leftX = leftX;
	}

	public int getLeftY() {
		return leftY;
	}

	public void setLeftY(int leftY) {
		this.leftY = leftY;
	}

	public int getRightX() {
		return rightX;
	}

	public void setRightX(int rightX) {
		this.rightX = rightX;
	}

	public int getRightY() {
		return rightY;
	}

	public void setRightY(int rightY) {
		this.rightY = rightY;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public boolean isNeFLG() {
		return neFLG;
	}

	public void setNeFLG(boolean neFLG) {
		this.neFLG = neFLG;
	}

	public boolean isNrFLG() {
		return nrFLG;
	}

	public void setNrFLG(boolean nrFLG) {
		this.nrFLG = nrFLG;
	}
	
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBulletinID() {
		return bulletinID;
	}

	public void setBulletinID(int bulletinID) {
		this.bulletinID = bulletinID;
	}

	public String getBulletin() {
		return bulletin;
	}

	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

}
