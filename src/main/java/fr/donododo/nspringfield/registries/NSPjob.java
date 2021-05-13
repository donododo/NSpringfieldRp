package fr.donododo.nspringfield.registries;

import java.util.HashMap;

import fr.donododo.nspringfieldrp.core.NSpringfieldRp;
import fr.donododo.nspringfieldrp.players.PlayerProfile;

public class NSPjob {
	
	public String name;
	
	public int salary;
	public int salaryTime;
	public int rpLevelRequired;
	
	public HashMap<NSPjob, Integer> jobExpRequired = new HashMap<NSPjob, Integer>();
	
	public NSPjob(String name, int salary, int salaryTime) {
		this.name = name;
		this.salary = salary;
		this.salaryTime = salaryTime;
	}
	
	// hasAcces : return true if the player have the requirement to be able to use the job
	
	public boolean hasAcces(String uuid) {
		
		PlayerProfile pf = new PlayerProfile(uuid).load(); 
		
		return true;
	}

	
	// Getters
	
	public String getName() { // Return the name of the job
		return name;
	}
	
	public int getSalary() {  // Return the value of the salary the player will receive
		return salary;
	}
	
	public int getSalaryTime() { // Return the defined time limit before the player receive the salary
		return salaryTime;
	}
	
	public int getRpLevelRequired() { // Return the level of rp needed to be able to use the job
		return rpLevelRequired;
	}
	
	public HashMap<NSPjob, Integer> getJobExpRequired() { // Return the requirement to be able to use the job e.g: Need level 5 of policeman job
		return jobExpRequired;
	}
	
	// Getters
	
	// Setters
	
	public String setName(String name) { // Set the name of the job
		return name;
	}
	
	public void setSalary(int salary) {  // Set the value of the salary the player will receive
		this.salary = salary;
	}
	
	public void setSalaryTime(int salaryTime) { // Set the defined time limit before the player receive the salary in seconds
		this.salaryTime = salaryTime;
	}
	
	public void setRpLevelRequired(int rpLevelRequired) { // Set the level of rp needed to be able to use the job
		this.rpLevelRequired = rpLevelRequired;
	}
	
	public void addJobRequirement(NSPjob job, Integer level) { // add a job requirement to be able to use the job e.g: Need level 5 of policeman job
		if(jobExpRequired.containsKey(job)) {
			jobExpRequired.replace(job, level);
		}else {
			jobExpRequired.put(job, level);
		}
	}
	
	// Setters
}
