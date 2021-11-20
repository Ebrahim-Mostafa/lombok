# Selenium_Ebrahim_SDET_Walkthrough


## `Prerequisites:`

Download and install [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).<br />

Download and install [Apache Maven](https://maven.apache.org/download.cgi).<br />

============================<br />

## `Run Configuration:`

> Run from testng.xml, it support Chrome, Firefox and Edge browsers.

> To run different browser just change the value of parameter name="Browser" in testng.xml file 

 Browser name: "Chrome" --> value="Chrome" , Browser name: Firefox --> value="Firefox",  Browser name: Edge --> value="Edge"


============================<br />

## `Install Allure to generate reports:`

Open your windows PowerShell:<br />

One of the easiest ways to start PowerShell in Windows is using the Run window. Press Win + R keys on your keyboard, then type PowerShell and press Enter or click OK.<br />

Run these Commands:<br />

> Set-ExecutionPolicy RemoteSigned -scope CurrentUser <br />

> iex (new-object net.webclient).downloadstring('https://get.scoop.sh') <br />

In the above case, it was already installed, so you a message as 'Scoop is already installed'. You can run 'scoop update' to get the latest version any time, To install Allure, using Scoop, run the below command:<br />

> scoop install allure <br />