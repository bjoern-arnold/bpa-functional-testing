# Getting Started

## Prerequisites

* Maven 3.6+
* Java 11+

## Test execution

* Open a command prompt
* Change to this directory
* Enter the following command

        mvn clean verify

If you are behind a corporate proxy add the following arguments (adjust to your proxy settings):

        mvn -Dhttps.proxyHost=localhost -Dhttps.proxyPort=3128 -Dhttp.proxyHost=localhost -Dhttp.proxyPort=3128 clean verify

## View test resuls

* The report with the results is generated in the sub folder

        ./target/site/serenity
* Open the file _index.html_ in a browser to access it
