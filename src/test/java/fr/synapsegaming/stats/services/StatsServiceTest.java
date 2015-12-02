package fr.synapsegaming.stats.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.synapsegaming.commons.service.AbstractServiceTest;

import fr.synapsegaming.stats.service.StatsService;


public class StatsServiceTest extends AbstractServiceTest {
	
	@Autowired
	StatsService statsService;

	@Test
	public void testlistXMostPlayedClasses() {
		assertTrue(statsService.listXMostPlayedClasses(5).isEmpty() != true);
	}
	
	@Test
	public void testlistXMostPlayedRaces() {
		assertTrue(statsService.listXMostPlayedRaces(5).isEmpty() != true);
	}
	
	@Test
	public void testlistXMostPlayedSpecialization() {
		assertTrue(statsService.listXMostPlayedSpecialization(5).isEmpty() != true);
	}
	
	@Test
	public void testlistUsersWithoutAvatar() {
		assertTrue(statsService.listUsersWithoutAvatar().isEmpty() != true);
	}
	
	@Test
	public void testlistMostActiveUsers() {
		assertTrue(statsService.listMostActiveUsers(10).isEmpty() != true);
	}
	
	

}
