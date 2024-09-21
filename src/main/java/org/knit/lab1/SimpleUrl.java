package org.knit.lab1;

import java.util.HashMap;

/***
 * Задача 2
 * Создайте класс SimpleUrl
 * глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:
 * https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText
 * добавьте геттеры и сеттеры для полей
 * Переопределите метод toString() для вывода информации о полях класса:
 * protocol = https
 * address = test.ru
 * domainZone = ru
 * siteName = test
 * webpageName = page.jsp
 * webPageExtention = jsp
 * ....
 * Распарсите данный URL на переменные, создайте экземпляр класса SimpleUrl и выведите на экран
 * Дополнительно
 * попробуйте с другими URL в сети, подумайте как можно сгруппировать значения.
 *
 */
public class SimpleUrl {
    private String protocol;
    private String address;
    private String domainZone;
    private String siteName;

    private String webpageName;
    private String webPageExtention;
    HashMap<String, String> variables = new HashMap<String, String>();

    public void execute() {

        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
//        String urlValue = "https://javarush.com/quests/lectures/questsyntaxpro.level13.lecture03";
        String right = urlValue.split("\\?")[1];
        String left = urlValue.split("\\?")[0];
        String host = left.split("://")[0];
        String[] parts = right.split("&");
        protocol = host;
        for (int i = 0; i < parts.length; i++) {
            variables.put(parts[i].split("=")[0], parts[i].split("=")[1]);
        }
        for (String key : variables.keySet()) {
            String value = variables.get(key);
            System.out.println(key + " = " + value);
        }
//        address = host[1].split("/")[0];
//        domainZone = urlValue.split("\\.")[1].split("/")[0];
//        siteName = host[1].split("\\.")[0];
//        webpageName = host[1].split("/")[3].split("\\?")[0];
//        webPageExtention = host[1].split("/")[3].split("\\?")[0].split("\\.")[1];
    }

    public String toString() {
        return "protocol = " + this.protocol + '\n' + "address = " + address + '\n' + "domainZone = " + domainZone//
                + '\n' + "siteName = " + siteName + '\n' + "webpageName = " + webpageName + //
                '\n' + "webPageExtention = " + webPageExtention;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebpageName() {
        return webpageName;
    }

    public void setWebpageName(String webpageName) {
        this.webpageName = webpageName;
    }

    public String getWebPageExtension() {
        return webPageExtention;
    }

    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtention = webPageExtension;
    }
}
