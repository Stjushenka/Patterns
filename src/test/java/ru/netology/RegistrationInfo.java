package ru.netology;


import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


        public class RegistrationInfo {
            private static Faker faker = new Faker(new Locale("ru"));

            private RegistrationInfo(){};

            public static String serviceDate(int date) {
                return LocalDate.now().plusDays(date).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }

            public static String serviceName (){
                return faker.name().name();
            }

            public static String  serviceCity(){
                return faker.address().cityName();
            }

            public static String servicePhone(){
                return faker.phoneNumber().phoneNumber();
            }

        }