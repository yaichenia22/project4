package dao.interfaces;

import java.util.List;

import entity.Entity;

public interface IDao<T extends Entity> {
	
    /*
     * create entity
     */
    public void add(T entity);

    /*
     * read entity
     */
    public List<T> getAll();

    /*
     * this method take as parameter value of primary key of entity and returns entity
     */
    public T getById(Long id);

    /*
     * update entity
     */
    public void update(T sourceEntity);

    /*
     * delete entity from DB
     */
    public void remove(T entity);
}
