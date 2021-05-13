package fr.donododo.nspringfield.registries;

import java.util.ArrayList;
import java.util.List;

public class JobRegistry {
	
	private static ArrayList<NSPjob> jobsRegistered;

	public JobRegistry() {
		
	}
	
	public static void load() {
		
	}
	
	public List<NSPjob> getRegisteredJobs(){
		return jobsRegistered;
	}
	
}
