package tn.houssem.main.service;

import java.util.List;
import net.vpc.app.vainruling.core.service.CorePlugin;
import net.vpc.app.vainruling.core.service.plugins.VrPlugin;
import net.vpc.app.vainruling.core.service.plugins.Install;
import net.vpc.app.vainruling.core.service.plugins.Start;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;
import net.vpc.app.vainruling.core.service.model.AppUser;
import net.vpc.upa.UPA;

/**
 * Plugin (Module) Main for application
 * 
 * @author Houssem
 */
@VrPlugin
public class PaasProjectMainPlugin {
    private static final Logger log = Logger.getLogger(PaasProjectMainPlugin.class.getName());

    @Autowired
    private CorePlugin core;

    /**
     * module installation process.
     * Called on application startup when the plugin is first bundled (as dependency) 
     * or when a new version is bundled
     */
    @Install
    private void onInstall() {
        //configure CMS properties
        core.setAppProperty("System.App.Description", null, "PaasProject");
        core.setAppProperty("System.App.Keywords", null, "PaasProject");
        core.setAppProperty("System.App.Title.Major.Main", null, "PaasProject");
        core.setAppProperty("System.App.Title.Major.Secondary", null, "app");
        core.setAppProperty("System.App.Title.Minor.Main", null, "PaasProject");
        core.setAppProperty("System.App.Title.Minor.Secondary", null, "app");
        core.findOrCreateAppDepartment("D", "D", "Department");
        core.findOrCreateArticleDisposition("Services", "Services", "Services");
//        for (int i = 0; i < 10; i++) {
//            AppUser u = new AppUser();
//        u.setEmail("test.test1@test1.com");
//        u.setFullName("test");
//        u.setLogin("test");
//        UPA.getPersistenceUnit().persist(u);
//            
//        }
//        
    }

    /**
     * module initialization process.
     * Called on each application startup (after @Install phase methods if any)
     */
    @Start
    private void onStart() {
    }
    
    
    public List<AppUser> getAllUsers(){
        return UPA.getPersistenceUnit().findAll(AppUser.class);
    }

}