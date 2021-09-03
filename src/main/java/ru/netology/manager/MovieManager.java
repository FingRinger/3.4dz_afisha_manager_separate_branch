package ru.netology.manager;

import ru.netology.domain.Movie;


public class MovieManager { // создаем класс, в котором будут содержаться все методы
    private Movie[] movies = new Movie[0]; // объявляем массив и выделяем в памяти место на массив из 10 эл-ов типа Object
    private int amountOfFilmsToShow = 10;

    public MovieManager(int amountOfFilmsToShow) {
        this.amountOfFilmsToShow = amountOfFilmsToShow;
    }

    public MovieManager() {
    }

    public void add(Movie movie) {  // на вход пойдет один объект класса муви
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getAll() { // выдать последние 10 фильмов в обратном порядке
        int resultLength;
        if (movies.length > amountOfFilmsToShow) {
            resultLength = amountOfFilmsToShow;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength]; // объявляем новый массив, эл-ты которого будут объектами класса Movie
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        // меняем наши элементы
        movies = tmp;
    }

}
