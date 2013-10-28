/**
 *
 */
package todo.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.SentDateTerm;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;

/**
 * @author A-pZ
 *
 */
public class SimpleMailSender {
	private static Logger log = Logger.getLogger(SimpleMailSender.class);

	/** アカウント接続時にSSLを利用する場合に利用する */
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	/** SMTPサーバ接続ポート：25番を指定 */
	//sprivate final String SMTP_PORT = "25";
	private final String SMTP_PORT = "465"; // SSLは465がよく使われる(正式な番号ではない)

	/** メールアカウント */
	private String AUTH_USER_NAME = "";

	/** メールアカウントのパスワード */
	private final String AUTH_PASSWORD = "";

	/** SMTPメールホスト */
	private static final String smtpHost = "smtp.gmail.com";

	//to送信先のメールアドレス、名前list
	private List<InternetAddress> list = new ArrayList<InternetAddress>();
	//cc送信先のメールアドレス、名前list
	private List<InternetAddress> list2 = new ArrayList<InternetAddress>();


	public static void main(String argv[]) throws Exception {
		SimpleMailSender mail = new SimpleMailSender();
	}

	/**
	 * メールを送信する
	 * @param fromName 送信先メールアドレス。
	 * @param toAddr 送信元メールアドレス。
	 * @param personName 送信者名
	 * @param subject メールの件名
	 * @param message メール本文
	 * @throws Exception
	 */
	public void sendMessage(String fromName, List<InternetAddress> list, List<InternetAddress> list2, String toAddr, String personName,String subject, String message) throws Exception {

		//フィールドlistに代入
		this.list = list;
		//フィールドlist2に代入
		this.list2 = list2;


		//メールアカウントは実装時DBに入ってる
		//自分のメールアドレスをフィールドアカウントに代入
		//	AUTH_USER_NAME = toAddr;

		// メール送信プロパティの作成
			Properties props = new Properties();
			props.put("mail.smtp.host", smtpHost); // SMTPサーバ名
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.host", smtpHost);
			props.put("mail.from", toAddr);
			// SMTP認証設定
			props.put("mail.smtp.auth", "true");

			// SMTPソケットポート(SSL用)
			props.put( "mail.smtp.socketFactory.port", SMTP_PORT );

			// ソケットクラス名
			// SSLを利用するSMTPサーバはSSL用のソケットファクトリーを利用する
			props.put( "mail.smtp.socketFactory.class", SSL_FACTORY );

			// SSLフォールバック(SSL用)
			props.put( "mail.smtp.socketFactory.fallback", String.valueOf( false ) );

			// メールセッションを確立する
			// セッション確立設定はpropsに格納される。
			Session session = Session.getDefaultInstance(props,new Authenticator(){
	            protected PasswordAuthentication getPasswordAuthentication(){
	                return ( new PasswordAuthentication( AUTH_USER_NAME, AUTH_PASSWORD ) );
	            }
	        });
			session.setDebug(true);


			// 送信メッセージを生成
			MimeMessage mimeMsg = new MimeMessage(session);

			//to送信先のAddresslistを配列に代入
			InternetAddress[] add = new InternetAddress[list.size()];
			int y = 0;
			for(InternetAddress addre: list){
					add[y] = addre;
					y++;
			}


			//cc送信先のAddresslistを配列に代入
			int i = 0;
			int l =  list2.size();
			int s = 0;



			for(int j = 0; j < l;j++){
				if(list2.get(s).getAddress() == null){
					list2.remove(s);
					s--;
				}
				s++;
			}

			InternetAddress[] add2 = new InternetAddress[list2.size()];

			for(InternetAddress addre: list2){
				if(addre.getAddress() != null){
					add2[i] = addre;
					i++;
				}
			}


			// 送信先 TO
			mimeMsg.setRecipients(Message.RecipientType.TO, add);
			// 送信先 CC
			mimeMsg.setRecipients(Message.RecipientType.CC,add2);
			// Fromヘッダ
			InternetAddress fromHeader = new InternetAddress(AUTH_USER_NAME, personName);
			mimeMsg.setFrom(fromHeader);
			// 件名
			mimeMsg.setSubject(subject, "UTF-8");
			// 送信時間
			mimeMsg.setSentDate(new Date());
			// 本文
			try{
				mimeMsg.setText(message, "UTF-8");

			}catch (Exception e) {
				System.out.println("エラーです");
			}

			// メールを送信する
			Transport.send(mimeMsg);

			log.debug("complete.");
	}
}
