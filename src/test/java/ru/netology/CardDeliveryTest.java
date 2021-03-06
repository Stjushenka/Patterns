package ru.netology;


import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {



    @BeforeEach
    void shouldOpenWebApp() {
        open("http://localhost:9999");
    }



    @Test
    void shouldTestValidation() {


        String meetingDay = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            $("[data-test-id=city] input").setValue(RegistrationInfo.serviceCity());
            $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            $("[data-test-id=date] input").doubleClick().val(meetingDay);
            $("[data-test-id=name] input").setValue(RegistrationInfo.serviceName());
            $("[data-test-id=phone] input").setValue(RegistrationInfo.servicePhone());
            $(".checkbox__box").click();
            $(".button").click();
            $(withText("Успешно!"));
            $(withText("Встреча успешно забронирована на" + meetingDay));

            $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            $("[data-test-id=date] input").doubleClick().val(meetingDay+3);
            $(".button").click();
            $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?"));
            $("div.notification__content button").click();
            $(withText("Успешно!"));
            $(withText("Встреча успешно забронирована на" + meetingDay+3));

    }



}