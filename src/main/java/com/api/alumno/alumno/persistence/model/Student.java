package com.api.alumno.alumno.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("students")
public class Student implements Persistable<Long> {

    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    private int flgdel = 0;

    @Transient
    private boolean isNewEntry = true;

    public Student(Long id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public boolean isNew() {
        return isNewEntry;
    }
}
