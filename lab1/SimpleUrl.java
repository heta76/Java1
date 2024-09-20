package org.knit.lab1;

import java.util.Arrays;

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
    private  String address;
    private  String domainZone;
    private String  siteName;
    private String  webpageName;
    private String webPageExtention;
    public void execute() {
        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        String[] host = urlValue.split("://");
        protocol = host[0];
        address = host[1].split("/")[0];
//        System.out.println(protocol);
//        System.out.println(address);
        /* tips
         * urlValue.split(":");
         */

        //todo create class SimpleUrl()
        // SimpleUrl url= new SimpleUrl();
        // url.setAddress(address);
        // url.setProtocol(protocol)
        // System.out.println(url);
    }
    public String toString() {
        System.out.println(protocol);
        return protocol;
//        return "protocol ="+this.protocol+'\n'+"address ="+this.address;
    }
}
