package cz.zcu.kiv.eegdatabase.perf.persistentLayer.lists;

import cz.zcu.kiv.eegdatabase.data.dao.ExperimentOptParamDefDao;
import cz.zcu.kiv.eegdatabase.data.pojo.ExperimentOptParamDef;
import cz.zcu.kiv.eegdatabase.perf.persistentLayer.PerformanceTest;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Richard Kocman,Kabourek
 * Date: 24.5.11
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 * Identificator of test  /PPT_LOPP_6_WorWitOpp_L/. Contains document Testovaci scenare.docx.
 */
public class ExperimentOptParamDefPerformanceTest extends PerformanceTest {

    /**
     * Constant for atribute of test data.
     */
    public static final String EXPERIMENT_OPT_PARAM_DEF_NAME = "testovaci parametr";
    public static final String EXPERIMENT_OPT_PARAM_DEF_DATA_TYPE = "testovaci datatype";


    private ExperimentOptParamDef experimentOptParamDef;
    private ExperimentOptParamDefDao experimentOptParamDefDao;
/**
* Method test create experimentOptParamDef for next test.
*
*/

    public void createTestExperimentOptParamDef(){
        experimentOptParamDef = new ExperimentOptParamDef();
        experimentOptParamDef.setParamName(EXPERIMENT_OPT_PARAM_DEF_NAME);
        experimentOptParamDef.setParamDataType(EXPERIMENT_OPT_PARAM_DEF_DATA_TYPE);

    }

/**
 * Method test create Experiment Opt.
 * Identificator of test /PPT_LOPP_7_AddOpp_F/. Contains document Testovaci scenare.docx.
 */
    @Test
    public void testCreateExperimentOptParamDef(){
       int countRecord = experimentOptParamDefDao.getCountRecords();
       createTestExperimentOptParamDef();
       experimentOptParamDefDao.create(experimentOptParamDef);
         List<ExperimentOptParamDef> list = experimentOptParamDefDao.getItemsForList();
         System.out.println("list je ----"+list.size());
       assertEquals(experimentOptParamDefDao.getCountRecords()-1, countRecord);
        experimentOptParamDefDao.delete(experimentOptParamDef);
    }

/**
 * Method test edit Experiment Opt.
 * Identificator of test / PPT_LOPP_8_EditOpp_F /. Contains document Testovaci scenare.docx.
 */
    @Test
    public void testEditExperimentOptParamDef(){
        List<ExperimentOptParamDef> listRecords;
        createTestExperimentOptParamDef();
        experimentOptParamDef.setParamName(EXPERIMENT_OPT_PARAM_DEF_NAME+"EDITOVANO");
        experimentOptParamDefDao.update(experimentOptParamDef);
        listRecords=experimentOptParamDefDao.getAllRecords();
        //assertEquals(listRecords.get(listRecords.size()-1).getParamName(), experimentOptParamDef.getParamName());

    }
/**
 * Method test delete Experiment Opt.
 * Identificator of test /PPT_LOPP_9_DelOpp_F/. Contains document Testovaci scenare.docx.
 */
    @Test
    public void testDeleteExperimentOptParamDef(){
        int countRecord = experimentOptParamDefDao.getCountRecords();
        createTestExperimentOptParamDef();
        experimentOptParamDefDao.create(experimentOptParamDef);
        experimentOptParamDefDao.delete(experimentOptParamDef);
        assertEquals(experimentOptParamDefDao.getCountRecords(), countRecord);
    }

     /**
     * Setter for DAO object.
     */

     public void setExperimentOptParamDefDao(ExperimentOptParamDefDao experimentOptParamDefDao) {
        this.experimentOptParamDefDao = experimentOptParamDefDao;
    }

}
