package app;

import app.model.*;
import app.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {







    }







    private void test_1() {
        List<Book> bookList = new ArrayList<>();

        List<Employee> employeeList
                = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
                new Employee("Harry Andrews", 45, 7000.00),
                new Employee("Ethan Hardy", 65, 8000.00),
                new Employee("Nancy Smith", 22, 10000.00),
                new Employee("Deborah Sprightly", 29, 9000.00));


        bookList.add(new Book("Game Of Throne tom.1","e212121",623));
        bookList.add(new Book("W pustyni i w puszczy","d213421",240));
        bookList.add(new Book("Pan Tadeusz","d1212d1",310));
        bookList.add(new Book("Hari Pota","veb5ee54",410));
        bookList.add(new Book("10 Steps To Milion Dollar","dg34343",110));
        bookList.add(new Book("Strange cas of mY Mother","ac311aca",96));
        bookList.add(new Book("Pope Life","pcp9ap9",1200));

        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8, 9 ,10 ,11 ,12);
        List<String> strList = Arrays.asList("okA","aa","fA","fa","fAW","AAa","f");

        //TESTY
        Book book = bookList.stream().max(Comparator.comparing(book1 -> book1.getPageAmount())).get();

        bookList.stream().forEach(book1 -> { book.setPageAmount(book.getPageAmount()+100); });
        bookList.forEach(book1 -> System.out.println(book1.getPageAmount()));

        boolean isAnyEven= intList.stream().anyMatch(integer -> integer % 2 ==0);
        boolean areAllEven= intList.stream().allMatch(integer -> integer % 2 ==0);

        String a=strList.stream().reduce("Start -> ",(s, s2) -> s + s2.toUpperCase());

        String titles = bookList.stream().map(Book::getName).collect(Collectors.joining(" - "));

        DoubleSummaryStatistics statistics = bookList.stream().collect(Collectors.summarizingDouble(value -> value.getPageAmount()));

        Map<Boolean,List<Book>> bigBooksOrNot = bookList.stream().collect(Collectors.partitioningBy((Book o) -> o.getPageAmount() > 350 ));

        Map<String,Integer> nameAndPageAmount = bookList.stream().collect(Collectors.toMap(Book::getName,Book::getPageAmount));

        Map<Character,List<String>> groupAlphabetical = bookList.stream()
                .collect(Collectors.groupingBy(o -> o.getName().charAt(0),Collectors.mapping(Book::getName,Collectors.toList())));
        System.out.println(groupAlphabetical);

        Map<String,Integer> test2 = bookList.stream()
                .collect(Collectors.groupingBy( (Book o) -> o.getName(), Collectors.summingInt(Book::getPageAmount)));

        List<String> employeeNames = employeeList
                .stream()
                .collect(Collectors.mapping(Employee::getName, Collectors.toList()));
        //System.out.println(employeeNames);
    }
}
