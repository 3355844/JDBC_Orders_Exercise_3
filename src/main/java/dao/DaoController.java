package dao;

/**
 * Created by 33558 on 08.02.2017.
 */
public interface DaoController {
    <T> void add(T t);

    <T> T getById(int id);

    <T> void update(T t);

    <T> void delete(T t);
}
