/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.zcu.kiv.eegdatabase.logic.controller.history;

import cz.zcu.kiv.eegdatabase.data.dao.AuthorizationManager;
import cz.zcu.kiv.eegdatabase.data.dao.HistoryDao;
import cz.zcu.kiv.eegdatabase.data.dao.PersonDao;
import cz.zcu.kiv.eegdatabase.data.dao.ResearchGroupDao;
import cz.zcu.kiv.eegdatabase.data.pojo.History;
import cz.zcu.kiv.eegdatabase.data.pojo.Person;
import cz.zcu.kiv.eegdatabase.data.pojo.ResearchGroup;
import cz.zcu.kiv.eegdatabase.logic.commandobjects.ChangeDefaultGroupCommand;
import cz.zcu.kiv.eegdatabase.logic.controller.util.ControllerUtils;
import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author pbruha
 */
public abstract class AbstractHistoryController extends SimpleFormController {

  private Log log = LogFactory.getLog(getClass());
  private AuthorizationManager auth;
  private PersonDao personDao;
  private HistoryDao historyDao;
  private ResearchGroupDao researchGroupDao;

  protected void setDao(ResearchGroupDao researchGroupDao, HistoryDao historyDao, AuthorizationManager auth, PersonDao personDao) {
    this.researchGroupDao = researchGroupDao;
    this.historyDao = historyDao;
    this.auth = auth;
    this.personDao = personDao;
  }

  protected Map setReferenceData(Map map, Choice graphType) {
    int userId;
    Person user = null;
    String authority = null;
    String roleAdmin = "ROLE_ADMIN";
    boolean isGroupAdmin;
    userId = personDao.getLoggedPerson().getPersonId();
    user = personDao.getPerson(ControllerUtils.getLoggedUserName());
    authority = user.getAuthority();
    isGroupAdmin = auth.userIsGroupAdmin();
    map.put("isAdmin", authority.equals(roleAdmin));


    String countOfDownloadedFiles;
    List<History> historyList = null;
    List<History> lastDownloadedFilesHistoryList = null;
    List<DownloadStatistic> topDownloadedFilesList = null;
    List<ResearchGroup> researchGroupList =
            researchGroupDao.getResearchGroupsWhereUserIsGroupAdmin(personDao.getLoggedPerson());
    ResearchGroup defaultGroup = personDao.getLoggedPerson().getDefaultGroup();
    int defaultGroupId = (defaultGroup != null) ? defaultGroup.getResearchGroupId() : 0;

    if (authority.equals(roleAdmin) || isGroupAdmin) {
      if (authority.equals(roleAdmin)) {
        defaultGroupId = 0;
        isGroupAdmin = false;
      }
      historyList = historyDao.getHistory(Choice.DAILY, isGroupAdmin, userId, defaultGroupId);
      lastDownloadedFilesHistoryList = historyDao.getLastDownloadHistory(Choice.DAILY, isGroupAdmin, defaultGroupId);
      topDownloadedFilesList = historyDao.getTopDownloadHistory(Choice.DAILY, isGroupAdmin, defaultGroupId);

      countOfDownloadedFiles = "" + historyList.size();
      map.put("countOfDownloadedFiles", countOfDownloadedFiles);
      map.put("historyList", historyList);
      map.put("topDownloadedFilesList", topDownloadedFilesList);
      map.put("lastDownloadedFilesHistoryList", lastDownloadedFilesHistoryList);
      map.put("defaultGroupId", defaultGroupId);
      map.put("researchGroupList", researchGroupList);
      map.put("access", true);
      return map;
    }
    map.put("access", false);
    return map;
}

protected ModelAndView onSubmit(Choice graphType, ChangeDefaultGroupCommand changeDefaultGroupCommand, ModelAndView mav) {

    List<ResearchGroup> researchGroupList =
            researchGroupDao.getResearchGroupsWhereUserIsGroupAdmin(personDao.getLoggedPerson());

    int defaultGroupId = changeDefaultGroupCommand.getDefaultGroup();
    mav.addObject("defaultGroupId", defaultGroupId);
    mav.addObject("researchGroupList", researchGroupList);
    log.debug("Show selected history");

    String countOfDownloadedFiles;
    int userId;
    List<History> historyList = null;
    Person user = null;
    String authority = null;
    String roleAdmin = "ROLE_ADMIN";
    boolean isGroupAdmin;
    List<History> lastDownloadedFilesHistoryList = null;
    List<DownloadStatistic> topDownloadedFilesList = null;
    userId = personDao.getLoggedPerson().getPersonId();
    user = personDao.getPerson(ControllerUtils.getLoggedUserName());
    authority = user.getAuthority();
    isGroupAdmin = auth.userIsGroupAdmin();
    mav.addObject("changeDefaultGroup", changeDefaultGroupCommand);

    if ((authority.equals(roleAdmin) || isGroupAdmin)) {
      if(changeDefaultGroupCommand.getDefaultGroup() == -1) {
        mav.addObject("access", true);
        mav.addObject("isAdmin", authority.equals(roleAdmin));
        return mav;
      }

      historyList = historyDao.getHistory(Choice.DAILY, isGroupAdmin, userId, changeDefaultGroupCommand.getDefaultGroup());
      lastDownloadedFilesHistoryList = historyDao.getLastDownloadHistory(Choice.DAILY, isGroupAdmin, changeDefaultGroupCommand.getDefaultGroup());
      topDownloadedFilesList = historyDao.getTopDownloadHistory(Choice.DAILY, isGroupAdmin, changeDefaultGroupCommand.getDefaultGroup());

      countOfDownloadedFiles = "" + historyList.size();
      mav.addObject("countOfDownloadedFiles", countOfDownloadedFiles);
      mav.addObject("historyList", historyList);
      mav.addObject("topDownloadedFilesList", topDownloadedFilesList);
      mav.addObject("lastDownloadedFilesHistoryList", lastDownloadedFilesHistoryList);
      mav.addObject("isAdmin", authority.equals(roleAdmin));
      mav.addObject("access", true);
      return mav;
    }
    mav.addObject("access", false);
    return mav;
  }
}