/**
 * 
 */
package com.dataworkshop.dataworkshopda.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dataworkshop.dataworkshopda.entity.AnalysisCategory;

/**
 * @author ramon
 *
 */
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public interface AnalysisCategoryResource {

	@GET
	public Response listCategories();
	
	@GET
	@Path("/{id}")
	public Response getCategory(@PathParam("id") long id);
	
	@POST
	public Response setCategory(AnalysisCategory category);
	
	@PUT
	public Response updateCategory(AnalysisCategory category);
	
	@DELETE
	@Path("/{id}")
	public Response deleteCategory(@PathParam("id") long id);
	
	@GET
	@Path("/search/{name}")
	public Response searchCategories(@PathParam("name") String name);
	
}
