package fr.synapsegaming.stats.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.media.service.ArticleService;
import fr.synapsegaming.ui.service.ResourceService;
import fr.synapsegaming.stats.service.StatsService;


/**
 * <b>HomeController</b> route every action made from the "Home" page
 * 
 * @author Meidi
 * 
 */
@Controller("StatsController")
@SessionAttributes(value = { "resources", "userResources" })
@RequestMapping("/stats")
public class StatsController extends AbstractController {

	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	StatsService statsService;
   
    /**
     * The default constructor to initialize the page
     * 
     * @param request
     *            : the HttpRequest sent
     * @return modelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        page = new ModelAndView();
        page.setViewName("Statistique");
        page.addObject("resources", resourceService.listMainMenu());
        page.addObject("proms", articleService.getFiveLastProms());
        page.addObject("mostPlayedClasses", statsService.listXMostPlayedClasses(5));
        page.addObject("mostPlayedRaces", statsService.listXMostPlayedRaces(5));
        page.addObject("mostPlayedSpecializations", statsService.listXMostPlayedSpecialization(5));
        page.addObject("usersWithoutAvatar", statsService.listUsersWithoutAvatar());
        page.addObject("mostActiveUsers", statsService.listMostActiveUsers(5));
        if (user != null)
            page.addObject("userResources", resourceService.listUserResources(user.getGroup().getId()));
        return page;
    }

    
}
