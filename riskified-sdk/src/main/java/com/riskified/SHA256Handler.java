package com.riskified;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA256Handler {

    private Mac mac;

    public SHA256Handler(String authKay) throws RiskifiedError {
        mac = createSHA256Key(authKay);
    }

    public String createSHA256(String data) throws IllegalStateException, UnsupportedEncodingException {
        final byte[] hmac = mac.doFinal(data.getBytes("UTF-8"));
        return toHexString(hmac);
    }

    public Boolean isHmacCorrect(String data, String hmac) throws IllegalStateException, UnsupportedEncodingException {
        String calcHash = createSHA256(data);
        return hmac.equals(calcHash);
    }

    private Mac createSHA256Key(String authKey) throws RiskifiedError {
        Key sk = new SecretKeySpec(authKey.getBytes(), "HmacSHA256");

        try {
            mac = Mac.getInstance(sk.getAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            throw new RiskifiedError(e);
        }
        try {
            mac.init(sk);
        } catch (InvalidKeyException e) {
            throw new RiskifiedError(e);
        }
        return mac;
    }

    private String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);

        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        formatter.close();

        return sb.toString();
    }
}
