package tech.java.streams.operations;

import java.util.List;
import java.util.stream.Collectors;

public class PartitioningByExpl {

  public static void main(String[] args) {
    var listOfCrypto = List.of("USDC", "SOL", "ETH", "BTC", "DOGE", "SBIH", "LTC", "YTR", "BYG",
        "EGT", "BTC");

    var results = listOfCrypto.stream()
        .collect(Collectors.partitioningBy(crypto -> crypto.length() > 3));

    System.out.println(results);
  }
}
