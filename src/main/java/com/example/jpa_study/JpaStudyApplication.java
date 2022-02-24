package com.example.jpa_study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaStudyApplication {

    private static final Logger log = LoggerFactory.getLogger(JpaStudyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(CustomerRepository repository){
        return (args -> {

            // 손님 데이터 저장
            repository.save(new Customer("Soobin", "Son"));
            repository.save(new Customer("Hyunsik", "Eom"));
            repository.save(new Customer("Inwook", "Jeong"));
            repository.save(new Customer("Jimin", "Kim"));
            repository.save(new Customer("Hwijeong", "Lee"));

            // 모든 손님 가져오기
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()){
                log.info(customer.toString());
            }
            log.info("");

            // ID 값을 기준으로 각각의 손님 가져오기
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("---------------------------------");
            log.info(customer.toString());
            log.info("");

            // LastName 을 기준으로 손님 가져오기
            log.info("Customer found with findByLastName('Son'):");
            log.info("------------------------------------------");
            repository.findByLastName("Son").forEach(Son -> {
                log.info(Son.toString());
            });
            log.info("");
        });
    }

}
