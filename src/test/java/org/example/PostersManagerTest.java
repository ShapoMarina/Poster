package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostersManagerTest {
    @Test
    public void shouldAddOneMovies() {
        PostersManager manager = new PostersManager();

        manager.addingMovie("Бладшот");


        String[] actual = manager.findAll();
        String[] expected = {"Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeMovies() {
        PostersManager manager = new PostersManager();

        manager.addingMovie("Бладшот");
        manager.addingMovie("Вперед");
        manager.addingMovie("Отель <<Белград>>");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперед", "Отель <<Белград>>"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTheLatestAddedMovies() {
        PostersManager manager = new PostersManager();

        manager.addingMovie("Бладшот");
        manager.addingMovie("Вперед");
        manager.addingMovie("Отель <<Белград>>");
        manager.addingMovie("Человек-невидимка");

        String[] actual = manager.findLast();
        String[] expected = {"Человек-невидимка", "Отель <<Белград>>", "Вперед", "Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTheLatestAddMovies() {
        PostersManager manager = new PostersManager(3);

        manager.addingMovie("Бладшот");
        manager.addingMovie("Вперед");
        manager.addingMovie("Отель <<Белград>>");
        manager.addingMovie("Человек-невидимка");

        String[] actual = manager.findLast();
        String[] expected = {"Человек-невидимка", "Отель <<Белград>>", "Вперед"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void mustFindTheLastAddedMoviesLessThanTheLimit() {
        PostersManager manager = new PostersManager(3);

        manager.addingMovie("Бладшот");
        manager.addingMovie("Вперед");

        String[] actual = manager.findLast();
        String[] expected = {"Вперед", "Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findTheLatestAddedMoviesInTheAmountOfLimit() {
        PostersManager manager = new PostersManager(3);

        manager.addingMovie("Бладшот");
        manager.addingMovie("Вперед");
        manager.addingMovie("Отель <<Белград>>");


        String[] actual = manager.findLast();
        String[] expected = {"Отель <<Белград>>", "Вперед", "Бладшот"};
        Assertions.assertArrayEquals(expected, actual);
    }
}
