package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerNotEmptyTest {
    @Test
    public void shouldReverseOrder() {// обратный порядок, по умолчанию выводились последние 10 добавленных фильмов, для массива с 12 элементами
        MovieManager manager = new MovieManager();
        Movie first = new Movie(1, "ссылка", "Бладшот", "боевик");
        Movie second = new Movie(2, "ссылка", "Вперёд", "мультфильм");
        Movie third = new Movie(3, "ссылка", "Отель Белград", "комедия");
        Movie fourth = new Movie(4, "ссылка", "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "ссылка", "Человек-невидимка", "ужасы");
        Movie sixth = new Movie(6, "ссылка", "Тролли.Мировой тур", "мультфильм");
        Movie seventh = new Movie(7, "ссылка", "Номер один", "комедия");
        Movie eighth = new Movie(8, "ссылка", "Главный герой", "фантастика,боевик");
        Movie nineth = new Movie(9, "ссылка", "Отряд самоубийц:Миссия навылет", "боевик,фантастика");
        Movie tenth = new Movie(10, "ссылка", "Пальма", "приключения");
        Movie eleventh = new Movie(11, "ссылка", "Время", "триллер");
        Movie twelve = new Movie(12, "ссылка", "Дом", "триллер");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(nineth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelve);


        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve, eleventh, tenth, nineth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverseOrderForLessThenTen() { //обратный порядок, массив с 4-мя эл-ми
        MovieManager manager = new MovieManager();

        Movie first = new Movie(1, "ссылка", "Бладшот", "боевик");
        Movie second = new Movie(2, "ссылка", "Вперёд", "мультфильм");
        Movie third = new Movie(3, "ссылка", "Отель Белград", "комедия");
        Movie fourth = new Movie(4, "ссылка", "Джентельмены", "боевик");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldChangeAmountOfFilmsToShow() { //проверка возможности изменения количества фильмов на вывод
        MovieManager manager = new MovieManager(5);

        Movie first = new Movie(1, "ссылка", "Бладшот", "боевик");
        Movie second = new Movie(2, "ссылка", "Вперёд", "мультфильм");
        Movie third = new Movie(3, "ссылка", "Отель Белград", "комедия");
        Movie fourth = new Movie(4, "ссылка", "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "ссылка", "Человек-невидимка", "ужасы");
        Movie sixth = new Movie(6, "ссылка", "Тролли.Мировой тур", "мультфильм");
        Movie seventh = new Movie(7, "ссылка", "Номер один", "комедия");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {   // удалить существующий элемент
        MovieManager manager = new MovieManager();
        int idToRemove = 1;                  // определяем id эл-та, который планируем удалить
        Movie first = new Movie(1, "ссылка", "Бладшот", "боевик");
        Movie second = new Movie(2, "ссылка", "Вперёд", "мультфильм");
        Movie third = new Movie(3, "ссылка", "Отель Белград", "комедия");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

        assertArrayEquals(expected, actual);
    }
}