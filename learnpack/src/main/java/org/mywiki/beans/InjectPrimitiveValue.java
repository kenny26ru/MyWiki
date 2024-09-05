package org.mywiki.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:values/collection.properties")
public class InjectPrimitiveValue {

    @Value("${organisation.email:e@mail.ru}")
    private String email;

    @Value("${organisation.number}")
    private int number;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
