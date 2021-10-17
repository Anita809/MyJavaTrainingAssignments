package com.java.Liscenceonline;


import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
    import javax.ws.rs.core.Response;

	//nouns vs verbs

	//Resource URI

	// http://localhost:8080/Liscencedynamic/rest/application/myapplication
		
	@Path("/application")
	public class ApplyLiscence {
		
		static ArrayList<Liscence> liscenceList = new ArrayList<Liscence>();
		
		static {
			System.out.println("static initializer ...setting up all values...");
			
			Liscence liscence1 = new Liscence();
			liscence1.setLiscenceId(1);
			liscence1.setLiscenceDate("02/10/2020");	
			liscence1.setLiscenceExpiryDate("20/11/2025");
			liscence1.setLiscenceStatus("one year time for renewal");
			
			Liscence liscence2 = new Liscence();
			liscence2.setLiscenceId(2);
			liscence2.setLiscenceDate("10/06/2018");	
			liscence2.setLiscenceExpiryDate("20/11/2023");
			liscence2.setLiscenceStatus("two years time for renewal");
			
			Liscence liscence3 = new Liscence();
			liscence3.setLiscenceId(3);
			liscence3.setLiscenceDate("22/10/2019");	
			liscence3.setLiscenceExpiryDate("20/11/2024");
			liscence3.setLiscenceStatus("three years time for renewal");

			
			Liscence liscence4 = new Liscence();
			liscence1.setLiscenceId(5);
			liscence1.setLiscenceDate("02/10/2016");	
			liscence1.setLiscenceExpiryDate("20/11/2021");
			liscence1.setLiscenceStatus("your liscence is expired please renewal");

			
			Liscence liscence5 = new Liscence();
			liscence1.setLiscenceId(5);
			liscence1.setLiscenceDate("02/10/2017");	
			liscence1.setLiscenceExpiryDate("20/11/2022");
			liscence1.setLiscenceStatus("one year time to renewal");
			
			liscenceList.add(liscence1);  
			liscenceList.add(liscence2);
			liscenceList.add(liscence3);
			liscenceList.add(liscence4);
			liscenceList.add(liscence5);
			
		}
		
		
//		http://localhost:8080/Liscencedynamic/rest/application/myapplication
		@GET
		@Path("/myapplication")
		@Produces(MediaType.APPLICATION_JSON)
		public Liscence apply() {
			
			System.out.println("apply....");
			Liscence liscence = new Liscence();
			liscence.setLiscenceDate("02/10/2017");	
			liscence.setLiscenceExpiryDate("20/11/2022");
			liscence.setLiscenceStatus("one year time to renewal");
			
			return liscence;
		}

	// http://localhost:8080/Liscencedynamic/rest/application/liscenceList
		@GET 
		@Path("/getLiscence")	
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<Liscence> getAllLiscence() {
			System.out.println("getAllLiscence....");
			return liscenceList;
		}
		
		//  http://localhost:8080/Liscencedynamic/rest/application/getLiscence/1
			@GET 
			@Path("/getLiscence/{cid}")	
			@Produces(MediaType.APPLICATION_JSON)
			public Liscence getLiscence(@PathParam("cid") int tempCid) {
				System.out.println("getLiscence...."+tempCid);
				Liscence tempLiscence = null;
				for(Liscence theLiscence  : liscenceList) {
					if(theLiscence.getLiscenceId() == tempCid) {
						tempLiscence = theLiscence;
						break;
					}
				}
				return tempLiscence;
			}
			
		//  http://localhost:8080/Liscencedynamic/rest/application/deleteLiscence/1
				@GET 
				@Path("/deleteLiscence/{cid}")	
				@Produces(MediaType.APPLICATION_JSON)
				public void removeLiscence(@PathParam("cid") int tempCid) {
					System.out.println("deleteLiscence...."+tempCid);		
					for(int i=0;i<liscenceList.size();i++) {
						Liscence liscence = liscenceList.get(i);
						
						if(liscence.getLiscenceId() == tempCid) {
							liscence  = liscenceList.get(i);
							liscenceList.remove(i);
							System.out.println("Liscence removed...");
							break;
						}
					}
				}
				
				@POST 
				@Path("/addLiscence")	
				@Produces(MediaType.APPLICATION_JSON)
				public Response addLiscence(Liscence newLiscence) {
					System.out.println("adding liscense....");
					liscenceList.add(newLiscence);
					return Response.status(1).build();
		
	}
				
				@PUT 
				@Path("/updateLiscence")	
				@Produces(MediaType.APPLICATION_JSON)
				public void modifyLiscence(Liscence liscenceToModify) {
					System.out.println("modifying liscence details...."+liscenceToModify);		
					for(int i=0;i<liscenceList.size();i++) {
						Liscence liscence = liscenceList.get(i);
						System.out.println("liscence to modify is...."+liscenceToModify);	
						
						
						
						if(liscence.getLiscenceId() == liscenceToModify.getLiscenceId()) {
						    liscenceList.remove(liscence);
							liscenceList.add(i, liscenceToModify);
							System.out.println("Liscence details is modified...");
							break;
						}
					}
				}				
	}


