package com.jpaul;

import com.jpaul.dao.impl.DAOManager;
import com.jpaul.model.Category;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    DAOManager daoManager = new DAOManager();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

    /*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    */

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category createCategory(Category category)throws Exception{
        return daoManager.getCategoryDAO().create(category);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category deleteCategory(@PathParam("id") Integer id)throws Exception{
        Category category = new Category();
        category.setIdCategory(id);
        return daoManager.getCategoryDAO().delete(category);
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category gotoId(@PathParam("id") Integer id)throws Exception{
        Category category = new Category();
        category.setIdCategory(id);
        return daoManager.getCategoryDAO().gotoId(category);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> read()throws Exception{
        return daoManager.getCategoryDAO().read();
    }

    @GET
    @Path("/search/{pattern}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> search(@PathParam("pattern") String pattern)throws Exception{
        return daoManager.getCategoryDAO().search(pattern);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category update(Category category)throws Exception{
        return daoManager.getCategoryDAO().update(category);
    }




}
