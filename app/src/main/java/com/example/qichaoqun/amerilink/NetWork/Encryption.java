package com.example.qichaoqun.amerilink.NetWork;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


public class Encryption {
	
	public static void main(String[] args) {
		String method = "POST";
		String reqUrl = "https://testopenapi.aichotels-service.com/rate/public/ping";
        String date = GetUtc.getUTCTimeStr();
        System.out.println(date);
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = generateSignature(method,reqUrl,date,secret);
        System.out.println("token的值是多少：：："+token);
	}
	
	public static String generateSignature(String method, String reqUrl, String date, String secret) {
        StringBuilder sign = new StringBuilder();
        sign.append(method);
        sign.append(" ");
        sign.append(reqUrl);
        sign.append("\n");
        sign.append(date);
        byte[] sha1 = hmac_sha1(sign.toString(), secret);
        String signature;
        try {
            signature = new String(Base64.encodeBase64(sha1), "UTF-8");
            return signature;
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static byte[] hmac_sha1(String value, String key) {
        try {
            byte[] keyBytes = key.getBytes();
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return mac.doFinal(value.getBytes());
        } catch (Exception e) {
            return null;
        }
    }
}
