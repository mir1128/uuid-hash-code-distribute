package com.company;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<Integer, Long> collect = IntStream.range(0, 1000000)
                .mapToObj(i -> {
                    String s = UUID.randomUUID().toString();
                    return new Pair<>(Math.abs(s.hashCode()) % 100, s);
                })
                .collect(Collectors.groupingBy(p -> p.getKey(), Collectors.counting()));

        System.out.println(collect);
    }
}
