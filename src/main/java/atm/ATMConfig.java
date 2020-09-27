package atm;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

@Configuration
public class ATMConfig {
    @Bean
    public DataSourceFile dataSource() {
        return new DataSourceFile("customers.txt");
    }

    @Bean
    public Bank bank() {
        return new Bank("My Bank", dataSource());
    }

    @Bean
    public ATM atm() {
        return new ATM(bank());
    }

    @Bean
    public AtmUI atmUI() {
        return new AtmUI(atm());
    }
}