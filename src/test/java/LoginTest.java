import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends BaseTest {

    @Test
    public void login() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible, Duration.ofSeconds(60));
    }

    @Test
    public void login2() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldNotBe(visible);

    }

    @Test(description = "Создаем аккаунт и проверяем ввод данных")
    public void createAccount() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);

        $(By.xpath("//*[@class='btn btn-primary']")).click();
        $(By.xpath("//input[@name='title']")).setValue("A");
       // $(By.xpath("//input[@name='code']")).setValue(" ");
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//div[@class='form-control-feedback']")).shouldBe(visible);
    }

    @Test(description = "Создаем аккаунт и проверяем ввод данных")
    public void createAccount2() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);

        $(By.xpath("//*[@class='btn btn-primary']")).click();
        $(By.xpath("//input[@name='title']")).setValue("Project");
        $(By.xpath("//button[@type='submit']")).click();
        $(By.xpath("//span[@class='style_statistic-SjRZY']")).shouldBe(visible);

    }

   /* @Test(description = "Создаем аккаунт и Case")
    public void createAccountAndCase() {
        open("/login");
        $("#inputEmail").sendKeys(email);
        $(By.xpath("//*[@id='inputPassword']")).setValue(password).submit();
        $(By.id("createButton")).shouldBe(visible);

        $(By.xpath("//*[@class='btn btn-primary']")).click();
        $(By.xpath("//input[@name='title']")).setValue("Project");
        $(By.xpath("//button[@type='submit']")).click();
       // $(By.xpath("//div[@class='form-control-feedback']")).shouldBe(visible);

        $(By.xpath("//h1[@class='style_title-319J6']"))
                .shouldHave(text("Case"))
                .click();
       }*/
}
