package cc.innosoft.thirdchat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 短信接口
 * 短信服务商是短信宝
 * @author jp
 *
 */
public class SmsUtil {
	private static String username = "nyh137";  //短信宝用户账号
	private static String password = "123456";	//短信宝用户密码
	private static String sign = "【奇石科技】";  //短信签名
	private static String httpUrl = "http://api.smsbao.com/sms";
	
	/**
	 * 短信发送
	 * @param mobile 手机号码
	 * @param content 短信内容
	 * @param type 类别  11验证码
	 * @return
	 * 0 发送成功
	 * 30 错误莫玛
	 * 40 账号不存在
	 * 41 余额不足
	 * 43 IP地址限制
	 * 50 内容含有敏感词
	 * 51 手机号码不正确
	 */
	public static Integer sendSms(String mobile, String content, Integer type){
		Integer result = -1;
		switch (type) {
		case 11:  //发送验证码
			content = "亲，您好，您申请的验证码为："+content+"。如非本人操作，请忽略。";
			result = sendSms(mobile, content);
			break;

		default:
			break;
		}
		return result;
	}
	
	/**
	 * 短信发送
	 * @param mobile  手机号码
	 * @param content 短信内容
	 * @return
	 * 0 发送成功
	 * 30 错误莫玛
	 * 40 账号不存在
	 * 41 余额不足
	 * 43 IP地址限制
	 * 50 内容含有敏感词
	 * 51 手机号码不正确
	 */
	public static Integer sendSms(String mobile, String content){
		StringBuffer httpArg = new StringBuffer();
		httpArg.append("u=").append(username).append("&");
        httpArg.append("p=").append(md5(password)).append("&");
        httpArg.append("m=").append(mobile).append("&");
        httpArg.append("c=").append(encodeUrlString(content, "UTF-8"));
    	httpArg.append(encodeUrlString(sign, "UTF-8"));
        String result = request(httpUrl, httpArg.toString());
        return Integer.valueOf(result);
	}
	
	public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;
 
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	public static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
	
	public static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null)
            return str;
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }
}
