package tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

import app.model.Address;
import app.model.MobileNumber;
import app.model.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MyTests {

    Student student1 = new Student(
            "Jayesh",
            24,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

    Student student2 = new Student(
            "Khyati",
            13,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

    Student student3 = new Student(
            "Jason",
            30,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

    List<Student> studentList = Arrays.asList(student1, student2, student3);

    @Test
    void getStudentWithSpecificName() {

        Student student = studentList.stream().filter(st -> st.getName().equals("Jayesh")).findFirst().get();

        System.out.println(student);

        assertThat(student.getName(),is("Jayesh"));

    }

    @Test
    void getstudentWithMachingAddress() {
       Student student = studentList.stream().filter(st -> st.getAddress().getZipcode().contains("1235")).findFirst().get();

        System.out.println(student);

        assertThat(student.getAddress().getZipcode(),is("1235"));
    }

    @Test
    void studentsWithNumber3333()
    {
        List<Student> studentWithMatchingnumber = studentList.stream()
                .filter(student -> student.getMobileNumbers()
                        .stream()
                        .anyMatch(mobileNumber -> mobileNumber.getNumber().equals("3333")))
                .collect(Collectors.toList());

        studentWithMatchingnumber.forEach(System.out::println);

        assertAll(
                () -> assertThat(studentWithMatchingnumber,hasSize(2)),
                () -> assertThat(studentWithMatchingnumber.get(1).getName(),is("Jason")));

    }

    @Test
    void studentWithNumber1233and1234() {
        List<Student> studnetsWith1233or1234Number = studentList.stream()
                .filter(student -> student.getMobileNumbers()
                        .stream()
                        .allMatch(mobileNumber -> mobileNumber.getNumber().equals("1233") || mobileNumber.getNumber().equals("1234")))
                .collect(Collectors.toList());

        studnetsWith1233or1234Number.forEach(System.out::println);

        assertAll(
                () -> assertThat(studnetsWith1233or1234Number,hasSize(1)),
                () -> assertThat(studnetsWith1233or1234Number.get(0).getName(),is("Jayesh")));

    }

    @Test
    void createListOfStudentsName() {
        List<String> nameList = studentList.stream().map(Student::getName).collect(Collectors.toList());

        System.out.println(nameList);

        assertThat(nameList,hasSize(3));
    }

    @Test
    void convertListOfNameToString() {

        List<String> nameList = studentList.stream().map(Student::getName).collect(Collectors.toList());
        String allNames = nameList.stream().collect(Collectors.joining(" - ","First -> " , " <- Last"));

        System.out.println(allNames);

    }

    @Test
    void toUpperCase() {
        List<String> names =
                Arrays.asList("Damian","Szymon","Agnieszka","Paulina");

        names=names.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(names);

    }

    @Test
    void sortNameLenght() {
        List<String> namesList =
                Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");

        namesList = namesList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(namesList);

    }

    @Test
    void divideStudnetsIntoAdultAndNot() {

       Map<Boolean,List<Student>> divided =  studentList.stream().collect(Collectors.partitioningBy(o -> o.getAge()>18));


        assertAll(
                () -> assertThat(divided.get(true),hasSize(2)),
                () -> assertThat(divided.get(false),hasSize(1)));

    }










}
