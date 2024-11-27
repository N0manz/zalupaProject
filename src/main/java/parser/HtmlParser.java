package parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
    public static void main(String[] args) {
        String url = "https://www.google.com/"; // Замените на нужный URL

        try {
            // Загружаем HTML с веб-страницы
            Document doc = Jsoup.connect(url).get();

            // Пример: Получаем заголовок страницы
            String title = doc.title();
            System.out.println("Title: " + title);

            // Пример: Извлекаем все ссылки
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                System.out.println("Link: " + link.attr("href") + " Text: " + link.text());
            }

            // Пример: Получаем элементы с определенным классом
            Elements elements = doc.select(".some-class");
            for (Element element : elements) {
                System.out.println("Element text: " + element.text());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

