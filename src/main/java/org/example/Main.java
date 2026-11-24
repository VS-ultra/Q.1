package org.example;


import org.example.exception.InvalidAgeException;
import org.example.exception.NegativeNumberException;


import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<101; i++){
            sb.append(i);
            if (i < 100){
                sb.append(",");
            }
        }
        String result = sb.toString();
        System.out.println("Q.2");
        System.out.println(result);

        List<Integer> list_num = new ArrayList<>();
        int n;
        System.out.println("Q.3");
        System.out.println("Enter count of numbers:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i<n; i++){
            int c;
            c = sc.nextInt();
            list_num.add(c);
        }
        List<Integer> uniq = removeDuplicates(list_num);
        System.out.println(uniq);
        System.out.println("--------------");
        System.out.println("Q.4");
        System.out.println(getFindMax(list_num));
        System.out.println("--------------");
        System.out.println("Q.5");
        System.out.println("Can you write your age? :");
        int age;
        try {
            age = sc.nextInt();
            if (age < 0){
                throw new NegativeNumberException(age);
            }
            if (age < 18){
                throw new InvalidAgeException(age);
            }
        }catch (NegativeNumberException | InvalidAgeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("--------------");
        System.out.println("Q.6");
        List<String> list = new ArrayList<>(Arrays.asList(
                "Java",
                "Python",
                "Apple",
                "Go",
                "Banana",
                "apple",
                "Orange",
                "Cat",
                "Spring",
                "Docker",
                "Python",
                "SQL",
                "banana",
                "Kotlin"
        ));
        System.out.println(getStreamOpotunity(list));

    }
    public static List<Integer> removeDuplicates(List<Integer> l) {
        return new ArrayList<>(new LinkedHashSet<>(l));
    }
    public static List<Integer> removeDuplicatesWithFor(List<Integer> l){
        List<Integer> result = new ArrayList<>();
        for(int num:l){
            if(!result.contains(num)){
               result.add(num);
            }
        }
        return  result;
    }
    public static int getFindMax(List<Integer> l){
        int max = Integer.MIN_VALUE;
        for (int num : l){
            if (max < num){
                max = num;
            }
        }
        return max;
    }
    public static List<String> getStreamOpotunity (List<String> list){
        return list.stream()
                .filter(s -> s.length() >= 5)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .collect(Collectors.toList());
    }
    // Q.1 java -Xms256m -Xmx1024m -Xss1m -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -jar myapp.jar
    // Q.7 UserDTP
//    public UserDTO getUserDtoById(Long id){
//        return userRepository.findById()
//                .map(userMapper::toDto)
//                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
//    }
}

