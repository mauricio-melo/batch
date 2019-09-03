package com.mm.batch.processor;

import com.mm.batch.domain.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(final Person person) throws Exception {
        return Person.builder()
                .name(person.getName().toUpperCase())
                .lastName(person.getLastName().toUpperCase())
                .build();
    }
}
