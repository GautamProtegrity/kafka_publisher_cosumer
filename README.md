# Kafka_Publisher_Consumer_Example
Solution  to a use case related to market risk

Part-1

We should have Market Data   bean with {ric , price, lastUpdatedTime }
Possible (Stock) RIC List (“A.HK” to “Z.HK”)
MarketDataPublisher – publish random price within valid range (< 100) for the RIC set from above at frequency of 10 ms. 
All registered client with MarketData Publisher should get latest published prices for the RICS.


Part-2

You may need to design middle layer receiver who registered with MarketDataPublisher and start receiving Published prices and cache it. (need to use justified data structure for caching)
Expose an API (interface) for following operation
Set<Rics,Price> getPrices()  -- should return latest published prices for all RICs.

//Sample Response
[
{
		ricCode: "A.HK",
		lastPrice: 74.15,
		lastUpdatedTime: 21-09-2022
},......Z.HK

]

List<long, Price> getPrices(RIC) -- should return set of Mill – Price for last 3 price for given RIC.

// Sample Response
{
ricCode: "B.HK",
lastThreePrices: [74.41,56.13,78.10]
}

# Pre-Requisites:

1. Need Java version 8 installed.
2. Need Maven latest installed.
3. Need to install and run kafka, create a topic "marketdata" before starting the application.
4. First run the producer application.
3. Then start the consumer application.

# Important Links:

## Accessing Consumer side API
http://localhost:8080/fetch/{ricCode}

## How to install Java 8 on windows
https://www.guru99.com/install-java.html

## How to install Maven on Windows
https://devwithus.com/install-maven-windows/#:~:text=How%20to%20Install%20Maven%20on%20Windows%2010%201,...%207%20Common%20Issues%20...%208%20Conclusion%20

## How to install kafka on windows
https://www.geeksforgeeks.org/how-to-install-and-run-apache-kafka-on-windows/
