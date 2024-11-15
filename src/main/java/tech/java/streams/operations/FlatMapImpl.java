package tech.java.streams.operations;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapImpl {

  public static void main(String[] args) {

    var stringList = Arrays.asList("abc", "bca", "cab");
    //java. util. List<Character>
    var allStr1 = stringList.stream()
        .flatMap(s -> s.chars().mapToObj(c -> (char) c)).toList();

    //java. util. List<String>
    //allStr1.stream().map(String::valueOf).forEach(System.out::println);

    //stringList.stream().flatMap(s -> Stream.of(s.charAt(1))).forEach(System.out::println);

    //allStr1.forEach(System.out::println);


    /* filter out empty results */
    var optionalStr = List.of(
        Optional.of("abc"),
        Optional.of("bca"),
        Optional.empty(),
        Optional.of("cbd"));

    optionalStr.stream().flatMap(Optional::stream).forEach(System.out::println);


    /* get associated list details*/

    var cryptoUserList = Arrays.asList(
        new CryptoUser(1, List.of("BTC", "USDT", "DOGGE")),
        new CryptoUser(1, List.of("ETH", "USDC", "SOLANA")),
        new CryptoUser(1, List.of("LTC", "ETH", "SIBB", "BTC"))
    );

    var allCrypto = cryptoUserList.stream().flatMap(user -> user.cryptoHoldings().stream())
        .collect(Collectors.toSet());

    var allCryptoInserted = cryptoUserList.stream().flatMap(user -> user.cryptoHoldings().stream())
        .collect(Collectors.toCollection(LinkedHashSet::new));

    System.out.println(allCryptoInserted);
  }

}
