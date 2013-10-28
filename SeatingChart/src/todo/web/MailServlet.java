package todo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.util.SimpleMailSender;

/**
 * 登録処理を行う。
 */
@WebServlet("/mail")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//TO送信先アドレス情報
	List<InternetAddress> list = new ArrayList<InternetAddress>();

	//CC送信先アドレス情報
	List<InternetAddress> list2 = new ArrayList<InternetAddress>();
	request.setCharacterEncoding("UTF-8");

	//送信元の名前
	String fromName = (String)request.getParameter("fromName");

	//送信先のメールアドレス
	String toAddr = (String)request.getParameter("toAddr");

	//送信元の名前を文字化けしないように
	String personName = new String (request.getParameter("fromName").getBytes("ISO-8859-1"));

	//to送信先の名前
	String nametoAddr = "大橋";

	//to送信先のメールアドレス,名前を代入
	list.add(new InternetAddress(toAddr, nametoAddr));

	//cc送信先の名前
	String[] name = {"竹内", "船岳"};

	for(int i = 0; name.length > i; i++){
		list2.add(new InternetAddress(request.getParameter("a" + i), name[i]));
	}

	//タイトルを取得
	String subject = new String (request.getParameter("subject").getBytes("ISO-8859-1"));

	//内容を取得
	String message = new String (request.getParameter("message").getBytes("ISO-8859-1"));

	// 完了時にメールを送信する
	SimpleMailSender mail = new SimpleMailSender();
	try {
		mail.sendMessage(fromName, list, list2, toAddr, personName, subject, message);
	} catch (Exception e) {
		e.printStackTrace();
	}
	RequestDispatcher rd = request.getRequestDispatcher("/search");
	rd.forward(request, response);
}}