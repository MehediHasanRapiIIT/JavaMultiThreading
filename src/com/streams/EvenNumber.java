package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,3,4,5,6,7,8,9,10);
        List<Integer> list1 = Arrays.asList(10,3,4,5,1,7,2,9,6);

        List<String> list2 = Arrays.asList("Mehedi","Hasan","Rafi","Mahfuz");
        List<String> list3 = Arrays.asList("a", null, "b", null, "c");

        list.stream().filter(x->x%2==0).forEach(System.out::println);

        List<String> upper =  list2.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upper);

        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        int max = list.stream().reduce(Integer::max).orElseThrow();
        System.out.println(max);

        int min = list.stream().reduce(Integer::min).orElseThrow();
        System.out.println(min);

        long count = list2.stream().filter(s->s.startsWith("M")).count();
        System.out.println(count);

        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);

        List<Integer> asc = list1.stream().sorted().collect(Collectors.toList());
        System.out.println(asc);
        List<Integer> desc = list1.stream().sorted((a,b)->(b-a)).collect(Collectors.toList());
        System.out.println(desc);

        String first = list2.stream().findFirst().orElseThrow();
        System.out.println(first);

        boolean longer5 = list2.stream().noneMatch(s -> s.length()>4);
        System.out.println(longer5);

        List<String> nullS = list3.stream().flatMap(s -> s==null? Stream.empty():Stream.of(s)).collect(Collectors.toList());
        System.out.println(nullS);

        List<Integer> square = list.stream().map(x->x*x).distinct().toList();
        System.out.println(square);

        Set<Integer> cube = list.stream().map(x->x*x*x).collect(Collectors.toSet());
        System.out.println(cube);

        String csv = list2.stream().collect(Collectors.joining(","));
        System.out.println(csv);

        double avg = list1.stream().mapToInt(Integer::intValue).average().orElseThrow();
        System.out.println(avg);

        record User(int id, String name) {}

        List<User> users = Arrays.asList(new User(1,"A"), new User(2,"B"), new User(3,"C"));
        List<String> names = users.stream().map(User::name).collect(Collectors.toList());
        System.out.println(names);

        List<Integer> skip =  list1.stream().skip(3).collect(Collectors.toList());
        System.out.println(skip);

        int[] arr = {1,2,3,4,5};
        int sums = Arrays.stream(arr).filter(n->n%2==0).sum();
        System.out.println(sums);

        List<String> longOnes = list2.stream().filter(x->x.length()>=5).collect(Collectors.toList());
        System.out.println(longOnes);

        List<Double> gen = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        System.out.println(gen);

        String s = "Banana";
        List<Character> chars = s.chars().mapToObj(c->(char)c).distinct().collect(Collectors.toList());
        System.out.println(chars);







    }
}
