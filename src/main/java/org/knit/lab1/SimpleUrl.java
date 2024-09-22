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
    private String webPageExtension;
    HashMap<String, String> variables = new HashMap<String, String>();

    public void execute() {
        String right = "";
        String[] parts;
        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
//        String urlValue = "https://yandex.ru/search/?text=java+boolean&lr=194&clid=2456107&src=suggest_B";
        String left = urlValue.split("\\?")[0];
        if (urlValue.split("\\?").length > 1) {
            right = urlValue.split("\\?")[1];
            parts = right.split("&");
            for (int i = 0; i < parts.length; i++) {
                variables.put(parts[i].split("=")[0], parts[i].split("=")[1]);
            }
        }
        protocol = left.split("://")[0];
        address = left.split("://")[1].split("/")[0];
        siteName = address.substring(0, address.lastIndexOf("."));
        domainZone = address.substring(address.lastIndexOf(".") + 1);
        webpageName = left.split("/")[left.split("/").length - 1];
        if (webpageName.split("\\.").length > 1) {
            webPageExtension = webpageName.split("\\.")[webpageName.split("\\.").length - 1];
        } else webPageExtension = "N/A";
    }

    public void listContent() {
        for (String key : variables.keySet()) {
            String value = variables.get(key);
            System.out.println(key + " = " + value);
        }
    }

    public String toString() {
        return "protocol = " + protocol + '\n' + "address = " + address + '\n' + "domainZone = " + domainZone//
                + '\n' + "siteName = " + siteName + '\n' + "webpageName = " + webpageName + //
                '\n' + "webPageExtention = " + webPageExtension;
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
        return webPageExtension;
    }

    public void setWebPageExtension(String webPageExtension) {
        this.webPageExtension = webPageExtension;
    }
}
