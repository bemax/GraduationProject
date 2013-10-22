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

}
