package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testCompareToZero() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Кневичи", "Внуково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 10_500, 10, 20);

        int expected = ticket1.compareTo(ticket2);
        Assertions.assertTrue(expected >= 0);
    }


    @Test
    public void testSortTreeTickets() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Улан-Удэ", "Пулково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 6_500, 10, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Кневичи", "Внуково", 11_500, 15, 17);
        Ticket ticket5 = new Ticket("Пулково", "Краснодар", 9_500, 14, 18);
        Ticket ticket6 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Кневичи", "Внуково");
        Ticket[] expected = {ticket2, ticket6, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicket() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Улан-Удэ", "Пулково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 6_500, 10, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Кневичи", "Внуково", 11_500, 15, 17);
        Ticket ticket5 = new Ticket("Пулково", "Краснодар", 9_500, 14, 18);
        Ticket ticket6 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Пулково", "Краснодар");
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Улан-Удэ", "Пулково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 6_500, 10, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Кневичи", "Внуково", 11_500, 15, 17);
        Ticket ticket5 = new Ticket("Пулково", "Краснодар", 9_500, 14, 18);
        Ticket ticket6 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Санкт-Петербург", "Внуково");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testComparatorOne() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Кневичи", "Внуково", 6_500, 10, 20);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Хибины", "Владикавказ", 11_500, 12, 16);

        int expected1 = comparator.compare(ticket1, ticket2);
        Assertions.assertTrue(expected1 > 0);

        int expected2 = comparator.compare(ticket3, ticket4);
        Assertions.assertTrue(expected2 >= 0);
    }


    @Test
    public void testSortWithComparatorOne() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Улан-Удэ", "Пулково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 6_500, 10, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Кневичи", "Внуково", 11_500, 15, 17);
        Ticket ticket5 = new Ticket("Пулково", "Краснодар", 9_500, 14, 18);
        Ticket ticket6 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Хибины", "Владикавказ", comparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithComparatorZero() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Улан-Удэ", "Пулково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 6_500, 10, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Кневичи", "Внуково", 11_500, 15, 17);
        Ticket ticket5 = new Ticket("Пулково", "Краснодар", 9_500, 14, 18);
        Ticket ticket6 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Хибины", "Владимир", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSortWithComparatorTree() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Улан-Удэ", "Пулково", 10_500, 9, 18);
        Ticket ticket2 = new Ticket("Кневичи", "Внуково", 6_500, 15, 20);
        Ticket ticket3 = new Ticket("Хибины", "Владикавказ", 10_500, 12, 16);
        Ticket ticket4 = new Ticket("Кневичи", "Внуково", 11_500, 11, 17);
        Ticket ticket5 = new Ticket("Пулково", "Краснодар", 9_500, 14, 18);
        Ticket ticket6 = new Ticket("Кневичи", "Внуково", 8_500, 19, 20);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        // Comparator<Ticket> comparator
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy ("Кневичи", "Внуково", comparator);
        Ticket[] expected = {ticket6, ticket2, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }
}