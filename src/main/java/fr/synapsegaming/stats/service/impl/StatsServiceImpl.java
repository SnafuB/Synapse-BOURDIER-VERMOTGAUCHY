package fr.synapsegaming.stats.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.dao.SpecializationDao;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.stats.service.StatsService;

@Service("StatsService")
public class StatsServiceImpl implements StatsService{

	@Autowired
	ClazzDao clazzDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RaceDao raceDao;
	
	@Autowired
	SpecializationDao specializationDao;


	@Override
	public int getNumberOfUsersByClazz(Clazz clazz){
		return clazz.getUsers().size();
	}
	
	@Override
	public int getNumberOfUsersByRace(Race race){
		return race.getUsers().size();
	}
	
	@Override
	public int getNumberOfUsersBySpecialization(Specialization specialization){
		return specialization.getUsers().size();
	}
	
	@Override
	public LinkedHashMap<String, Integer> listXMostPlayedClasses(int nbClasses) {
		
		HashMap<String, Integer> classUseList = new HashMap<>();
		List<Clazz> classes = clazzDao.list(Clazz.class);
		
		if(nbClasses > classes.size() || nbClasses < 1){
			nbClasses = classes.size();
		}
		for(int i=0; i<classes.size(); i++)
		{
			classUseList.put(classes.get(i).getName(), getNumberOfUsersByClazz(classes.get(i)));
		}
	
		return sortHashMap(classUseList, nbClasses);
	}
	
	@Override
	public LinkedHashMap<String, Integer> listXMostPlayedRaces(int nbRaces) {
		
		HashMap<String, Integer> raceUseList = new LinkedHashMap<>();
		List<Race> races = raceDao.list(Race.class);
		
		for(int i=0; i<races.size(); i++)
		{
			raceUseList.put(races.get(i).getName(), getNumberOfUsersByRace(races.get(i)));
		}
	
		return sortHashMap(raceUseList, nbRaces);
	}

	
	@Override
	public LinkedHashMap<String, Integer> listXMostPlayedSpecialization(int nbSpecializations) {
		
		LinkedHashMap<String, Integer> specializationUseList = new LinkedHashMap<>();
		List<Specialization> specialization = specializationDao.list(Specialization.class);
		
		for(int i=0; i<specialization.size(); i++)
		{
			specializationUseList.put(specialization.get(i).getName(), getNumberOfUsersBySpecialization(specialization.get(i)));
		}
	
		return sortHashMap(specializationUseList, nbSpecializations);
	}

	@Override
	public List<User> listUsersWithoutAvatar(){
		List<User> users = userDao.list(User.class);
		
		List<User> usersWithoutAvatar = new ArrayList<>();
		
		for(int i=0; i<users.size(); i++)
		{
			if( users.get(i).getForumAvatar().contains("/resources/img/default_avatar.png"))
			{
				usersWithoutAvatar.add(users.get(i));
			}
		}
		return usersWithoutAvatar;
	}
	
	@Override
	public LinkedHashMap<String, Integer> listMostActiveUsers(int nb){
		
		List<User> users = userDao.list(User.class);
		LinkedHashMap<String, Integer> Activity = new LinkedHashMap<>();
		
		//int postCoef = 2;
		//int articleCoef = 1;
		
		for(int i=0; i<users.size(); i++)
		{
			//int nbPosts = users.get(i).getPosts().size() * postCoef;
			//int nbArticles = users.get(i).getArticles().size() * articleCoef;
			//int nbReplies = 0;
			//nbArticles = 0;
			//int total = nbPosts + nbArticles + nbReplies;
			int total = getTotalSocialPoints(users.get(i));
			Activity.put(users.get(i).getName(), total);
			
		}
		
		return sortHashMap(Activity, nb);
	}
	
	public int getTotalSocialPoints(User user){

		//int postCoef = 2;
		int articleCoef = 2;
		//int repliesCoef = 3;
		
		//int nbPosts = user.getPosts().size() * postCoef;
		int nbPoints = user.getArticles().size() * articleCoef;
		//int nbReplies = user.getReplies().size() * repliesCoef;
		if( !user.getForumAvatar().contains("/resources/img/default_avatar.png"))
		{
			nbPoints += 10;
		}
		
		return nbPoints;
	}
	
	public LinkedHashMap<String, Integer> sortHashMap(HashMap<String, Integer> entry, int numberSort)
	{
		LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
		if(numberSort > entry.size() || numberSort < 0)
		{
			numberSort = entry.size();
		}

		for(int i=0; i <= numberSort; i++){
			String bestClass = null;
			int bestClassValue=-1;
			
			for(Map.Entry<String, Integer> item:entry.entrySet()) {
				String clazz = item.getKey();
				int value = item.getValue();
				if(value > bestClassValue){
					bestClassValue = value;
					bestClass = clazz;
				}
			}
			if(bestClass != null){
				result.put(bestClass, bestClassValue);
				entry.remove(bestClass);
			}
		}
		return result;
	}
}


