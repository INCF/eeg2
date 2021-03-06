package cz.zcu.kiv.eegdatabase.data.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.lucene.queryParser.ParseException;

/**
 * Interface for connecting logic and data layer.
 * This interface makes create, showing, delete,
 * read and update data possible.
 * @author Pavel Bořík, A06208
 */
public interface GenericDao <T, PK extends Serializable>{

    /**
     * Create new record (row) in database.
     * @param newInstance - Object that will be created in database
     * @return record (row) saving in database
     */
    PK create(T newInstance);

    /**
     * Method read record (row) in database.
     * Record select in agreement with Primary Key (id).
     * @param id - Id selecting (searching) record
     * @return object that was selected in database in
     * agreement with PK
     */
    T read(PK id);

    /**
     * Method update data in database.
     * @param transientObject - updating object
     */
    void update(T transientObject);

    /**
     * Delete data from database.
     * @param persistentObject - Object that will be deleted from database
     */
    void delete(T persistentObject);

    /**
     * Method gets all records from database.
     * @return list that includes all records
     */
    List<T> getAllRecords();

    /**
     * Get specific count of records from database.
     * Count is given values of params.
     * @param first - first select records (start from grant zero)
     * @param max - count of records
     * @return list that includes specific count of records
     */
    List<T> getRecordsAtSides(int first, int max);

    /**
     * Method gets count of records in database.
     * @return count of records in database
     */
    int getCountRecords();

    public Map<T, String> getFulltextResults(String fullTextQuery) throws ParseException;
}
