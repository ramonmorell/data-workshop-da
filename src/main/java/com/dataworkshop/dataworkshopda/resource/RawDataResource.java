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

import com.dataworkshop.dataworkshopda.entity.RawData;

/**
 * @author ramon
 *
 */
@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public interface RawDataResource {
	
	@GET
	public Response listData();
	
	@GET
	@Path("/{id}")
	public Response getData(@PathParam("id") long id);
	
	@POST
	public Response setData(RawData rawData);
	
	@PUT
	public Response updateData(RawData rawData);
	
	@DELETE
	@Path("/{id}")
	public Response deleteData(@PathParam("id") long id);
	
	@GET
	@Path("/search/{name}")
	public Response searchData(@PathParam("name") String name);
	

}
