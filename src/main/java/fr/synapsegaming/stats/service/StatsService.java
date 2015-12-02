package fr.synapsegaming.stats.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

public interface StatsService {

	/**
	 * Donne le nombre de joueurs ayant la meme classe
	 * 
	 * @param classe
     *          : la clazz commune
     *
	 * @return nombre de joueurs
	 */
	public int getNumberOfUsersByClazz(Clazz clazz);

	/**
	 * Donne le nombre de joueurs ayant la meme race
	 * 
	 * @param race
     *          : la race commune
     *
	 * @return nombre de joueurs
	 */
	public int getNumberOfUsersByRace(Race race);

	/**
	 * Donne le nombre de joueurs ayant la meme specialisation
	 * 
	 * @param specialization
     *          : la specialization commune
     *
	 * @return nombre de joueurs
	 */
	public int getNumberOfUsersBySpecialization(Specialization specialization);

	/**
	 * Liste les 5 classes les plus jouées
	 * 
	 * @param nbClasses
     *          : Nombre de classes dans le top
     *
	 * @return HashMap de classe - Integer
	 */
	HashMap<String, Integer> listXMostPlayedClasses(int nbClasses);
	
	/**
	 * Liste les 5 races les plus jouées
	 * 
	 * @param nbClasses
     *          : Nombre de races dans le top
     *          
	 * @return HashMap de race - Integer
	 */
	HashMap<String, Integer> listXMostPlayedRaces(int nbRaces);
	
	/**
	 * Liste les 5 specialisations les plus jouées
	 * 
	 * @param nbClasses
     *          : Nombre de specialisations dans le top
     *          
	 * @return HashMap de specialisation - Integer
	 */
	HashMap<String, Integer> listXMostPlayedSpecialization(int nbSpecializations);

	/**
	 * Liste les utilisateurs sans avatars
     *          
	 * @return Liste d'utilisateurs
	 */
	List<User> listUsersWithoutAvatar();
	
	/**
	 * Liste les utilisateurs les plus actifs sur le site
     *          
	 * @return Liste d'utilisateurs
	 */
	public LinkedHashMap<String, Integer> listMostActiveUsers(int nb);
	
	
	/**
	 * @param user
	 * @return le nombre de points de participation sociale de cet utilisateur
	 */
	int getTotalSocialPoints(User user);

	
}
