package tech.java.generic;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UrlEncodeImpl {

  public static void main(String[] args) {
    encodeUrl("http://exampl1e.com:8080/li2vecluster/rest/eng2ine/log-2url-list");
  }

  private static void encodeUrl(String url) {

    // URL encode the string
    String encodedString = URLEncoder.encode(url, StandardCharsets.UTF_8);

    String hashedStr = getHash(url, "SHA-256");

    System.out.println("Encoded URL: " + encodedString);
    System.out.println("Hashed URL: " + hashedStr);

  }

  public static String getHash(String input, String algorithm) {
    try {
      MessageDigest digest = MessageDigest.getInstance(algorithm);
      byte[] hashBytes = digest.digest(input.getBytes());

      StringBuilder hexString = new StringBuilder();
      for (byte b : hashBytes) {
        hexString.append(String.format("%02x", b));
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error hashing input", e);
    }
  }
}
