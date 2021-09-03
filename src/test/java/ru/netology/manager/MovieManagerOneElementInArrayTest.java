package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerOneElementInArrayTest {
    private MovieManager manager = new MovieManager();
    private  Movie first = new Movie(1, "ссылка", "Бладшот", "боевик");

    @BeforeEach
    public void SetUp(){
        manager.add(first);
    }

    @Test
    public void shouldAddOneIntoEmpty(){

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTwoEqualElements(){
        manager.add(first);

        Movie[] actual = manager.getAll();
        Movie[] expected =new Movie[]{first,first};
    }
}
