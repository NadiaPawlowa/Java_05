import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NadiaPawlowaTest {
    //   TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"


    @Test
    // всегда название начинается с public void testЧГК
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
       // следующие 2 строчки надо в каждом тесте вставлять
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nadez\\Documents\\Веб-программирование\\Java\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // arrange
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        //act
        driver.get(url); //идем по указанному адресу
        Thread.sleep(5000); //задержка после открытия

        // //div[@id = 'weather-widget']/div/div/div//div/div/input ищем элемент
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click(); // кликаем, заходим в поле
        searchCityField.sendKeys(cityName); // вводим Paris

        Thread.sleep(5000); //задержка после открытия


        WebElement searchButton = driver.findElement( // ищем кнопку "поиск"
                By.xpath("//div[@id = 'weather-widget']//button[@type='submit']")
        );
        searchButton.click(); // кликаем по кнопке поиска

        Thread.sleep(1000); //ждем открытия дропдаун меню

        WebElement parisFRChoiceDropdownMenu = driver.findElement( // ищем в выпадающем меню нужный город
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceDropdownMenu.click(); // кликаем

        WebElement h2CityCountryHeader = driver.findElement( // ищем заголовок
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(3000); // ждем обновления заголовка

        String actualResult = h2CityCountryHeader.getText(); // получаем текст заголовка методом get.Text()


        // assert
        Assert.assertEquals(actualResult, expectedResult); // сравниваем полученный и ожидаемый результаты

        driver.quit(); // ОБЯЗАТЕЛЬНО закрываем старницу
        // driver.close();

    }





//    @Test С ЧЕГО НАЧИНАЕТСЯ КАЖДЫЙ ТЕСТ - ШАБЛОН
//    // всегда название начинается с public void testЧГК
//    public void testH2TagText_WhenSearchingCityCountry() {
//        // следующие 2 строчки надо в каждом тесте вставлять
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nadez\\Documents\\Веб-программирование\\Java\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

//   * * * * * *

//        driver.quit(); // ОБЯЗАТЕЛЬНО


  //  }
}
