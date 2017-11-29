package util;

import java.security.MessageDigest;

public class Encrypt {
	  public final static String MD5(String s) {
	    char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	    try {
	      MessageDigest mdInst = MessageDigest.getInstance("MD5"); // ���MD5ժҪ�㷨��MessageDigest����
	      mdInst.update(s.getBytes());// ʹ��ָ�����ֽڸ���ժҪ
	      byte[] md = mdInst.digest();// �������
	      int k = 0, j = md.length; // ������ת����ʮ�����Ƶ��ַ�����ʽ
	      char str[] = new char[j * 2];
	      for (int i = 0; i < j; i++) {
	        byte byte0 = md[i];
	        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	        str[k++] = hexDigits[byte0 & 0xf];
	      }
	      return new String(str);
	    } catch (Exception e) {
	      e.printStackTrace();
	      return "";
	    }
	  }
	  public final static String SHA(String s) {
	    MessageDigest sha = null;
	    StringBuffer hexValue = null;
	    try {
	      sha = MessageDigest.getInstance("SHA");
	      byte[] md5Bytes = sha.digest(s.getBytes("UTF-8"));
	      hexValue = new StringBuffer();
	      for (int i = 0; i < md5Bytes.length; i++) {
	        int val = ((int) md5Bytes[i]) & 0xff;
	        if (val < 16) {
	          hexValue.append("0");
	        }
	        hexValue.append(Integer.toHexString(val));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	      return "";
	    }
	    return hexValue.toString();
	  }
}
