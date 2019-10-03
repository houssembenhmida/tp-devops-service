package tn.houssem.main.web;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import net.vpc.app.vainruling.core.service.CorePlugin;
import net.vpc.app.vainruling.core.service.model.AppUser;
import net.vpc.app.vainruling.core.web.OnPageLoad;
import net.vpc.app.vainruling.core.web.VrController;
import tn.houssem.main.service.*;

/**
 * MyPage component implementation. A component is an MVC component defining a
 * Controller (this class), a Model (sub class Model) and a view (url path to
 * xhtml file)
 *
 * @author Houssem
 */
@VrController(
        // bind controller to the menu
        menu = "/MyMenu",
        // bind controller to the xhtml page
        url = "modules/main/my-page",
        // define security access user should have to use this component
        securityKey = "Custom.Page.my-page"
)
@Controller
public class MyPageCtrl {

    private static final Logger log = Logger.getLogger(MyPageCtrl.class.getName());
    
    private final Model model = new Model();
    
    @Autowired
    private CorePlugin core;
    
    @Autowired
    private PaasProjectMainPlugin main;
    
    public Model getModel() {
        return model;
    }

    /**
     * Page inititialization. Called when subsequent menu is clicked or the
     * controller is invoked via url /p/MyPage controller url can accept config
     * as json bound to the 'a' http request parameter Example :
     * /p/MyPage?a={'initialCounter':15} When subsequent menu is clicked, config
     * param is passed as bare null!
     *
     * @param conf initialization config.
     */
    @OnPageLoad
    private void init() {
        getModel().setUsers(main.getAllUsers());
    }

    /**
     * Model Class for the current Controller (MVC Pattern enforced)
     */
    public static class Model {
        
        
        private List<AppUser> users;
        
        public List<AppUser> getUsers() {
            return users;
        }
        
        public void setUsers(List<AppUser> users) {
            this.users = users;
        }
        
        
        
    }

    /**
     * Config Class for the current Controller
     */
    
}
